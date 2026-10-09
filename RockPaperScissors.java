import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Problem 1: Rock-Paper-Scissors Game.
 * Plays five rounds and prints a scoreboard with the final statistics.
 */
public class RockPaperScissors {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final int ROUNDS = 5;
    private static final Random RANDOM = new Random();

    private static class RoundResult {
        int round;
        String playerMove;
        String computerMove;
        String result;

        RoundResult(int round, String playerMove, String computerMove, String result) {
            this.round = round;
            this.playerMove = playerMove;
            this.computerMove = computerMove;
            this.result = result;
        }
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    private static String normalizeMove(String move) {
        for (String validMove : MOVES) {
            if (validMove.equalsIgnoreCase(move.trim())) {
                return validMove;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<RoundResult> history = new ArrayList<>();
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=== Rock-Paper-Scissors (5 rounds) ===");
        for (int round = 1; round <= ROUNDS; round++) {
            String playerMove;
            while (true) {
                System.out.print("Round " + round + " - Enter Rock, Paper, or Scissors: ");
                playerMove = normalizeMove(scanner.nextLine());
                if (playerMove != null) {
                    break;
                }
                System.out.println("Invalid move. Please enter Rock, Paper, or Scissors.");
            }

            String computerMove = MOVES[RANDOM.nextInt(MOVES.length)];
            String result = playRound(playerMove, computerMove);
            history.add(new RoundResult(round, playerMove, computerMove, result));

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            System.out.println(result + " (computer chose " + computerMove + ")");
        }

        System.out.println("\n--------------- SCOREBOARD ---------------");
        System.out.printf("%-8s %-12s %-16s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");
        for (RoundResult result : history) {
            System.out.printf("%-8d %-12s %-16s %-15s%n",
                    result.round, result.playerMove, result.computerMove, result.result);
        }
        System.out.println("-------------------------------------------");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws);
        System.out.printf("Player Win Percentage: %.1f%%%n", wins * 100.0 / ROUNDS);
        scanner.close();
    }
}
