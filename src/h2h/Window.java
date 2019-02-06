package h2h;

import javax.swing.*;
import java.awt.*;

class Window extends Canvas {

    private static final long serialVersionUID = 1L;

    Window(HeadToHead h2h) {
        JFrame frame = new JFrame("HeadToHead");

        frame.setPreferredSize(new Dimension(HeadToHead.WIDTH, HeadToHead.HEIGHT));
        frame.setMinimumSize(new Dimension(HeadToHead.WIDTH, HeadToHead.HEIGHT));
        frame.setMaximumSize(new Dimension(HeadToHead.WIDTH, HeadToHead.HEIGHT));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(h2h);

        frame.setVisible(true);

        h2h.start();
    }
}
