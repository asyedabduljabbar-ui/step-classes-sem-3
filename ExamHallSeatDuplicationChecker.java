import java.util.Scanner;

/**
 * Week 1 Assignment - Problem 1:
 * Find duplicate seat numbers using arrays and nested loops only.
 * No collections are used.
 */
public class ExamHallSeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        System.out.print("Duplicate Seat Numbers: ");

        for (int i = 0; i < seatNumbers.length; i++) {
            boolean appearedEarlier = false;

            // Do not print a duplicate value more than once.
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    appearedEarlier = true;
                    break;
                }
            }
            if (appearedEarlier) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.print(seatNumbers[i] + " ");
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (duplicateFound) {
            System.out.println();
        } else {
            System.out.println("None");
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of assigned seats: ");
        int count = scanner.nextInt();

        if (count < 0) {
            System.out.println("Number of seats cannot be negative.");
            scanner.close();
            return;
        }

        int[] seats = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter seat number " + (i + 1) + ": ");
            seats[i] = scanner.nextInt();
        }

        checkDuplicateSeats(seats);
        scanner.close();
    }
}
