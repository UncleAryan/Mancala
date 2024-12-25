package core;

import assets.Hole;
import framework.Constants;
import framework.GameState;
import input.MouseInput;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{
    private Hole[] holes;
    private Game game;
    private Thread thread;
    private Boolean gameOver;
    private MouseInput mouseInput;

    public Panel() {
        setPanelSize();
        load();
        startThread();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        render(g);
    }

    public void run() {
        try {
            while(!gameOver) {
                repaint();

                Thread.sleep(100);
            }
        } catch(Exception e) {
            System.out.println("Thread Error");
        }
    }

    private void load() {
        // logic is that the bottom left most hole is ID = 0 and goes counter clock wise
        // so 0 - 5 is player 1, 6 is player 1's pit, 7 to 12 is player 2, 13 is player 2's pit
        gameOver = false;
        game = new Game(this);
        holes = new Hole[14];
        int playerTwoIndex = 12;
        for(int i = 0; i < 6; i++) {
            holes[i] = new Hole((i*Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/2,
                    (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3*2, Constants.HOLE_WIDTH, Constants.HOLE_HEIGHT, i);

            holes[playerTwoIndex] = new Hole((i*Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/2,
                    (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3, Constants.HOLE_WIDTH, Constants.HOLE_HEIGHT, i + 7);
            playerTwoIndex--;
        }

        holes[13] = new Hole(((Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/4) - Constants.HOLE_WIDTH,
                (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3 + Constants.HOLE_HEIGHT,
                Constants.PIT_WIDTH, Constants.PIT_HEIGHT, 13);

        holes[6] = new Hole(((Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/4) + Constants.HOLE_WIDTH*6,
                (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3 + Constants.HOLE_HEIGHT,
                Constants.PIT_WIDTH, Constants.PIT_HEIGHT, 6);
        mouseInput = new MouseInput(this);
        this.addMouseListener(mouseInput);
    }

    private void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    private void render(Graphics g) {
        setBackgroundColor(g);
        drawBoard(g);
        for(int i = 0; i < 14; i++) {
            holes[i].render(g);
        }
        game.displayPlayerTurn(g);
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

    public Hole[] getHoles() {
        return holes;
    }

    public Game getGame () {
        return game;
    }
}
