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
        System.out.println("index: " + index);
        int counter = 1;

        while(stones != 0) {
            if(index + counter > 13) {
                System.out.println("index + counter is more than 13");
                index = 0;
                counter = 0;
            }
            panel.getHoles()[index + counter].addStone();

            counter++;
            stones--;
        }
    }
}
