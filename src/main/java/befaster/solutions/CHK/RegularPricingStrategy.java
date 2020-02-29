package befaster.solutions.CHK;

public class RegularPricingStrategy implements PricingStrategy {

    private final PricingStrategy strategy;

    public RegularPricingStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public int priceOf(int quantity, int price) {
        return quantity * price;
    }
}

