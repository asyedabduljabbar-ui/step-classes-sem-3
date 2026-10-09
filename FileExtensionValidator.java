import java.util.Scanner;

/**
 * Day 2 live-coding - Problem 3: File Extension Validator.
 */
public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        String cleanName = filename.trim();
        int dotIndex = cleanName.lastIndexOf('.');

        if (dotIndex <= 0 || dotIndex == cleanName.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = cleanName.substring(dotIndex + 1);
        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename: ");
        System.out.println(validateFileExtension(scanner.nextLine()));
        scanner.close();
    }
}
