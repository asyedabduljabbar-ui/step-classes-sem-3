import java.util.Scanner;

/**
 * Week 1 Assignment - Problem 5:
 * Categorize words as Short (1-4), Medium (5-8), or Long (9+) letters.
 * Punctuation attached to a word is excluded from its letter count.
 */
public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {
        String trimmed = review.trim();
        if (trimmed.isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = trimmed.split("\\s+");
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {
            int letters = 0;
            for (int i = 0; i < word.length(); i++) {
                if (Character.isLetterOrDigit(word.charAt(i))) {
                    letters++;
                }
            }

            if (letters >= 1 && letters <= 4) {
                shortWords++;
            } else if (letters >= 5 && letters <= 8) {
                mediumWords++;
            } else if (letters >= 9) {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords + " | Medium: "
                + mediumWords + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a movie review: ");
        String review = scanner.nextLine();

        classifyWordLengths(review);
        scanner.close();
    }
}
