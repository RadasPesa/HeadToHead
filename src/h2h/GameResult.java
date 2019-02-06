package h2h;

import java.awt.*;


class GameResult {

    static int expectedResult = 0;
    static int actualResult = 0;
    static int playerWhoAnswered = 0;
    static boolean answeredRight = false;
    static boolean scoreChanged = false;

    void tick() {
        if(Game.questionNumber == (Game.numberOfQuestions - 1) && DisplayTimer.resultSecondsRemaining <= 1) {
            Game.questionNumber = 0;
            if(Game.scoreOfFirstPlayer > Game.scoreOfSecondPlayer) {
                GameEnded.winnerNick = Game.nick1;
                GameEnded.winnerPoints = Game.scoreOfFirstPlayer;
            } else if(Game.scoreOfFirstPlayer < Game.scoreOfSecondPlayer) {
                GameEnded.winnerNick = Game.nick2;
                GameEnded.winnerPoints = Game.scoreOfSecondPlayer;
            } else if(Game.scoreOfFirstPlayer.equals(Game.scoreOfSecondPlayer)) {
                GameEnded.winnerNick = "NONE";
                GameEnded.winnerPoints = -1;
            }
            HeadToHead.state = HeadToHead.STATE.GAME_ENDED;
        }
        if(DisplayTimer.resultSecondsRemaining <= 0) {
            /**
             * RESULT WATCHING OVER!!! NEXT QUESTION BEGINS
             */
            DisplayTimer.resultSecondsRemaining = 5;

            Game.questionNumber++;

            HeadToHead.state = HeadToHead.STATE.GAME;
        }
        if(expectedResult == actualResult) {
            answeredRight = true;
        } else answeredRight = false;

        if(DisplayTimer.resultSecondsRemaining == 5) {
            if(playerWhoAnswered == 1 && answeredRight && !scoreChanged) {
                Game.scoreOfFirstPlayer++;
                scoreChanged = true;
            }
            else if(playerWhoAnswered == 1 && !answeredRight && !scoreChanged) {
                Game.scoreOfFirstPlayer--;
                scoreChanged = true;
            }
            else if(playerWhoAnswered == 2 && answeredRight && !scoreChanged) {
                Game.scoreOfSecondPlayer++;
                scoreChanged = true;
            }
            else if(playerWhoAnswered == 2 && !answeredRight && !scoreChanged) {
                Game.scoreOfSecondPlayer--;
                scoreChanged = true;
            }
        }
    }

    void render(Graphics g) {

        Font playerFont = new Font("Arial", Font.PLAIN, 28);
        Font resultFont = new Font("Calibri", Font.PLAIN, 37);

        // Display score of each player
        g.setFont(new Font("Arial", Font.PLAIN, 34));
        g.setColor(Color.WHITE);
        g.drawString(Game.scoreOfFirstPlayer.toString(),117,758);
        g.drawString(Game.scoreOfSecondPlayer.toString(),977,758);

        // Display nick of each player
        Menu.drawCenteredString(g,Game.nick1,new Rectangle(2,80,150,50),playerFont,Color.BLACK);
        Menu.drawCenteredString(g,Game.nick2,new Rectangle(870,80,150,50),playerFont,Color.BLACK);

        // Display result of the answer
        if(answeredRight) {
            if(playerWhoAnswered == 1) {
                Menu.drawCenteredString(g,Game.nick1 + " answered",new Rectangle(340,350,350,60),resultFont,Color.WHITE);
                Menu.drawCenteredString(g,"CORRECTLY",new Rectangle(340,400,350,60),resultFont,Color.GREEN);
            } else if(playerWhoAnswered == 2) {
                Menu.drawCenteredString(g,Game.nick2 + " answered",new Rectangle(340,350,350,60),resultFont,Color.WHITE);
                Menu.drawCenteredString(g,"CORRECTLY",new Rectangle(340,400,350,60),resultFont,Color.GREEN);
            }
        } else {
            if(expectedResult == -1) {
                Menu.drawCenteredString(g,"TIMES OUT!",new Rectangle(340,380,350,60),resultFont,Color.WHITE);
            } else {
                if(playerWhoAnswered == 1) {
                    Menu.drawCenteredString(g,Game.nick1 + " answered",new Rectangle(340,350,350,60),resultFont,Color.WHITE);
                    Menu.drawCenteredString(g,"INCORRECTLY",new Rectangle(340,400,350,60),resultFont,Color.RED);
                } else if(playerWhoAnswered == 2) {
                    Menu.drawCenteredString(g,Game.nick2 + " answered",new Rectangle(340,350,350,60),resultFont,Color.WHITE);
                    Menu.drawCenteredString(g,"INCORRECTLY",new Rectangle(340,400,350,60),resultFont,Color.RED);
                }
            }
        }
    }
}