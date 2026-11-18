package salesreport;

import java.util.Scanner;

/**
 * Main class: reads the monthly sales and prints the product sales report.
 */
public class SalesReport {

    private static final int MONTHS = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Single array: product names
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};

        // Two-dimensional array: sales for each product (row) per month (column)
        int[][] sales = new int[names.length][MONTHS];

        // Read the sales for every product and every month
        for (int p = 0; p < names.length; p++) {
            for (int m = 0; m < MONTHS; m++) {
                System.out.print("Enter number of sales for month " + (m + 1)
                        + " for " + names[p] + " mattress: ");
                sales[p][m] = input.nextInt();
            }
            System.out.println();
        }

        // Create the Product object and the printer
        IProduct product = new Product(names, sales);
        PrintProduct printer = new PrintProduct(product);

        // Print the report
        System.out.println("\nPRODUCT SALES REPORT - 2026\n");
        System.out.println("*".repeat(50));
        printer.printTotalProductSales();
        printer.printAverageProductSales();
        printer.printMostPopularProduct();

        input.close();
    }
}
