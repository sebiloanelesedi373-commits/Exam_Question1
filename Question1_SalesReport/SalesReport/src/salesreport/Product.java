package salesreport;

/**
 * Holds the sales data and calculates the report values.
 * A single array stores the product names and a two-dimensional
 * array stores the sales: rows = products, columns = months.
 */
public class Product implements IProduct {

    private final String[] productNames; // single-dimensional array
    private final int[][] sales;         // two-dimensional array [product][month]

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    // Adds up the sales of one product over all months.
    // Used by the other methods so the loop is written only once.
    private int getProductTotal(int productIndex) {
        int total = 0;
        for (int monthSales : sales[productIndex]) {
            total += monthSales;
        }
        return total;
    }

    // Total number of products sold across all products and months.
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            total += getProductTotal(i);
        }
        return total;
    }

    // Average = total sold / number of sales entries (products x months).

    public double GetAverageProductSold() {
        int entries = sales.length * sales[0].length;
        return (double) GetTotalProductsSold() / entries;
    }

    // Finds the product with the highest total sales.
    
    public String GetMostPopularProduct() {
        int bestIndex = 0;
        for (int i = 1; i < sales.length; i++) {
            if (getProductTotal(i) > getProductTotal(bestIndex)) {
                bestIndex = i;
            }
        }
        return productNames[bestIndex] + "(" + getProductTotal(bestIndex) + ")";
    }
}
