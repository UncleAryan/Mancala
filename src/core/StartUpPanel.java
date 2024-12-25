package core;

import framework.Constants;
import input.MouseInput;

import javax.swing.*;
import java.awt.*;

public class StartUpPanel extends JPanel {
    private MouseInput mouseInput;
    private Panel panel;

    public StartUpPanel(Panel panel) {
        this.panel = panel;
        load();
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
    }

    private void load() {
        mouseInput = new MouseInput(this);
    }

    public Panel getGamePanel() {
        return panel;
    }

    public MouseInput getMouseInput () {
        return mouseInput;
    }
}
