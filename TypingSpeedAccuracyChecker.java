import java.util.Scanner;

/**
 * Week 1 Assignment - Problem 2:
 * Compare typed text with the original passage character by character.
 * Mismatch positions are reported using 1-based indexing.
 */
public class TypingSpeedAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int total = Math.max(original.length(), typed.length());
        if (total == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
            return;
        }

        int matched = 0;
        int firstMismatch = -1;
        int compareLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < compareLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // Characters beyond the shorter string are mismatches.
        if (firstMismatch == -1 && original.length() != typed.length()) {
            firstMismatch = compareLength;
        }

        double accuracy = matched * 100.0 / total;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%%n", matched, total, accuracy);

        if (firstMismatch == -1) {
            System.out.println("No Mismatches");
        } else {
            char originalChar = firstMismatch < original.length()
                    ? original.charAt(firstMismatch) : '\0';
            char typedChar = firstMismatch < typed.length()
                    ? typed.charAt(firstMismatch) : '\0';

            System.out.print("First Mismatch at position " + (firstMismatch + 1) + " (");
            System.out.print(originalChar == '\0' ? "no character" : "'" + originalChar + "'");
            System.out.print(" vs ");
            System.out.print(typedChar == '\0' ? "no character" : "'" + typedChar + "'");
            System.out.println(")");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the original passage: ");
        String original = scanner.nextLine();
        System.out.print("Enter your typed passage: ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);
        scanner.close();
    }
}
