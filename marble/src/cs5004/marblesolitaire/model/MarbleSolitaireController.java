package cs5004.marblesolitaire.model;
/**
 * Class representing the controller of MarbleSolitaire
 */
public class MarbleSolitaireController implements MarbleSolitaireControllerInterface {
    private final MarbleSolitaireModel model;
    private final MarbleSolitaireView view;
    
    /**
     * Construct a MarbleSolitaire game object's controller
     *
     * @param model that represents the model of this game
     * @param view that represents the view of this game
     */
    public MarbleSolitaireController(MarbleSolitaireModel model, MarbleSolitaireView view){
        this.model = model;
        this.view = view;
    }
    
    @Override
    public void playGame() {
        this.view.linkController(this);
    }
    
    @Override
    public void actionMove(int fromRow, int fromCol, int toRow, int toCol) {
        int midRow = (fromRow + toRow) / 2;
        int midCol = (fromCol + toCol) / 2;
        try {
            if (!model.isGameOver()) {
                model.move(fromRow, fromCol, toRow, toCol);
                //from and mid slot becomes empty
                view.fromslotIcon(fromRow,fromCol);
                view.midSlotIcon(midRow, midCol);
                //to slot becomes marble
                view.toSlotIcon(toRow,toCol);
                //get score and display msg in each step
                getScore();
            }
        }
        //if the move is invalid, display the msg to the audience
        catch (IllegalArgumentException e){
        }
    }
    
    @Override
    public void getScore() {
        int score = model.getScore();
        view.displayMessageGetScore(score);
        if (!model.isGameOver()){
            view.displayMessage("Please continue playing...");
        }else {
            view.displayMessage("Game ends. Good Job!");
        }
    }
}
