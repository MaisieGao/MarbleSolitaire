import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

/**
 * Do not modify this file. This file should compile correctly with your code!
 * You DO NOT need to submit this file.
 */
public class TypeChecks {

  /**
   * The contents of this method are meaningless.
   * They are only here to ensure that your code compiles properly.
   */
  public static void main(String[] args) {
    helper(new MarbleSolitaireModelImpl());
    helper(new MarbleSolitaireModelImpl(3, 3));
    helper(new MarbleSolitaireModelImpl(3));
    helper(new MarbleSolitaireModelImpl(3, 3, 3));
  }

  private static void helper(MarbleSolitaireModel model) {
    model.move(1, 3, 3, 3);
  }

}