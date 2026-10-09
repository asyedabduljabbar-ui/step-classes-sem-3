import java.util.Scanner;

/**
 * Week 2 assignment - Problem 1: ATM PIN Length Validator.
 * This problem checks length only, as specified in the exercise.
 */
public class ATMPinLengthValidator {

    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your 4-character PIN: ");
        checkPinLength(scanner.nextLine());
        scanner.close();
    }
}
