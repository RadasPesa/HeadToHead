package h2h;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private static int numberOfQuestionsInDatabase = 41;

    static String nick1 = "Player 1";
    static String nick2 = "Player 2";

    public static int id[] = new int[numberOfQuestionsInDatabase];
    static String[] question = new String[numberOfQuestionsInDatabase];
    static String[] answer1 = new String[numberOfQuestionsInDatabase];
    static String[] answer2 = new String[numberOfQuestionsInDatabase];
    static String[] answer3 = new String[numberOfQuestionsInDatabase];

    private static String[] questionInGame;
    private static String[] answer1InGame;
    private static String[] answer2InGame;
    private static String[] answer3InGame;

    static int questionNumber = 0;

    static Integer scoreOfFirstPlayer = 0;
    static Integer scoreOfSecondPlayer = 0;

    static int numberOfQuestions = 5;

    Game() {
    }

    void tick() {
        GameResult.scoreChanged = false;
        if(DisplayTimer.gameSecondsRemaining <= 0) {
            /**
             * TIME'S OVER!!!
             */
            DisplayTimer.gameSecondsRemaining = 15;
            GameResult.playerWhoAnswered = 0;
            GameResult.expectedResult = -1;
            HeadToHead.state = HeadToHead.STATE.GAME_RESULT;
        }
        GameResult.actualResult = getRightAnswer();
        GameResult.answeredRight = false;
    }

    void render(Graphics g) {

        Font answerFont = new Font("Calibri", Font.PLAIN, 25);
        Font questionFont = new Font("Calibri", Font.PLAIN, 25);
        Font playerFont = new Font("Arial", Font.PLAIN, 28);

        // Display score of each player
        g.setFont(new Font("Arial", Font.PLAIN, 34));
        g.setColor(Color.WHITE);
        g.drawString(scoreOfFirstPlayer.toString(),117,758);
        g.drawString(scoreOfSecondPlayer.toString(),977,758);

        // Display nick of each player
        Menu.drawCenteredString(g,nick1,new Rectangle(2,80,150,50),playerFont,Color.BLACK);
        Menu.drawCenteredString(g,nick2,new Rectangle(870,80,150,50),playerFont,Color.BLACK);

        // Display question
        String[] tmp;
        tmp = loadNextQuestion();
        if(tmp.length == 1) {
            Menu.drawCenteredString(g,tmp[0],new Rectangle(300,65,427,104),questionFont,Color.BLACK);
        } else if(tmp.length == 2) {
            Menu.drawCenteredString(g,tmp[0],new Rectangle(300,75,427,50),questionFont,Color.BLACK);
            Menu.drawCenteredString(g,tmp[1],new Rectangle(300,115,427,50),questionFont,Color.BLACK);
        }

        // Display answers
        Menu.drawCenteredString(g,answer1InGame[questionNumber].substring(1),new Rectangle(338,255,350,65),answerFont,Color.BLACK);
        Menu.drawCenteredString(g,answer2InGame[questionNumber].substring(1),new Rectangle(338,398,350,65),answerFont,Color.BLACK);
        Menu.drawCenteredString(g,answer3InGame[questionNumber].substring(1),new Rectangle(338,542,350,65),answerFont,Color.BLACK);
    }

    private static String[] loadNextQuestion() {
        String res[];
        String q = questionInGame[questionNumber];
        int questionRows;

        if(q.length() >= 30) {
            questionRows = 2;
            res = new String[questionRows];

            int tmp = q.length() / 2;
            for (int i = q.length() / 2; i < q.length(); i++) {
                if(q.charAt(i) == ' ') {
                    tmp = i;
                    break;
                }
            }

            res[0] = q.substring(0, tmp);
            res[1] = q.substring(tmp);
        } else {
            questionRows = 1;
            res = new String[questionRows];
            res[0] = q;
        }

        return res;
    }

    private int getRightAnswer() {
        if(answer1InGame[questionNumber].charAt(0) == 'T') {
            return 1;
        } else if(answer2InGame[questionNumber].charAt(0) == 'T') {
            return 2;
        } else if(answer3InGame[questionNumber].charAt(0) == 'T') {
            return 3;
        } else return -1;
    }

    static void getRandomQuestions(HeadToHead.DIFFICULTY difficulty) {
        int[] idInGame = new int[numberOfQuestions];
        questionInGame = new String[numberOfQuestions];
        answer1InGame = new String[numberOfQuestions];
        answer2InGame = new String[numberOfQuestions];
        answer3InGame = new String[numberOfQuestions];

        int questionsStart, questionsEnd;

        if(difficulty == HeadToHead.DIFFICULTY.EASY) {
            questionsStart = 0;
            questionsEnd = 21;
        } else if(difficulty == HeadToHead.DIFFICULTY.HARD) {
            questionsStart = 21;
            questionsEnd = 41;
        } else {
            questionsStart = 0;
            questionsEnd = numberOfQuestionsInDatabase;
        }

        for(int i = 0; i < numberOfQuestions; i++) {
            boolean idAlreadyTaken = false;
            int randomNum = ThreadLocalRandom.current().nextInt(questionsStart,questionsEnd);
            for(int j = 0; j < idInGame.length; j++) {
                if(randomNum == idInGame[j]) {
                    i--;
                    idAlreadyTaken = true;
                    break;
                }
            }
            if(!idAlreadyTaken) {
                idInGame[i] = id[randomNum];
                questionInGame[i] = question[randomNum];
                answer1InGame[i] = answer1[randomNum];
                answer2InGame[i] = answer2[randomNum];
                answer3InGame[i] = answer3[randomNum];
            }
        }
    }
}