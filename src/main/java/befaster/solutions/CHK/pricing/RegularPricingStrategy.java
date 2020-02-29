package befaster.solutions.CHK.pricing;

public class RegularPricingStrategy implements PricingStrategy {

    @Override
    public int priceOf(int quantity, int price) {
        return quantity * price;
    }
}
