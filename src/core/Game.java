package core;

import assets.Hole;

/*
Class to handle game moves, turns, rules, error checking, etc.
 */
public class Game {
    private Panel panel;

    public Game (Panel panel) {
        this.panel = panel;
    }

    public void moveStonesAt(int index) {
        int stones = panel.getHoles()[index].getStones();
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
}
