package h2h;

import java.awt.*;

class DisplayTimer {

    static Integer gameSecondsRemaining = 15;
    static Integer loadingSecondsRemaining = 3;
    static Integer resultSecondsRemaining = 5;

    private String timeLeft = "";

    void gameRender(Graphics g) {
        Font font = new Font("Arial", Font.PLAIN, 35);
        g.setFont(font);
        g.setColor(Color.WHITE);

        timeLeft = gameSecondsRemaining.toString();

        g.drawString(timeLeft,505,695);
    }

    void loadRender(Graphics g) {
        Font font = new Font("Arial", Font.PLAIN, 200);
        g.setFont(font);
        g.setColor(Color.GREEN);

        timeLeft = loadingSecondsRemaining.toString();

        g.drawString(timeLeft,470,420);
    }

    void resultRender(Graphics g) {
        Font font = new Font("Arial", Font.PLAIN, 35);
        g.setFont(font);
        g.setColor(Color.YELLOW);

        timeLeft = resultSecondsRemaining.toString();

        g.drawString(timeLeft,632,562);
    }
}