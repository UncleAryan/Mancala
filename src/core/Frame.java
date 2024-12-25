package core;

import input.KeyInput;

import javax.swing.*;

public class Frame {
    public Frame(Panel panel) {
        JFrame frame = new JFrame("Mancala");
        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(new KeyInput());
        frame.setVisible(true);
    }
}
