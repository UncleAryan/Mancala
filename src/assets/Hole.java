package assets;

import framework.Constants;
import core.Panel;

import java.awt.*;

public class Hole {
    private final int x, y, width, height, ID;
    private int stones;
    private Rectangle bounds;

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
        bounds = new Rectangle(x, y, width, height);
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLACK);
        if(ID == 6 || ID == 13) {
            g.setFont(new Font("Ariel", Font.BOLD, Constants.BIG_HOLE_FONT_SIZE));
        } else {
            g.setFont(new Font("Ariel", Font.PLAIN, Constants.BIG_HOLE_FONT_SIZE));
        }
        g.drawString(String.valueOf(stones),
                x + width / 2 - Constants.HOLE_FONT_SIZE / 2,
                y + height/2 + Constants.HOLE_FONT_SIZE/2);
    }

    public void tick() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getID() {
        return ID;
    }

    public int getStones() {
        return stones;
    }

    public void setStones(int stones) {
        this.stones = stones;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void moveStonesAt(Panel panel, int index) {
        panel.getGame().moveStonesAt(index);
    }

    public void addStone() {
        stones++;
    }
}
