import java.util.Scanner;

/**
 * Week 1 Assignment - Problem 4:
 * Compare inventory totals and locate the highest quantity in two sections.
 * If the maximum is tied, the first occurrence is reported.
 */
public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Both sections must contain the same number of items.");
            return;
        }
        if (sectionA.length == 0) {
            System.out.println("Inventory arrays are empty.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int highest = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);
        System.out.println("Status: " + (totalA == totalB ? "Balanced" : "Not Balanced"));
        System.out.println("Highest Quantity: " + highest + " (" + highestSection
                + ", Item " + (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of product categories: ");
        int count = scanner.nextInt();

        if (count <= 0) {
            System.out.println("Number of categories must be positive.");
            scanner.close();
            return;
        }

        int[] sectionA = new int[count];
        int[] sectionB = new int[count];

        System.out.println("Enter quantities for Section A:");
        for (int i = 0; i < count; i++) {
            sectionA[i] = scanner.nextInt();
        }

        System.out.println("Enter quantities for Section B:");
        for (int i = 0; i < count; i++) {
            sectionB[i] = scanner.nextInt();
        }

        analyzeInventory(sectionA, sectionB);
        scanner.close();
    }
}
