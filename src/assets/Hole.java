package assets;

import framework.Constants;
import framework.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Hole extends GameObject {
    public Hole(int x, int y, int width, int height, int ID) {
        super(x, y, width, height, ID);
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Ariel", Font.PLAIN, Constants.BIG_HOLE_FONT_SIZE));
        g.drawString(String.valueOf(stones),
                x + Constants.HOLE_WIDTH / 2 - Constants.HOLE_FONT_SIZE / 2,
                y + Constants.HOLE_HEIGHT/2 + Constants.HOLE_FONT_SIZE/2);
    }

    public void tick(LinkedList<GameObject> gameObjects) {

    }
}
