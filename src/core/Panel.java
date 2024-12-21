package core;

import assets.BigHole;
import assets.Hole;
import framework.Constants;
import framework.GameObjectHandler;
import input.MouseInput;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private Hole[] playerOneHoles;
    private Hole[] playerTwoHoles;
    private BigHole playerOneBigHole, playerTwoBigHole;
    private GameObjectHandler gameObjectHandler;
    private MouseInput mouseInput;

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
        // player 1 holes (up) and player 2 holes (down)
        playerOneHoles = new Hole[6];
        playerTwoHoles = new Hole[6];
        gameObjectHandler = new GameObjectHandler();
        for(int i = 0; i < 6; i++) {
            playerOneHoles[i] = new Hole((i*Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/2,
                    (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3, Constants.HOLE_WIDTH, Constants.HOLE_HEIGHT, "Hole");
            gameObjectHandler.addGameObject(playerOneHoles[i]);
            playerTwoHoles[i] = new Hole((i*Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/2,
                    (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3*2, Constants.HOLE_WIDTH, Constants.HOLE_HEIGHT, "Hole");
            gameObjectHandler.addGameObject(playerTwoHoles[i]);
        }
        playerOneBigHole = new BigHole(((Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/4) - Constants.HOLE_WIDTH,
                (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3 + Constants.HOLE_HEIGHT,
                Constants.PIT_WIDTH, Constants.PIT_HEIGHT, "PlayerOneBigHole");
        gameObjectHandler.addGameObject(playerOneBigHole);
        playerTwoBigHole = new BigHole(((Constants.HOLE_WIDTH)+(Constants.WIDTH-Constants.HOLE_WIDTH*6)/4) + Constants.HOLE_WIDTH*6,
                (Constants.HEIGHT-Constants.HOLE_HEIGHT)/3 + Constants.HOLE_HEIGHT,
                Constants.PIT_WIDTH, Constants.PIT_HEIGHT, "PlayerTwoBigHole");
        gameObjectHandler.addGameObject(playerTwoBigHole);
        mouseInput = new MouseInput(this);
        this.addMouseListener(mouseInput);
    }

    private void renderGameObjects(Graphics g) {
        for(int i = 0; i < gameObjectHandler.getGameObjects().size(); i++) {
            gameObjectHandler.getGameObjects().get(i).render(g);
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
