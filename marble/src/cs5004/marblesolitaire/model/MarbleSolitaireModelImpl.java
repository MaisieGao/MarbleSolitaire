package cs5004.marblesolitaire.model;

/**
 * Get the class Marble.MarbleSolitaireModelImpl to implement the MarbleSolitaireModel interface.
 * This class represents the MarbleSolitaire game. The game board should be a 2D board with
 * length of armThick * 2 + 1 in both row and column
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
    private Marble[][] board;
    private int armThick;

    /**
     * Create a board with " ", "O" , "_" in the specific cells
     *
     * @param armThick represents the arm Thickness of the game
     */
    private void create_board(int armThick) {
        //when armThick is 3, the board has a row length of 7 and column length of 7
        this.armThick = armThick;
        int length = armThick * 2 + 1;
        board = new Marble[length][length];
        int row, col;
        //get all slots in board to be NotAvailable first
        for (row = 0; row < length; row++) {
            for (col = 0; col < length; col++) {
                board[row][col] = Marble.NotAvailable;
            }
        }
        //get the corresponding slots to be occupied
        for (int i = 0; i < length; i++) {
            for (int j = armThick / 2 + 1; j < armThick * 3 / 2 + 1; j++) {
                board[i][j] = Marble.Stone;
                board[j][i] = Marble.Stone;
            }
        }
        //mark the center slot to be empty
        board[armThick][armThick] = Marble.Empty;
    }

    /**
     * Construct Marble.MarbleSolitaireModelImpl that takes no parameter and initialize the game board
     * with an arm Thickness of 3 and the empty slot in the center
     */
    public MarbleSolitaireModelImpl() {
        int armThick = 3;
        create_board(armThick);
    }

    /**
     * Construct Marble.MarbleSolitaireModelImpl that takes sRow and sCol as parameters and initialize
     * the game board with an arm Thickness of 3 and the empty slot at the position(sRow, sCol)
     *
     * @param sRow represents the row of the empty slot
     * @param sCol represents the column of the empty slot
     * @throws IllegalArgumentException when the empty cell position is invalid
     */
    public MarbleSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
        int armThick = 3;
        if (sRow < 0 || sCol < 0 || sRow > armThick * 2 || sCol > armThick * 2) {
            throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
        }
        create_board(armThick);
        //check if the empty slot is valid
        if (board[sRow][sCol] == Marble.NotAvailable) {
            throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
        }
        //get center slot back to occupied
        board[3][3] = Marble.Stone;
        //get the (sRow, sCol) slot to be empty
        board[sRow][sCol] = Marble.Empty;
    }

    /**
     * Construct Marble.MarbleSolitaireModelImpl that takes arm thickness as the parameter and initialize
     * the game board with the arm Thickness and the empty slot at the center
     *
     * @param armThick represents the arm Thickness of the game
     * @throws IllegalArgumentException when the arm thickness is not a positive odd number
     */
    public MarbleSolitaireModelImpl(int armThick) throws IllegalArgumentException {
        //check whether armThick is positive odd integer than is not 1
        if (armThick <= 1 || armThick % 2 == 0) {
            throw new IllegalArgumentException("the arm thickness is not a positive odd number");
        }
        create_board(armThick);
    }

    /**
     * Construct Marble.MarbleSolitaireModelImpl that takes arm thickness, sRow and sCol as parameters
     * and initialize the game board with the arm Thickness and the empty slot at the position
     * (sRow, sCol)
     *
     * @param armThick represents the arm Thickness of the game
     * @param sRow     represents the row of the empty slot
     * @param sCol     represents the column of the empty slot
     * @throws IllegalArgumentException when the arm thickness is not a positive odd number, or the
     *                                  empty cell position is invalid
     */
    public MarbleSolitaireModelImpl(int armThick, int sRow, int sCol) throws IllegalArgumentException {
        if (armThick <= 0 || armThick % 2 == 0) {
            throw new IllegalArgumentException("the arm thickness is not a positive odd number");
        }
        if (sRow < 0 || sCol < 0 || sRow > armThick * 2 || sCol > armThick * 2) {
            throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
        }
        create_board(armThick);
        if (board[sRow][sCol] == Marble.NotAvailable) {
            throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
        }
        board[armThick][armThick] = Marble.Stone;
        board[sRow][sCol] = Marble.Empty;
    }

    /**
     * If a marble can be movable from (fromRow, fromCol) to (toRow, toCol), return 1. Otherwise, return -1
     *
     * @param fromRow the row number of the position to be moved from
     * @param fromCol the column number of the position to be moved from
     * @param toRow   the row number of the position to be moved to
     * @param toCol   the column number of the position to be moved to
     * @return 1 if a marble can move to a specific position. Return -1 if it is not able to move
     */
    private int isMovable(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0) {
            return -1;
        }
        if (fromRow > this.armThick * 2 || fromCol > this.armThick * 2 || toRow > this.armThick * 2 || toCol > this.armThick * 2) {
            return -1;
        }
        //If the from slot is not occupied or the middle slot not is occupied or the to slot is not empty, return -1
        int middleRow = (fromRow + toRow) / 2;
        int middleCol = (fromCol + toCol) / 2;
        if (board[fromRow][fromCol] != Marble.Stone || board[middleRow][middleCol] != Marble.Stone || board[toRow][toCol] != Marble.Empty) {
            return -1;
        }
        //when cols are equal, the from and to row's difference is 2
        //when rows are equal, the from and to col's difference is 2
        if ((Math.abs(fromRow - toRow) == 2 && fromCol == toCol) || (Math.abs(fromCol - toCol) == 2 && fromRow == toRow)) {
            return 1;
        }
        return -1;
    }

    @Override
    public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
        if (isMovable(fromRow, fromCol, toRow, toCol) == -1) {
            throw new IllegalArgumentException("movement is not possible");
        }
        //from slot becomes empty
        board[fromRow][fromCol] = Marble.Empty;
        //middle slot becomes empty
        int middleRow = (fromRow + toRow) / 2;
        int middleCol = (fromCol + toCol) / 2;
        board[middleRow][middleCol] = Marble.Empty;
        //to slot becomes occupied
        board[toRow][toCol] = Marble.Stone;
    }

    @Override
    public boolean isGameOver() {
        for (int row = 0; row <= armThick * 2; row++) {
            for (int col = 0; col <= armThick * 2; col++) {
                //if the slot can't move to any direction, then the game is over
                if ((isMovable(row, col, row + 2, col) == 1) || (isMovable(row, col, row - 2, col) == 1) ||
                        (isMovable(row, col, row, col + 2) == 1) || (isMovable(row, col, row, col - 2) == 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getGameState() {
        String gameState = new String();
        for (int row = 0; row <= armThick * 2; row++) {
            for (int col = 0; col <= armThick * 2; col++) {
                gameState += board[row][col];
                gameState += " ";
            }
            gameState = gameState.substring(0, gameState.length() - 1);
            gameState += "\n";
        }
        return gameState.substring(0, gameState.length() - 1);
    }


    @Override
    public int getScore() {
        int score = 0;
        for (int row = 0; row <= armThick * 2; row++) {
            for (int col = 0; col <= armThick * 2; col++) {
                //get the number of occupied cell in the board to be the score
                if (board[row][col] == Marble.Stone) {
                    score++;
                }
            }
        }
        return score;
    }
}
