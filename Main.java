
import java.util.Arrays;

class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Method overloading - Rule 1
    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    // Method overloading - Rule 2
    static boolean isDraftable(int matchesPlayed,
                               boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    // Compare players
    @Override
    public int compareTo(Player other) {

        double myPoints =
                matchesPlayed * battingAverage;

        double otherPoints =
                other.matchesPlayed * other.battingAverage;

        return Double.compare(otherPoints, myPoints);
    }

    // Draft and rank players
    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (Player player : players) {

            if (isDraftable(player.matchesPlayed) ||
                isDraftable(player.matchesPlayed,
                            player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        Player[] finalPlayers =
                Arrays.copyOf(draftable, count);

        Arrays.sort(finalPlayers);

        String result = "";

        for (int i = 0; i < finalPlayers.length; i++) {

            result += (i + 1) + ". "
                    + finalPlayers[i].name;

            if (i < finalPlayers.length - 1) {
                result += " | ";
            }
        }

        return result;
    }
}

public class Main {

    public static void main(String[] args) {

        Player[] players = {

            new Player("Virat", 15, 48.0, false),

            new Player("Rahul", 7, 55.0, false),

            new Player("Sameer", 3, 60.0, false),

            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(
            Player.draftAndRank(players)
        );
    }
}

