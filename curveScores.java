import java.util.*;

public class curveScores {

    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {10, 20, 30};
        int bonus = 5;

        curveScores(scores, bonus);

        System.out.println(Arrays.toString(scores));
    }
}