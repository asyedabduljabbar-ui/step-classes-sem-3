import java.util.Scanner;

/**
 * Day 2 live-coding - Problem 5: Bank Transaction Reference Generator and Validator.
 *
 * Reference format: 3 letters + 6 digits (ddMMyy) + 5 sequence digits.
 * Example: HDF03022600042
 */
public class BankTransactionReferenceGeneratorValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }

        String reference = raw.trim();
        if (reference.length() < 3) {
            return reference.toUpperCase();
        }
        return reference.substring(0, 3).toUpperCase() + reference.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must contain exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: date and sequence must contain digits only";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 5) + "/"
                + reference.substring(5, 7) + "/"
                + reference.substring(7, 9);
        String sequence = reference.substring(9);

        return "[" + bankCode + "] DATE: " + date + " | SEQ: " + sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transaction reference: ");
        String normalized = normalizeReference(scanner.nextLine());
        System.out.println(validateAndFormat(normalized));
        scanner.close();
    }
}
