package logic;

public class TicTacToeLogic {
    /* Represent the state of a tic-tac-toe game including
    the current player.
     */

    private final int SIZE = 3;

    private int mCurrentPlayer = 1;

    private int usedFields = 0;

    //2D Array of int to see where players have set their symbol
    private final int[][] fields = new int[SIZE][SIZE];

    public TicTacToeLogic() {
    }

    /**
     * A mutator that must be called when a field is set by the
     * current player
     * Adds clicked fields to the 2D Array
     *
     * @param row is the x-coordinate of the field. Must be in 0..size-1
     * @param col is the y-coordinate of the field. Must be in 0..size-1
     */
    public void set(int row, int col) {
        //Puts the current player info into the 2d array based on which tile the player clicks
        fields[row][col] = mCurrentPlayer;

        mCurrentPlayer = 3 - mCurrentPlayer;
        usedFields++;
    }

    /**
     * Inspector used to get the current player; either 1 or 2.
     *
     * @return the current player
     */
    public int getCurrentPlayer() {
        return mCurrentPlayer;
    }

    /**
     * Inspector returning if there is a winner in the current state.
     *
     * @return either 1 or 2 if there is a winner, and 0 otherwise
     */
    public int anyWinner() {
        //Checking if someone has won in the vertical positions
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == fields[i][1] && fields[i][1] == fields[i][2] && fields[i][1] != 0) {
                if (mCurrentPlayer == 1) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        //Checking if someone has won in the horizontal positions
        for (int i = 0; i < fields.length; i++) {
            if (fields[0][i] == fields[1][i] && fields[1][i] == fields[2][i] && fields[1][i] != 0) {
                if (mCurrentPlayer == 1) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        //Checking if someone has won in the diagonal position starting from 0-0 to 2-2
        //else if: checking if someone has won in the diagonal position starting from 0-2 to 2-0
        if (fields[1][1] != 0) {
            int compare = fields[1][1];
            if (fields[0][0] == compare && fields[2][2] == compare) {
                if (mCurrentPlayer == 1) {
                    return 1;
                } else {
                    return 2;
                }
            } else if (fields[0][2] == compare && fields[2][0] == compare) {
                if (mCurrentPlayer == 1) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }

        return 0;
    }


    /**
     * Inspector
     *
     * @return if gameboard is filled.
     */
    public boolean isGameOver() {
        return usedFields == SIZE * SIZE;
    }

}
