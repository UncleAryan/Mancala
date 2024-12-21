package assets;

import framework.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Hole extends GameObject {

    public Hole(int x, int y, int width, int height, String ID) {
        super(x, y, width, height, ID);
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, width, height);
    }

    public void tick(LinkedList<GameObject> gameObjects) {

    }
}
