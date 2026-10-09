import java.util.Scanner;

/**
 * Week 1 Assignment - Problem 3:
 * Find the longest continuous streak of the same traffic-signal color.
 * R = red, Y = yellow, G = green.
 */
public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Signal log is empty.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;
        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char color = signalLog.charAt(i);

            if (color == currentColor) {
                currentLength++;
            } else {
                currentColor = color;
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor
                + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter signal log using R, Y, and G (e.g., RRGGGYYR): ");
        String signalLog = scanner.nextLine().trim().toUpperCase();

        boolean valid = true;
        for (int i = 0; i < signalLog.length(); i++) {
            char color = signalLog.charAt(i);
            if (color != 'R' && color != 'Y' && color != 'G') {
                valid = false;
                break;
            }
        }

        if (!valid) {
            System.out.println("Invalid signal log. Use only R, Y, and G.");
        } else {
            findLongestStreak(signalLog);
        }
        scanner.close();
    }
}
