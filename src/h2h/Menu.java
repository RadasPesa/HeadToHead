package h2h;

import java.awt.*;

class Menu {

    private Rectangle playButton = new Rectangle(HeadToHead.WIDTH / 2 - 63,300,130,55);
    private Rectangle aboutButton = new Rectangle(HeadToHead.WIDTH / 2 - 66,400,137,55);
    private Rectangle settingsButton = new Rectangle(HeadToHead.WIDTH / 2 - 72, 500,150,55);
    private Rectangle exitButton = new Rectangle(HeadToHead.WIDTH / 2 - 63,600,130,55);

    void tick() {
        Game.scoreOfFirstPlayer = 0;
        Game.scoreOfSecondPlayer = 0;
    }

    void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("Arial", Font.PLAIN, 35);

        g.setColor(new Color(120,120,120, 120));
        g2d.fill(playButton);
        g2d.fill(aboutButton);
        g2d.fill(settingsButton);
        g2d.fill(exitButton);

        g.setFont(font);
        g.setColor(Color.WHITE);

        g2d.draw(playButton);
        g2d.draw(aboutButton);
        g2d.draw(settingsButton);
        g2d.draw(exitButton);

        g.drawString("PLAY", playButton.x + 22, playButton.y + 40);
        g.drawString("EXIT", exitButton.x + 29, exitButton.y + 40);

        g.setFont(new Font("Arial", Font.PLAIN, 32));
        g.drawString("ABOUT", aboutButton.x + 11, aboutButton.y + 40);

        g.setFont(new Font("Arial", Font.PLAIN, 29));
        g.drawString("SETTINGS", settingsButton.x + 4, settingsButton.y + 37);
    }

    static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font, Color color) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Set the color
        g.setColor(color);
        // Draw the String
        g.drawString(text, x, y);
    }

}