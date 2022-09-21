package cs5004.marblesolitaire.model;

/**
 * Interface for a MarbleSolitaire Controller. The controller is used to handle moves and convey
 * move outcomes back to view to display the massages in view
 *
 */
public interface MarbleSolitaireControllerInterface {
    
    /**
     * Link controller to the view to start play game and convey outcomes of move to view
     */
    void playGame();
    
    /**
     * Get the move received from view, send the moves to model, make slots in view display
     * proper icon after the move is made
     *
     * @param fromRow represents the fromRow of the fromSlot
     * @param fromCol represents the fromCol of the fromSlot
     * @param toRow represents the toRow of the toSlot
     * @param toCol represents the toCol of the toSlot
     */
    void actionMove(int fromRow, int fromCol, int toRow, int toCol);
    
    /**
     * Get the score after each move is made and display the messages in the topLabel in view in
     * the game and after the game is over
     */
    void getScore();
}
