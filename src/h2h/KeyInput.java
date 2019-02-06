package h2h;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    static int keyEventPlayerOneAnswerOne = KeyEvent.VK_A;
    static int keyEventPlayerOneAnswerTwo = KeyEvent.VK_S;
    static int keyEventPlayerOneAnswerThree = KeyEvent.VK_D;
    static int keyEventPlayerTwoAnswerOne = KeyEvent.VK_NUMPAD1;
    static int keyEventPlayerTwoAnswerTwo = KeyEvent.VK_NUMPAD2;
    static int keyEventPlayerTwoAnswerThree = KeyEvent.VK_NUMPAD3;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Game.questionNumber = 0;
            HeadToHead.state = HeadToHead.STATE.MENU;
        }

        if(HeadToHead.state == HeadToHead.STATE.GAME) {
            if(e.getKeyCode() == keyEventPlayerOneAnswerOne) {
                GameResult.expectedResult = 1;
                GameResult.playerWhoAnswered = 1;
                HeadToHead.state = HeadToHead.STATE.GAME_RESULT;
            }
            if(e.getKeyCode() == keyEventPlayerOneAnswerTwo) {
                GameResult.expectedResult = 2;
                GameResult.playerWhoAnswered = 1;
                HeadToHead.state = HeadToHead.STATE.GAME_RESULT;
            }
            if(e.getKeyCode() == keyEventPlayerOneAnswerThree) {
                GameResult.expectedResult = 3;
                GameResult.playerWhoAnswered = 1;
                HeadToHead.state = HeadToHead.STATE.GAME_RESULT;
            }
            if(e.getKeyCode() == keyEventPlayerTwoAnswerOne) {
                GameResult.expectedResult = 1;
                GameResult.playerWhoAnswered = 2;
                HeadToHead.state = HeadToHead.STATE.GAME_RESULT;
            }
            if(e.getKeyCode() == keyEventPlayerTwoAnswerTwo) {
                GameResult.expectedResult = 2;
                GameResult.playerWhoAnswered = 2;
                HeadToHead.state = HeadToHead.STATE.GAME_RESULT;
            }
            if(e.getKeyCode() == keyEventPlayerTwoAnswerThree) {
                GameResult.expectedResult = 3;
                GameResult.playerWhoAnswered = 2;
                HeadToHead.state = HeadToHead.STATE.GAME_RESULT;
            }
        }

        switch (HeadToHead.keyChange) {
            case OFF:
                break;
            case PLAYER1A:
                keyEventPlayerOneAnswerOne = e.getKeyCode();
                HeadToHead.keyChange = HeadToHead.KEY_CHANGE.OFF;
                break;
            case PLAYER1B:
                keyEventPlayerOneAnswerTwo = e.getKeyCode();
                HeadToHead.keyChange = HeadToHead.KEY_CHANGE.OFF;
                break;
            case PLAYER1C:
                keyEventPlayerOneAnswerThree = e.getKeyCode();
                HeadToHead.keyChange = HeadToHead.KEY_CHANGE.OFF;
                break;
            case PLAYER2A:
                keyEventPlayerTwoAnswerOne = e.getKeyCode();
                HeadToHead.keyChange = HeadToHead.KEY_CHANGE.OFF;
                break;
            case PLAYER2B:
                keyEventPlayerTwoAnswerTwo = e.getKeyCode();
                HeadToHead.keyChange = HeadToHead.KEY_CHANGE.OFF;
                break;
            case PLAYER2C:
                keyEventPlayerTwoAnswerThree = e.getKeyCode();
                HeadToHead.keyChange = HeadToHead.KEY_CHANGE.OFF;
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}