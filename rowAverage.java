public class rowAverage {

    private static double rowAverage(int[] row) {
        int sum = 0;

        for (int value : row) {
            sum += value;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";

            if (i > 0) sb.append(" | ");

            sb.append("Row ").append(i).append(": ").append(zone);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {80, 90, 70},
            {40, 50, 60},
            {90, 95, 85}
        };

        int threshold = 60;

        System.out.println(classifyRows(seatingScores, threshold));
    }
}