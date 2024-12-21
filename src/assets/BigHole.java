package assets;

import framework.Constants;
import framework.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class BigHole extends GameObject {
    public BigHole(int x, int y, int width, int height, String ID) {
        super(x, y, width, height, ID);
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, Constants.PIT_WIDTH, Constants.PIT_HEIGHT);
    }

    public void tick(LinkedList<GameObject> gameObjects) {

    }
}
