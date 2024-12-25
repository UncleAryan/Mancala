package input;

import framework.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE && GameState.state == GameState.PLAY) {
            GameState.state = GameState.MENU;
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
