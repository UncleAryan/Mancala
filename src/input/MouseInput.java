package input;

import core.Panel;
import core.StartUpPanel;
import framework.GameState;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    private Panel panel;
    private Rectangle bounds;

    // this is for playing the game
    public MouseInput(StartUpPanel startUpPanel) {
        this.panel = startUpPanel.getGamePanel();
        bounds = new Rectangle();
        bounds.width = 1;
        bounds.height = 1;
    }

    public void mouseClicked(MouseEvent e) {
        bounds.x = e.getX();
        bounds.y = e.getY();

        if(GameState.state == GameState.MENU) {
            GameState.state = GameState.PLAY;
        }

        for(int i = 0; i < 14; i++) {
            if(bounds.intersects(panel.getHoles()[i].getBounds()) && panel.getHoles()[i].getID() != 6 && panel.getHoles()[i].getID() != 13) {
                panel.getHoles()[i].moveStonesAt(panel, i);
            }
        }
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
