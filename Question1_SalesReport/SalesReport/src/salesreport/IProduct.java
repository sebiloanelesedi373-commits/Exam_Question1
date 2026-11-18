package salesreport;

/**
 * Contract for any class that can summarise product sales.
 */
public interface IProduct {
    int GetTotalProductsSold();
    double GetAverageProductSold();
    String GetMostPopularProduct();
}
