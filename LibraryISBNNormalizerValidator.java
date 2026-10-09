import java.util.Scanner;

/**
 * Week 2 assignment - Problem 4: Library ISBN-style Code Normalizer and Validator.
 *
 * Required format: 3 letters + 4 year digits + 6 catalog digits (13 characters).
 */
public class LibraryISBNNormalizerValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }

        String code = raw.trim();
        if (code.length() < 3) {
            return code.toUpperCase();
        }
        return code.substring(0, 3).toUpperCase() + code.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must contain exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: year and catalog must contain digits only";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);
        return "[" + publisher + "] YEAR: " + year + " | CATALOG: " + catalog;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter library code: ");
        String normalized = normalizeCode(scanner.nextLine());
        System.out.println(validateAndFormat(normalized));
        scanner.close();
    }
}
