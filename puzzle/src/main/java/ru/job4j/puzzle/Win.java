package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1 && (checkHorizontal(board, i) || checkVertical(board, i))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean checkHorizontal(int[][] board, int row) {
        boolean isWin = true;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != 1) {
                isWin = false;
                break;
            }
        }
        return isWin;
    }

    public static boolean checkVertical(int[][] board, int row) {
        boolean isWin = true;
        for (int i = 0; i < board[row].length; i++) {
            if (board[i][row] != 1) {
                isWin = false;
                break;
            }
        }
        return isWin;
    }
}
