public class Board {
    private Space[][] board;

    public Board() {
        board = new Space[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                board[r][c] = new Space(0, false);
            }
        }
    }

    public void initialize(int[][] values, boolean[][] fixed) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                board[r][c] = new Space(values[r][c], fixed[r][c]);
            }
        }
    }

    public boolean setValue(int row, int col, int value) {
        if (board[row][col].isFixed()) {
            return false;
        }
        board[row][col].setValue(value);
        return true;
    }

    public void clearValue(int row, int col) {
        if (!board[row][col].isFixed()) {
            board[row][col].setValue(0);
        }
    }

    public void printBoard() {
        System.out.println(" Sudoku Board ");
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0 && r != 0) {
                System.out.println("------+-------+------");
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0 && c != 0) System.out.print("| ");
                int val = board[r][c].getValue();
                System.out.print((val == 0 ? ". " : val + " "));
            }
            System.out.println();
        }
    }
}

