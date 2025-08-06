package game2048logic;

import game2048rendering.Side;


public class GameLogic {

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


    public static void tilt(int[][] board, Side side) {
        if (side == Side.NORTH) {
            tiltUp(board);
        } else if (side == Side.SOUTH) {
            MatrixUtils.rotateLeft(board);
            MatrixUtils.rotateLeft(board);
            tiltUp(board);
            MatrixUtils.rotateRight(board);
            MatrixUtils.rotateRight(board);
        } else if (side == Side.WEST) {
            MatrixUtils.rotateRight(board);
            tiltUp(board);
            MatrixUtils.rotateLeft(board);
        } else if (side == Side.EAST) {
            MatrixUtils.rotateLeft(board);
            tiltUp(board);
            MatrixUtils.rotateRight(board);
        }
    }
}
