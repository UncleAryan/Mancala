package core;

import javax.swing.*;

public class Frame {
    public Frame(Panel panel) {
        JFrame frame = new JFrame("Mancala");
        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
