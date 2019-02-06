package h2h;

import java.awt.*;

class Settings {

    private Rectangle backButton = new Rectangle(HeadToHead.WIDTH / 2 - 63,620,130,55);
    private Rectangle fiveQuestionsButton = new Rectangle(610,275,35,30);
    private Rectangle tenQuestionsButton = new Rectangle(650,275,35,30);

    private Rectangle playerOneAnswerOne = new Rectangle(360,482,80,30);
    private Rectangle playerOneAnswerTwo = new Rectangle(490,482,80,30);
    private Rectangle playerOneAnswerThree = new Rectangle(620,482,80,30);
    private Rectangle playerTwoAnswerOne = new Rectangle(360,552,80,30);
    private Rectangle playerTwoAnswerTwo = new Rectangle(490,552,80,30);
    private Rectangle playerTwoAnswerThree = new Rectangle(620,552,80,30);

    void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("Arial", Font.PLAIN, 30);

        // Draw BACK button
        g.setColor(new Color(120,120,120, 140));
        g2d.fill(backButton);
        g.setFont(new Font("Arial", Font.PLAIN, 35));
        g.setColor(Color.WHITE);
        g2d.draw(backButton);
        g.drawString("BACK", backButton.x + 20, backButton.y + 40);


        // DISPLAY THE NUMBER OF QUESTIONS
        drawOutlinedText(g,"Number of questions:",300,300,font,Color.CYAN,new Color(0,130,130));
        if(Game.numberOfQuestions == 5) {
            g.setColor(new Color(0,200,0,150));
            g2d.fill(fiveQuestionsButton);
            g.setColor(new Color(150,150,150,150));
            g2d.fill(tenQuestionsButton);
        } else if(Game.numberOfQuestions == 10) {
            g.setColor(new Color(0,200,0,150));
            g2d.fill(tenQuestionsButton);
            g.setColor(new Color(150,150,150,150));
            g2d.fill(fiveQuestionsButton);
        }

        Menu.drawCenteredString(g,"5",fiveQuestionsButton,new Font("Arial", Font.PLAIN, 23),Color.BLACK);
        Menu.drawCenteredString(g,"10",tenQuestionsButton,new Font("Arial", Font.PLAIN, 23),Color.BLACK);

        g.setColor(new Color(35,35,35));
        g2d.draw(fiveQuestionsButton);
        g2d.draw(tenQuestionsButton);

        // DISPLAY THE DIFFICULTY
        drawOutlinedText(g,"CHOOSE DIFFICULTY",325,350,new Font("Arial",Font.PLAIN,35),Color.CYAN,new Color(0,130,130));
        if(HeadToHead.difficulty == HeadToHead.DIFFICULTY.EASY) {
            g.setColor(new Color(0,200,0,150));
            g2d.fillOval(365,370,130,60);
            g.setColor(new Color(150,150,150,150));
            g2d.fillOval(525,370,130,60);
        } else if(HeadToHead.difficulty == HeadToHead.DIFFICULTY.HARD) {
            g.setColor(new Color(0,200,0,150));
            g2d.fillOval(525,370,130,60);
            g.setColor(new Color(150,150,150,150));
            g2d.fillOval(365,370,130,60);
        }

        Menu.drawCenteredString(g,"EASY",new Rectangle(365,370,130,60),new Font("Arial", Font.PLAIN, 28),Color.BLACK);
        Menu.drawCenteredString(g,"HARD",new Rectangle(525,370,130,60),new Font("Arial", Font.PLAIN, 28),Color.BLACK);

        g.setColor(new Color(35,35,35));
        g2d.drawOval(365,370,130,60); // EASY BUTTON
        g2d.drawOval(525,370,130,60); // HARD BUTTON

        // CHOOSE PLAYING KEYS
        drawOutlinedText(g,"Change answer keys for " + Game.nick1,335,470,new Font("Arial",Font.PLAIN,25),Color.BLACK,new Color(150,150,150,150));
        drawOutlinedText(g,"1:",335,508,new Font("Arial",Font.PLAIN,27),Color.CYAN,new Color(0,130,130));
        drawOutlinedText(g,"2:",460,508,new Font("Arial",Font.PLAIN,27),Color.CYAN,new Color(0,130,130));
        drawOutlinedText(g,"3:",590,508,new Font("Arial",Font.PLAIN,27),Color.CYAN,new Color(0,130,130));
        drawOutlinedText(g,"Change answer keys for " + Game.nick2,335,540,new Font("Arial",Font.PLAIN,25),Color.BLACK,new Color(150,150,150,150));
        drawOutlinedText(g,"1:",335,578,new Font("Arial",Font.PLAIN,27),Color.CYAN,new Color(0,130,130));
        drawOutlinedText(g,"2:",460,578,new Font("Arial",Font.PLAIN,27),Color.CYAN,new Color(0,130,130));
        drawOutlinedText(g,"3:",590,578,new Font("Arial",Font.PLAIN,27),Color.CYAN,new Color(0,130,130));

        if(HeadToHead.keyChange == HeadToHead.KEY_CHANGE.OFF) {
            fillAnswersWithColor(g,playerOneAnswerOne,playerOneAnswerTwo,playerOneAnswerThree,new Color(80,80,80,130),new Color(80,80,80,130));
            fillAnswersWithColor(g,playerTwoAnswerOne,playerTwoAnswerTwo,playerTwoAnswerThree,new Color(80,80,80,130),new Color(80,80,80,130));

            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerOne,playerOneAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerTwo,playerOneAnswerTwo,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerThree,playerOneAnswerThree,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerOne,playerTwoAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerTwo,playerTwoAnswerTwo,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerThree,playerTwoAnswerThree,new Font("Arial",Font.PLAIN,20));

        } else if(HeadToHead.keyChange == HeadToHead.KEY_CHANGE.PLAYER1A) {
            fillAnswersWithColor(g,playerOneAnswerOne,playerOneAnswerTwo,playerOneAnswerThree,new Color(0,200,200,150),new Color(80,80,80,130));
            Menu.drawCenteredString(g,"?",playerOneAnswerOne,new Font("Arial",Font.PLAIN,20),Color.BLACK);
            fillAnswersWithColor(g,playerTwoAnswerOne,playerTwoAnswerTwo,playerTwoAnswerThree,new Color(80,80,80,130),new Color(80,80,80,130));

            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerTwo,playerOneAnswerTwo,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerThree,playerOneAnswerThree,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerOne,playerTwoAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerTwo,playerTwoAnswerTwo,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerThree,playerTwoAnswerThree,new Font("Arial",Font.PLAIN,20));

        } else if(HeadToHead.keyChange == HeadToHead.KEY_CHANGE.PLAYER1B) {
            fillAnswersWithColor(g,playerOneAnswerTwo,playerOneAnswerOne,playerOneAnswerThree,new Color(0,200,200,150),new Color(80,80,80,130));
            Menu.drawCenteredString(g,"?",playerOneAnswerTwo,new Font("Arial",Font.PLAIN,20),Color.BLACK);
            fillAnswersWithColor(g,playerTwoAnswerOne,playerTwoAnswerTwo,playerTwoAnswerThree,new Color(80,80,80,130),new Color(80,80,80,130));

            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerOne,playerOneAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerThree,playerOneAnswerThree,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerOne,playerTwoAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerTwo,playerTwoAnswerTwo,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerThree,playerTwoAnswerThree,new Font("Arial",Font.PLAIN,20));

        } else if(HeadToHead.keyChange == HeadToHead.KEY_CHANGE.PLAYER1C) {
            fillAnswersWithColor(g,playerOneAnswerThree,playerOneAnswerOne,playerOneAnswerTwo,new Color(0,200,200,150),new Color(80,80,80,130));
            Menu.drawCenteredString(g,"?",playerOneAnswerThree,new Font("Arial",Font.PLAIN,20),Color.BLACK);
            fillAnswersWithColor(g,playerTwoAnswerOne,playerTwoAnswerTwo,playerTwoAnswerThree,new Color(80,80,80,130),new Color(80,80,80,130));

            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerOne,playerOneAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerTwo,playerOneAnswerTwo,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerOne,playerTwoAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerTwo,playerTwoAnswerTwo,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerThree,playerTwoAnswerThree,new Font("Arial",Font.PLAIN,20));

        } else if(HeadToHead.keyChange == HeadToHead.KEY_CHANGE.PLAYER2A) {
            fillAnswersWithColor(g,playerTwoAnswerOne,playerTwoAnswerTwo,playerTwoAnswerThree,new Color(0,200,200,150),new Color(80,80,80,130));
            Menu.drawCenteredString(g,"?",playerTwoAnswerOne,new Font("Arial",Font.PLAIN,20),Color.BLACK);
            fillAnswersWithColor(g,playerOneAnswerOne,playerOneAnswerTwo,playerOneAnswerThree,new Color(80,80,80,130),new Color(80,80,80,130));

            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerOne,playerOneAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerTwo,playerOneAnswerTwo,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerThree,playerOneAnswerThree,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerTwo,playerTwoAnswerTwo,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerThree,playerTwoAnswerThree,new Font("Arial",Font.PLAIN,20));

        } else if(HeadToHead.keyChange == HeadToHead.KEY_CHANGE.PLAYER2B) {
            fillAnswersWithColor(g,playerTwoAnswerTwo,playerTwoAnswerOne,playerTwoAnswerThree,new Color(0,200,200,150),new Color(80,80,80,130));
            Menu.drawCenteredString(g,"?",playerTwoAnswerTwo,new Font("Arial",Font.PLAIN,20),Color.BLACK);
            fillAnswersWithColor(g,playerOneAnswerOne,playerOneAnswerTwo,playerOneAnswerThree,new Color(80,80,80,130),new Color(80,80,80,130));

            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerOne,playerOneAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerTwo,playerOneAnswerTwo,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerThree,playerOneAnswerThree,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerOne,playerTwoAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerThree,playerTwoAnswerThree,new Font("Arial",Font.PLAIN,20));

        } else if(HeadToHead.keyChange == HeadToHead.KEY_CHANGE.PLAYER2C) {
            fillAnswersWithColor(g,playerTwoAnswerThree,playerTwoAnswerOne,playerTwoAnswerTwo,new Color(0,200,200,150),new Color(80,80,80,130));
            Menu.drawCenteredString(g,"?",playerTwoAnswerThree,new Font("Arial",Font.PLAIN,20),Color.BLACK);
            fillAnswersWithColor(g,playerOneAnswerOne,playerOneAnswerTwo,playerOneAnswerThree,new Color(80,80,80,130),new Color(80,80,80,130));

            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerOne,playerOneAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerTwo,playerOneAnswerTwo,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerOneAnswerThree,playerOneAnswerThree,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerOne,playerTwoAnswerOne,new Font("Arial",Font.PLAIN,20));
            drawChosenKey(g,KeyInput.keyEventPlayerTwoAnswerTwo,playerTwoAnswerTwo,new Font("Arial",Font.PLAIN,20));

        }

        g.setColor(new Color(35,35,35));
        g2d.draw(playerOneAnswerOne);
        g2d.draw(playerOneAnswerTwo);
        g2d.draw(playerOneAnswerThree);

        g.setColor(new Color(35,35,35));
        g2d.draw(playerTwoAnswerOne);
        g2d.draw(playerTwoAnswerTwo);
        g2d.draw(playerTwoAnswerThree);
    }

    private void drawOutlinedText(Graphics g, String text, int x, int y, Font font, Color colorIn, Color colorOut) {
        g.setFont(font);
        g.setColor(colorOut);

        g.drawString(text,x+1,y-1);
        g.drawString(text,x+1,y+1);
        g.drawString(text,x-1,y+1);
        g.drawString(text,x-1,y-1);

        g.setColor(colorIn);
        g.drawString(text,x,y);
    }

    private void fillAnswersWithColor(Graphics g, Rectangle pushedRect, Rectangle rect2, Rectangle rect3, Color pushedColor, Color defaultColor) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(pushedColor);
        g2d.fill(pushedRect);
        g.setColor(defaultColor);
        g2d.fill(rect2);
        g2d.fill(rect3);
    }

    private void drawChosenKey(Graphics g, int key, Rectangle rect, Font font) {
        String keyString;
        if(key > 95) key -= 48;
        keyString = Character.toString((char)key);

        Menu.drawCenteredString(g,keyString,rect,font,Color.WHITE);
    }
}