import java.util.Scanner;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private Timer timer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        timer = new Timer();
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("-----------");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("-----------");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            printBoard();
            System.out.println(currentPlayer + "'o'yinchining navbati. Qator va ustunni kiriting (0, 1 yoki 2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
                System.out.println("Bu harakat haqiqiy emas");
                continue;
            }

            board[row][col] = currentPlayer;
            if (checkForWin()) {
                printBoard();
                System.out.println("O'yinchi " + currentPlayer + " yutdi!");
                gameOver = true;
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("O'yin durrang bilan yakunlandi!");
                gameOver = true;
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        scanner.close();
    }

    private boolean checkForWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }
}
