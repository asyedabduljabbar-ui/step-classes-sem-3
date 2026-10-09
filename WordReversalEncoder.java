import java.util.Scanner;

/**
 * Week 2 assignment - Problem 2: Reverse every word while preserving word order.
 */
public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ", -1);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();
            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversedWord.append(words[i].charAt(j));
            }

            if (i > 0) {
                result.append(' ');
            }
            result.append(reversedWord);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        System.out.println(reverseEachWord(scanner.nextLine()));
        scanner.close();
    }
}
