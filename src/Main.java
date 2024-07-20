import java.util.Scanner;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();

        Date now = new Date();
        System.out.println("Game ended at: " + now.toString());
    }

}
