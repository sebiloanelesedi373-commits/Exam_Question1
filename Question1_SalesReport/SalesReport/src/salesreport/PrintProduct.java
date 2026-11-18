package salesreport;

import java.text.DecimalFormat;

/**
 * Responsible only for printing the report data.
 */
public class PrintProduct {

    private final IProduct product;

    public PrintProduct(IProduct product) {
        this.product = product;
    }

    public void printTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageProductSales() {
        // "0.##" shows 17 instead of 17.0, but still shows decimals when needed
        DecimalFormat format = new DecimalFormat("0.##");
        System.out.println("AVERAGE PRODUCT SALES: " + format.format(product.GetAverageProductSold()));
    }

    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
