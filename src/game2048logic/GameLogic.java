package game2048logic;

import game2048rendering.Side;
import static game2048logic.MatrixUtils.rotateLeft;
import static game2048logic.MatrixUtils.rotateRight;


public class GameLogic {

    /** Moves the given tile up as far as possible, subject to the minR constraint.
     *
     * @param board the current state of the board
     * @param r     the row number of the tile to move up
     * @param c -   the column number of the tile to move up
     * @param minR  the minimum row number that the tile can land in, e.g.
     *              if minR is 2, the moving tile should move no higher than row 2.
     * @return      if there is a merge, returns the 1 + the row number where the merge occurred.
     *              if no merge occurs, then return 0.
     */
    public static int moveTileUpAsFarAsPossible(int[][] board, int r, int c, int minR) {
        if (board[r][c] == 0) return 0;

        int value = board[r][c];

        while (r > minR && board[r - 1][c] == 0){
            board[r - 1][c] = board[r][c];
            board[r][c] = 0;
            r--;
        }

        if (r > minR && board[r - 1][c] == value){
            board[r - 1][c] *= 2;
            board[r][c] = 0;
            return (r - 1) + 1;  // Return position of merged tile
        }
        return 0;
    }


    public static void tiltColumn(int[][] board, int c) {
      int minR = 0;

      for (int r = 0; r < board.length; r++){
          if (board[r][c] != 0){
              int result = moveTileUpAsFarAsPossible(board, r, c, minR);
              if (result != 0)
                  minR = result;
          }
      }
    }


    public static void tiltUp(int[][] board) {
        for (int i = 0; i < board[0].length; i++){
            tiltColumn(board, i);
        }
    }

    /**
     * Modifies the board to simulate tilting the entire board to
     * the given side.
     *
     * @param board the current state of the board
     * @param side  the direction to tilt
     */
    public static void tilt(int[][] board, Side side) {
        // TODO: fill this in in task 7
        if (side == Side.EAST) {
            return;
        } else if (side == Side.WEST) {
            return;
        } else if (side == Side.SOUTH) {
            return;
        } else {
            return;
        }
    }
}
