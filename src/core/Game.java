package core;

import assets.Hole;
import framework.Constants;

import java.awt.*;

/*
Class to handle game moves, turns, rules, error checking, etc.
 */
public class Game {
    private Panel panel;
    private Boolean playerOneTurn;

    public Game (Panel panel) {
        this.panel = panel;
        playerOneTurn = true;
    }

    public void displayPlayerTurn(Graphics g) {
        g.setColor(Color.WHITE);
        String text;
        Font font = new Font("Serif", Font.BOLD, Constants.BIG_HOLE_FONT_SIZE);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);
        int y;
        if(!playerOneTurn) {
            text = "PLAYER 2 TURN";
            y = metrics.getAscent();
        } else {
            text = "PLAYER 1 TURN";
            y = Constants.HEIGHT - metrics.getAscent()/2;
        }
        int x = (Constants.WIDTH - metrics.stringWidth(text)) / 2;
        g.drawString(text, x, y);
    }

    public void switchTurn() {
        if(playerOneTurn) {
            playerOneTurn = false;
        } else {
            playerOneTurn = true;
        }
    }

    public void moveStonesAt(int index) {
        if((playerOneTurn && index <= 5) || (!playerOneTurn && index >= 7 && index <= 12)) {
            int stones = panel.getHoles()[index].getStones();
            if(stones == 0) {
                System.out.println("Illegal move");
            } else {
                panel.getHoles()[index].setStones(0);
                int counter = 1;

                while(stones != 0) {
                    if(index + counter > 13) {
                        index = 0;
                        counter = 0;
                    }
                    panel.getHoles()[index + counter].addStone();
                    counter++;
                    stones--;
                }
                checkWinningCondition();
                switchTurn();
            }
        } else {
            System.out.println("It is not your turn.");
        }

    }

    public void checkWinningCondition() {
        if(allHolesEmpty()) {
            if(panel.getHoles()[6].getStones() > panel.getHoles()[13].getStones()) {
                System.out.println("Player 1 won");
            } else if(panel.getHoles()[6].getStones() < panel.getHoles()[13].getStones()){
                System.out.println("Player 2 won");
            } else {
                System.out.println("It's a draw");
            }
        }
    }

    public boolean allHolesEmpty() {
        for(int i = 0; i < 6; i++) {
            if(panel.getHoles()[i].getStones() != 0 || panel.getHoles()[i + 7].getStones() != 0) {
                return false;
            }
        }
        return true;
    }

    public Boolean getPlayerOneTurn() {
        return playerOneTurn;
    }
}
