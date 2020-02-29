package befaster.solutions.CHK.pricing;

public class MultiPricingStrategy implements PricingStrategy {

    private final PricingStrategy strategy;
    private final int discountThreshold;
    private final int discountPrice;


    public MultiPricingStrategy(PricingStrategy strategy,int discountThreshold,int discountPrice) {
        this.strategy = strategy;
        this.discountThreshold = discountThreshold;
        this.discountPrice = discountPrice;
    }

    @Override
    public int priceOf(int quantity, int price) {
        int totalPrice = 0;
        if(quantity >= discountThreshold) {
            totalPrice = (quantity / discountThreshold) * discountPrice;
            quantity = quantity % discountThreshold;
        }
        return totalPrice + strategy.priceOf(quantity,price);
    }
}
