package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;

import java.util.List;

public class CompositeMultiPricingStrategy {

    private final PricingStrategy strategy;
    private final int discountThreshold;
    private final int discountPrice;


    public CompositeMultiPricingStrategy(PricingStrategy strategy, int discountThreshold, int discountPrice) {
        this.strategy = strategy;
        this.discountThreshold = discountThreshold;
        this.discountPrice = discountPrice;
    }

    public int priceOf(List<Product> products) {
        int totalPrice = 0;
        
        return totalPrice;
    }
}
