import java.util.Scanner;

/**
 * Problem 2: Palindrome Checker using three independent approaches.
 * This solution compares the input exactly as entered (case and spaces matter).
 */
public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return text.equals(new String(reversed));
    }

    private static String verdict(boolean palindrome) {
        return palindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String text = scanner.nextLine();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        System.out.println("Iterative: " + verdict(iterative));
        System.out.println("Recursive: " + verdict(recursive));
        System.out.println("Array Reversal: " + verdict(arrayReversal));

        if (iterative != recursive || iterative != arrayReversal) {
            System.out.println("Warning: the three approaches should produce the same result.");
        }
        scanner.close();
    }
}
