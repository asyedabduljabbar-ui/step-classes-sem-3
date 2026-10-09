import java.util.Scanner;

/**
 * Day 2 live-coding - Problem 4: Masked Phone Number Formatter.
 */
public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append('-');
        masked.append(phone.substring(6));
        return masked.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a 10-digit phone number: ");
        System.out.println(maskPhoneNumber(scanner.nextLine().trim()));
        scanner.close();
    }
}
