package core;

import assets.Hole;
import framework.Constants;
import input.MouseInput;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private MouseInput mouseInput;
    private Hole[] holes;

    public Panel() {
        setPanelSize();
        loadGameObjects();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackgroundColor(g);
        drawBoard(g);
        renderGameObjects(g);
    }

    private void loadGameObjects() {
        // logic is that the bottom left most hole is ID = 0 and goes counter clock wise
        // so 0 - 5 is player 1, 6 is player 1's pit, 7 to 12 is player 2, 13 is player 2's pit
        
        holes = new Hole[14];
        for(int i = 0; i < 6; i++) {
            holes[i] = new Hole((i*Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/2,
                    (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3, Constants.HOLE_WIDTH, Constants.HOLE_HEIGHT, i);

            holes[i + 7] = new Hole((i*Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/2,
                    (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3*2, Constants.HOLE_WIDTH, Constants.HOLE_HEIGHT, i + 7);
        }

        holes[6] = new Hole(((Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/4) - Constants.HOLE_WIDTH,
                (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3 + Constants.HOLE_HEIGHT,
                Constants.PIT_WIDTH, Constants.PIT_HEIGHT, 6);

        holes[13] = new Hole(((Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/4) + Constants.HOLE_WIDTH*6,
                (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3 + Constants.HOLE_HEIGHT,
                Constants.PIT_WIDTH, Constants.PIT_HEIGHT, 13);


        mouseInput = new MouseInput(this);
        this.addMouseListener(mouseInput);

    }

    private void renderGameObjects(Graphics g) {
        for(int i = 0; i < 14; i++) {
            holes[i].render(g);
        }
    }

    private void drawBoard(Graphics g) {
        g.setColor(new Color(139,69,19));
        g.fillOval(0, Constants.HEIGHT/10, Constants.WIDTH, Constants.HEIGHT - Constants.HEIGHT/10*2);
    }

    private void setBackgroundColor(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
    }

    private void setPanelSize() {
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
    }

}
