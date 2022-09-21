package cs5004.marblesolitaire.model;

/**
 * Interface for a MarbleSolitaire View
 */
public interface MarbleSolitaireViewInterface {
    /**
     * Links controller with MarbleSolitaireView
     *
     * @param controller is the controller that should be linked
     */
    void linkController(MarbleSolitaireController controller);
    /**
     * Display the message in the topLabel from the controller
     *
     * @param string is the message that should be displayed in the topLabel
     */
    void displayMessage(String string);
    
    /**
     * Display the message in the downLabel from the controller to get scores after each move
     *
     * @param score represents the score that should be displayed in the downLabel
     */
    void displayMessageGetScore(int score);
    
    /**
     * Set the icon to be empty for fromSlot after the move is made
     *
     * @param fromRow represents the fromRow of the fromSlot
     * @param fromCol represents the fromCol of the fromSlot
     */
    void fromslotIcon(int fromRow, int fromCol);
    
    /**
     * Set the icon to be marble/occupied for toSlot after the move is made
     *
     * @param toRow represents the toRow of the toSlot
     * @param toCol represents the toCol of the toSlot
     */
    void toSlotIcon(int toRow, int toCol);
    
    /**
     * Set the icon to be empty for middleSlot after the move is made
     *
     * @param midRow represents the midRow of the middleSlot
     * @param midCol represents the midCol of the middleSlot
     */
    void midSlotIcon(int midRow, int midCol);
}
