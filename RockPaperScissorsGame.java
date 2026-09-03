import java.util.*;

public class RockPaperScissorsGame {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final Random RAND = new Random();

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 5;
        String[] playerMoves = new String[N];
        String[] computerMoves = new String[N];
        String[] results = new String[N];
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < N; i++) {
            System.out.print("Round " + (i + 1) + " — Enter your move (Rock/Paper/Scissors): ");
            String player = sc.nextLine().trim();
            // Capitalize first letter
            if (player.length() > 0) {
                player = player.substring(0, 1).toUpperCase() + player.substring(1).toLowerCase();
            }
            String computer = MOVES[RAND.nextInt(3)];
            String result = playRound(player, computer);

            playerMoves[i] = player;
            computerMoves[i] = computer;
            results[i] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        // Print summary table
        System.out.println("\nRound | Player Move | Computer Move | Result");
        for (int i = 0; i < N; i++) {
            System.out.printf("%5d | %-12s | %-14s | %s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercent = (wins * 100.0) / N;
        System.out.printf("\nFinal Summary (after %d rounds)%n", N);
        System.out.printf("Wins: %d / Losses: %d / Draws: %d / Win %% = %.1f%%%n",
                wins, losses, draws, winPercent);
    }
}