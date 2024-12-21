package assets;

import framework.Constants;
import framework.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class BigHole extends GameObject {
    public BigHole(int x, int y, int width, int height, int ID) {
        super(x, y, width, height, ID);
        stones = 0;
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, Constants.PIT_WIDTH, Constants.PIT_HEIGHT);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Ariel", Font.BOLD, Constants.BIG_HOLE_FONT_SIZE));
        g.drawString(String.valueOf(stones),
                x + Constants.PIT_WIDTH / 2 - Constants.BIG_HOLE_FONT_SIZE / 2,
                y + Constants.PIT_HEIGHT/2 + Constants.BIG_HOLE_FONT_SIZE/2);
    }

    public void tick(LinkedList<GameObject> gameObjects) {

    }
}
