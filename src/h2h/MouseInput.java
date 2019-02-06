package h2h;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        /**
         * MENU BUTTONS
         */
        if(HeadToHead.state == HeadToHead.STATE.MENU) {
            // PLAY BUTTON
            if(mx >= HeadToHead.WIDTH / 2 - 63 && mx <= HeadToHead.WIDTH / 2 + 67) {
                if(my >= 300 && my <= 355) {
                    HeadToHead.state = HeadToHead.STATE.LOADING;
                }
            }
            // ABOUT BUTTON
            if(mx >= HeadToHead.WIDTH / 2 - 63 && mx <= HeadToHead.WIDTH / 2 + 67) {
                if(my >= 400 && my <= 455) {
                    HeadToHead.state = HeadToHead.STATE.ABOUT;
                }
            }
            // SETTINGS BUTTON
            if(mx >= HeadToHead.WIDTH / 2 - 72 && mx <= HeadToHead.WIDTH / 2 + 78) {
                if(my >= 500 && my <= 555) {
                    HeadToHead.state = HeadToHead.STATE.SETTINGS;
                }
            }
            // EXIT BUTTON
            if(mx >= HeadToHead.WIDTH / 2 - 63 && mx <= HeadToHead.WIDTH / 2 + 67) {
                if(my >= 600 && my <= 655) {
                    System.exit(1);
                }
            }
        }

        /**
         * SETTINGS BUTTONS
         */
        if(HeadToHead.state == HeadToHead.STATE.SETTINGS) {
            // BACK BUTTON
            if(mx >= HeadToHead.WIDTH / 2 - 63 && mx <= HeadToHead.WIDTH / 2 + 67) {
                if(my >= 620 && my <= 675) {
                    HeadToHead.state = HeadToHead.STATE.MENU;
                    HeadToHead.keyChange = HeadToHead.KEY_CHANGE.OFF;
                }
            }
            // NUMBER OF QUESTIONS BUTTON FOR 5
            if(mx >= 610 && mx <= 645) {
                if(my >= 275 && my <= 305) {
                    Game.numberOfQuestions = 5;
                }
            }
            // NUMBER OF QUESTIONS BUTTON FOR 10
            if(mx >= 650 && mx <= 685) {
                if(my >= 275 && my <= 305) {
                    Game.numberOfQuestions = 10;
                }
            }
            // DIFFICULTY BUTTON EASY
            if(mx >= 365 && mx <= 495) {
                if(my >= 370 && my <= 430) {
                    HeadToHead.difficulty = HeadToHead.DIFFICULTY.EASY;
                }
            }
            // DIFFICULTY BUTTON HARD
            if(mx >= 525 && mx <= 655) {
                if(my >= 370 && my <= 430) {
                    HeadToHead.difficulty = HeadToHead.DIFFICULTY.HARD;
                }
            }
            // CHANGE KEY PLAYER 1 ANSWER 1
            if(mx >= 360 && mx <= 440) {
                if(my >= 482 && my <= 512) {
                    HeadToHead.keyChange = HeadToHead.KEY_CHANGE.PLAYER1A;
                }
            }
            // CHANGE KEY PLAYER 1 ANSWER 2
            if(mx >= 490 && mx <= 570) {
                if(my >= 482 && my <= 512) {
                    HeadToHead.keyChange = HeadToHead.KEY_CHANGE.PLAYER1B;
                }
            }
            // CHANGE KEY PLAYER 1 ANSWER 3
            if(mx >= 620 && mx <= 700) {
                if(my >= 482 && my <= 512) {
                    HeadToHead.keyChange = HeadToHead.KEY_CHANGE.PLAYER1C;
                }
            }
            // CHANGE KEY PLAYER 2 ANSWER 1
            if(mx >= 360 && mx <= 440) {
                if(my >= 552 && my <= 582) {
                    HeadToHead.keyChange = HeadToHead.KEY_CHANGE.PLAYER2A;
                }
            }
            // CHANGE KEY PLAYER 2 ANSWER 2
            if(mx >= 490 && mx <= 570) {
                if(my >= 552 && my <= 582) {
                    HeadToHead.keyChange = HeadToHead.KEY_CHANGE.PLAYER2B;
                }
            }
            // CHANGE KEY PLAYER 2 ANSWER 3
            if(mx >= 620 && mx <= 700) {
                if(my >= 552 && my <= 582) {
                    HeadToHead.keyChange = HeadToHead.KEY_CHANGE.PLAYER2C;
                }
            }
        }

        /**
         * ABOUT BUTTONS
         */
        if(HeadToHead.state == HeadToHead.STATE.ABOUT) {
            // BACK BUTTON
            if(mx >= HeadToHead.WIDTH / 2 - 63 && mx <= HeadToHead.WIDTH / 2 + 67) {
                if(my >= 600 && my <= 655) {
                    HeadToHead.state = HeadToHead.STATE.MENU;
                }
            }
        }

        /**
         * GAME ENDED BUTTONS
         */
        if(HeadToHead.state == HeadToHead.STATE.GAME_ENDED) {
            // BACK BUTTON
            if(mx >= HeadToHead.WIDTH / 2 - 63 && mx <= HeadToHead.WIDTH / 2 + 67) {
                if(my >= 550 && my <= 605) {
                    HeadToHead.state = HeadToHead.STATE.MENU;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
