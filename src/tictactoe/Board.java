package tictactoe;

public class Board {
    char[][] grid = new char[3][3];
    int totalMoves;

    public Board() {
        initializeBoard();
    }

    void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '-';
            }
        }
        totalMoves = 0;
    }

    public boolean isBoardFull() {
        return totalMoves == 9;
    }

    public synchronized void makeMove(int row, int col, char symbol) {
        if(grid[row][col] != '-') {
            throw new IllegalArgumentException("Invalid move!");
        }
        grid[row][col] = symbol;
        totalMoves++;
    }

    public boolean hasWinner() {
        //check rows
        for (int row = 0; row < 3; row++) {
            boolean checkRow = true;
            for (int col = 1; col < 3; col++) {
                if (grid[row][col] == '-' || grid[row][col - 1] != grid[row][col]) {
                    checkRow = false;
                }
            }
            if (checkRow) {
                return true;
            }
        }

        //check columns
        for (int col = 0; col < 3; col++) {
            boolean checkColumn = true;
            for (int row = 1; row < 3; row++) {
                if (grid[row][col] == '-' || grid[row - 1][col] != grid[row][col]) {
                    checkColumn = false;
                }
            }
            if (checkColumn) {
                return true;
            }
        }

        //check first diagonal
        int row = 1;
        int col = 1;
        boolean checkDiagonal = true;
        while (row < 3) {
            if (grid[row][col] == '-' || grid[row][col] != grid[row - 1][col - 1]) {
                checkDiagonal = false;
            }
            row++;
            col++;
        }
        if (checkDiagonal) {
            return true;
        }
        row = 1;
        col = 1;
        checkDiagonal = true;
        while (row < 3) {
            if (grid[row][col] == '-' || grid[row][col] != grid[row - 1][col + 1]) {
                checkDiagonal = false;
            }
            row++;
            col--;
        }
        return checkDiagonal;
    }

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(grid[row][col]+" ");
            }
            System.out.println();
        }
    }
}
