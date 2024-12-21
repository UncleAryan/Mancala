package input;

import core.Panel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    private Panel panel;

    public MouseInput(Panel panel) {
        this.panel = panel;
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
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
