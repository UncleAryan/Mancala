package input;

import core.Panel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    private Panel panel;
    private Rectangle bounds;

    public MouseInput(Panel panel) {
        this.panel = panel;
        bounds = new Rectangle();
        bounds.width = 1;
        bounds.height = 1;
    }

    public void mouseClicked(MouseEvent e) {
        bounds.x = e.getX();
        bounds.y = e.getY();

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
