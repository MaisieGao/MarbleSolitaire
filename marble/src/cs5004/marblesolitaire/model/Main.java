package cs5004.marblesolitaire.model;
/**
 * Run a MarbleSolitaire game interactively on the console.
 */
public class Main {
    /**
     * Run a MarbleSolitaire game interactively on the console.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
        MarbleSolitaireView view = new MarbleSolitaireView("Marble Solitaire Game");
        MarbleSolitaireController controller = new MarbleSolitaireController(model, view);
        controller.playGame();
    }
}
