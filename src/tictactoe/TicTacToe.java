package tictactoe;

public class TicTacToe {
    public static void main(String[] args) {
        Player player1 = new Player("Tushar",'O');
        Player player2 = new Player("Alex",'X');
        Game game = new Game(player1,player2);
        game.play();
    }
}
