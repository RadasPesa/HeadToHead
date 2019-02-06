package h2h;

import java.awt.*;

class About {

    private Rectangle backButton = new Rectangle(HeadToHead.WIDTH / 2 - 63,600,130,55);

    void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("Arial", Font.PLAIN, 35);

        g.setColor(new Color(120,120,120, 140));
        g2d.fill(backButton);

        g.setFont(font);
        g.setColor(Color.WHITE);

        g2d.draw(backButton);
        g.drawString("BACK", backButton.x + 20, backButton.y + 40);

        // DOPLNIT INFO O HŘE

        g.setFont(new Font("Calibri", Font.PLAIN,18));
        g.setColor(Color.BLACK);
        g.drawString("Created by Radim PESA & David BORUVKA",330,570);
    }
}