package h2h;

import java.awt.*;

class GameEnded {

    private Rectangle menuButton = new Rectangle(HeadToHead.WIDTH / 2 - 63,550,130,55);

    static String winnerNick = "";
    static Integer winnerPoints = 0;

    void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Display MENU button
        g.setColor(new Color(120,120,120, 120));
        g2d.fill(menuButton);
        g.setColor(Color.WHITE);
        g2d.draw(menuButton);
        g.setFont(new Font("Arial", Font.PLAIN, 35));
        g.drawString("MENU", menuButton.x + 14, menuButton.y + 40);

        // Display the winner
        g.setFont(new Font("Arial", Font.PLAIN, 35));
        g.setColor(Color.GREEN);

        Menu.drawCenteredString(g,winnerNick,new Rectangle(430,262,169,50),new Font("Arial", Font.PLAIN, 33),Color.GREEN);

        if(winnerPoints != -1) {
            g.setFont(new Font("Arial", Font.PLAIN, 42));
            g.drawString(winnerPoints.toString(),500,410);
        } else g.drawString("IT'S A TIE!",440,400);
    }
}