package assets;

import framework.Constants;

import java.awt.*;

public class Hole {
    private final int x, y, width, height, ID;
    private int stones;

    public Hole(int x, int y, int width, int height, int ID) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.ID = ID;
        if(ID == 6 || ID == 13) {
            stones = 0;
        } else {
            stones = 4;
        }
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

    public void tick() {

    }
}
