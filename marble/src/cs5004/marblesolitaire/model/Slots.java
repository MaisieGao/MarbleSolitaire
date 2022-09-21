package cs5004.marblesolitaire.model;

import javax.swing.*;

/**
 * A class that create all the JButtons on the board that represents
 * all the slots we need in the game
 */
public class Slots extends JButton {
    /**
     * Construct all the slots on the game board
     * @param command informs the slots' positions when press the slots
     */
    public Slots(String command){
        super("");
        setActionCommand(command);
        setSize(50,50);
        setFocusable(false);
    }
}
