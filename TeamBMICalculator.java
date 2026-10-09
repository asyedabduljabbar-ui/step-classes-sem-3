import java.util.Scanner;

/**
 * Problem 3: BMI Calculator for a Team.
 * BMI = weight (kg) / (height (m) * height (m)).
 */
public class TeamBMICalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        }
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights must have the same length.");
        }

        System.out.println("\n================ WELLNESS REPORT ================");
        System.out.printf("%-10s %-12s %-12s %-10s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] <= 0 || weights[i] <= 0) {
                System.out.printf("%-10s Invalid height/weight%n", "Person " + (i + 1));
                continue;
            }
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-10s %-12.2f %-12.2f %-10.2f %-15s%n",
                    "Person " + (i + 1), heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
        System.out.println("=================================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;

        while (true) {
            System.out.print("Enter number of people in the team (suggested: 10): ");
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                if (count > 0) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Please enter a positive whole number.");
        }

        double[] heights = new double[count];
        double[] weights = new double[count];

        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.print("Person " + (i + 1) + " - height in metres: ");
                if (scanner.hasNextDouble()) {
                    heights[i] = scanner.nextDouble();
                    if (heights[i] > 0) {
                        break;
                    }
                } else {
                    scanner.next();
                }
                System.out.println("Please enter a valid positive height.");
            }

            while (true) {
                System.out.print("Person " + (i + 1) + " - weight in kilograms: ");
                if (scanner.hasNextDouble()) {
                    weights[i] = scanner.nextDouble();
                    if (weights[i] > 0) {
                        break;
                    }
                } else {
                    scanner.next();
                }
                System.out.println("Please enter a valid positive weight.");
            }
        }

        printWellnessReport(heights, weights);
        scanner.close();
    }
}
