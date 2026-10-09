import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Week 2 assignment - Problem 5: Stop-Word-Filtered Word Frequency Report.
 */
public class StopWordFilteredWordFrequencyReport {
    private static final Set<String> STOP_WORDS = new HashSet<>();

    static {
        STOP_WORDS.add("the");
        STOP_WORDS.add("was");
        STOP_WORDS.add("and");
        STOP_WORDS.add("a");
        STOP_WORDS.add("is");
        STOP_WORDS.add("of");
        STOP_WORDS.add("in");
    }

    public static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replaceAll("[^a-z0-9\\s]", " ").trim();

        if (cleaned.isEmpty()) {
            System.out.println("No words to report.");
            return;
        }

        String[] words = cleaned.split("\\s+");
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty() && !STOP_WORDS.contains(word)) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort(Comparator.comparingInt(
                (Map.Entry<String, Integer> entry) -> entry.getValue()).reversed());

        if (entries.isEmpty()) {
            System.out.println("No words left after filtering stop words.");
            return;
        }

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter feedback text: ");
        printFilteredWordFrequency(scanner.nextLine());
        scanner.close();
    }
}
