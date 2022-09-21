import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A Junit test for the MarbleSolitaireModelImpl class
 */
public class MarbleSolitaireModelImplTest {
    private MarbleSolitaireModelImpl testConstructor1;
    private MarbleSolitaireModelImpl testConstructor2;
    private MarbleSolitaireModelImpl testConstructor3;
    private MarbleSolitaireModelImpl testConstructor4;

    /**
     * Create new MarbleSolitaire objects for different constructors
     */
    @Before
    public void setup() {
        testConstructor1 = new MarbleSolitaireModelImpl();
        testConstructor2 = new MarbleSolitaireModelImpl(1, 3);
        testConstructor3 = new MarbleSolitaireModelImpl(7);
        testConstructor4 = new MarbleSolitaireModelImpl(5, 6, 8);
    }

    /**
     * Test first constructor
     */
    @Test
    public void testConstructor1() {
        String expected = "    O O O    \n"
                + "    O O O    \n"
                + "O O O O O O O\n"
                + "O O O _ O O O\n"
                + "O O O O O O O\n"
                + "    O O O    \n"
                + "    O O O    ";
        assertEquals(expected, testConstructor1.getGameState());
    }

    /**
     * Test second constructor
     */
    @Test
    public void testConstructor2() {
        String expected = "    O O O    \n"
                + "    O _ O    \n"
                + "O O O O O O O\n"
                + "O O O O O O O\n"
                + "O O O O O O O\n"
                + "    O O O    \n"
                + "    O O O    ";
        assertEquals(expected, testConstructor2.getGameState());
    }

    /**
     * Test third constructor
     */
    @Test
    public void testConstructor3() {
        String expected = "        O O O O O O O        \n"
                + "        O O O O O O O        \n"
                + "        O O O O O O O        \n"
                + "        O O O O O O O        \n"
                + "O O O O O O O O O O O O O O O\n"
                + "O O O O O O O O O O O O O O O\n"
                + "O O O O O O O O O O O O O O O\n"
                + "O O O O O O O _ O O O O O O O\n"
                + "O O O O O O O O O O O O O O O\n"
                + "O O O O O O O O O O O O O O O\n"
                + "O O O O O O O O O O O O O O O\n"
                + "        O O O O O O O        \n"
                + "        O O O O O O O        \n"
                + "        O O O O O O O        \n"
                + "        O O O O O O O        ";

        assertEquals(expected, testConstructor3.getGameState());
    }

    /**
     * Test fourth constructor
     */
    @Test
    public void testConstructor4() {
        String expected = "      O O O O O      \n"
                + "      O O O O O      \n"
                + "      O O O O O      \n"
                + "O O O O O O O O O O O\n"
                + "O O O O O O O O O O O\n"
                + "O O O O O O O O O O O\n"
                + "O O O O O O O O _ O O\n"
                + "O O O O O O O O O O O\n"
                + "      O O O O O      \n"
                + "      O O O O O      \n"
                + "      O O O O O      ";

        assertEquals(expected, testConstructor4.getGameState());
    }

    /**
     * Test when a game with a board with an arm thickness greater than 3
     */
    @Test
    public void testArmThicknessLargerThan3() {
        MarbleSolitaireModelImpl newMarble = new MarbleSolitaireModelImpl(5);
        assertEquals(
                "      O O O O O      \n" +
                        "      O O O O O      \n" +
                        "      O O O O O      \n" +
                        "O O O O O O O O O O O\n" +
                        "O O O O O O O O O O O\n" +
                        "O O O O O _ O O O O O\n" +
                        "O O O O O O O O O O O\n" +
                        "O O O O O O O O O O O\n" +
                        "      O O O O O      \n" +
                        "      O O O O O      \n" +
                        "      O O O O O      ", newMarble.getGameState());
    }

    /**
     * Test whether the class throws an IllegalArgumentException when the row is invalid for the
     * second constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor2InvalidRow() {
        new MarbleSolitaireModelImpl(-1, 3);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when the column is invalid for the
     * second constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor2InvalidCol() {
        new MarbleSolitaireModelImpl(4, 8);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when the empty slot(sRow, sCol) is
     * not available for the second constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor2NotAvailable() {
        new MarbleSolitaireModelImpl(1, 1);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when the arm thickness is negative for
     * the third constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor3ArmNegative() {
        new MarbleSolitaireModelImpl(-3);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when the arm thickness is even for the
     * third constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor3ArmEven() {
        new MarbleSolitaireModelImpl(6);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when the arm thickness is negative for
     * the fourth constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor4ArmNegative() {
        new MarbleSolitaireModelImpl(-7, 7, 7);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when arm thickness is even for the
     * fourth constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor4ArmEven() {
        new MarbleSolitaireModelImpl(8, 1, -2);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when the column is invalid for the
     * fourth constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor4InvalidCol() {
        new MarbleSolitaireModelImpl(5, 1, -2);
    }


    /**
     * Test whether the class throws an IllegalArgumentException when the empty slot(sRow, sCol) is not
     * available for the fourth constructor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor4NotAvailable() {
        new MarbleSolitaireModelImpl(5, 10, 10);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when there is an illegal
     * fromRow in move method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalFromRowInMove() {
        testConstructor2.move(-1, 2, 3, 4);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when there is an illegal
     * toCol in move method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalToColInMove() {
        testConstructor2.move(3, 3, 5, 9);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when from slot is not available in move method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFromSlotNotAvailableInMove() {
        testConstructor1.move(1, 1, 3, 1);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when to slot is occupied in move method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToSlotStoneInMove() {
        testConstructor1.move(4, 1, 4, 3);
    }

    /**
     * Test whether the class throws an IllegalArgumentException when from slot move only 1 steps horizontally
     * in move method
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMove1InMove() {
        testConstructor1.move(3, 2, 3, 3);
    }

    /**
     * Test whether the isGameOver method works as expected
     */
    @Test
    public void testIsGameOver() {
        assertFalse(testConstructor1.isGameOver());
        testConstructor1.move(1, 3, 3, 3);
        testConstructor1.move(4, 3, 2, 3);
        testConstructor1.move(3, 1, 3, 3);
        testConstructor1.move(3, 4, 3, 2);
        testConstructor1.move(3, 6, 3, 4);
        assertFalse(testConstructor1.isGameOver());
        testConstructor1.move(6, 3, 4, 3);
        assertEquals("    O O O    \n" +
                "    O _ O    \n" +
                "O O O O O O O\n" +
                "O _ O _ O _ _\n" +
                "O O O O O O O\n" +
                "    O _ O    \n" +
                "    O _ O    ", testConstructor1.getGameState());
        assertTrue(testConstructor1.isGameOver());
    }

    /**
     * Test more than one marbles have been moved in the getGameState method
     */
    @Test
    public void testGetGameState() {
        assertEquals("    O O O    \n" +
                "    O O O    \n" +
                "O O O O O O O\n" +
                "O O O _ O O O\n" +
                "O O O O O O O\n" +
                "    O O O    \n" +
                "    O O O    ", testConstructor1.getGameState());
        testConstructor1.move(3, 1, 3, 3);
        assertEquals("    O O O    \n" +
                "    O O O    \n" +
                "O O O O O O O\n" +
                "O _ _ O O O O\n" +
                "O O O O O O O\n" +
                "    O O O    \n" +
                "    O O O    ", testConstructor1.getGameState());
        testConstructor1.move(1, 2, 3, 2);
        assertEquals("    O O O    \n" +
                "    _ O O    \n" +
                "O O _ O O O O\n" +
                "O _ O O O O O\n" +
                "O O O O O O O\n" +
                "    O O O    \n" +
                "    O O O    ", testConstructor1.getGameState());
    }

    /**
     * Test whether the getScore method works as expected
     */
    @Test
    public void testGetScore() {
        assertEquals(32, testConstructor1.getScore());
        testConstructor1.move(5, 3, 3, 3);
        assertEquals(31, testConstructor1.getScore());
        testConstructor1.move(2, 3, 4, 3);
        assertEquals(30, testConstructor1.getScore());
    }
}