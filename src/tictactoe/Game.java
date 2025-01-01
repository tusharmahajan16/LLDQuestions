package tictactoe;

import java.util.Scanner;

public class Game {
    Player player1;
    Player player2;
    Board board;
    Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        board = new Board();
        currentPlayer = player1;
    }

    void play() {
        board.printBoard();
        while (!board.isBoardFull() && !board.hasWinner()) {
            System.out.println(currentPlayer.getName() + "'s turn.");
            int row = getValidInput("Enter row {0-2}: ");
            int col = getValidInput("Enter column {0-2}: ");

            try {
                board.makeMove(row, col, currentPlayer.getSymbol());
                board.printBoard();
                switchPlayer();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (board.hasWinner()) {
            switchPlayer();
            System.out.println(currentPlayer.getName() + " Wins!");
        } else {
            System.out.println("Its a Draw!");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    int getValidInput(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                if (input >= 0 && input <= 2) {
                    return input;
                }
            } else {
                sc.next();
            }
            System.out.println("Invalid input! Please enter a number between 0 and 2.");
        }
    }
}
