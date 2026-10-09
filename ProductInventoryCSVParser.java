import java.util.Scanner;

/**
 * Week 2 assignment - Problem 3: Product Inventory CSV Parser.
 */
public class ProductInventoryCSVParser {

    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        if (productName.isEmpty() || sku.isEmpty() || quantity.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + productName + " | SKU: " + sku
                + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter inventory CSV (ProductName,SKU,Quantity): ");
        parseInventoryRecord(scanner.nextLine());
        scanner.close();
    }
}
