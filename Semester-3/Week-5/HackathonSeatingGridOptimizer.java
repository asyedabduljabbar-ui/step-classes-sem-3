public class HackathonSeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0;
        }

        int total = 0;
        for (int score : row) {
            total += score;
        }
        return (double) total / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);

            if (i > 0) {
                result += " | ";
            }

            result += "Row " + i + ": ";
            if (average < threshold) {
                result += "Quiet Zone";
            } else {
                result += "Buzzing Zone";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] scores = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        System.out.println(classifyRows(scores, 60));
    }
}
