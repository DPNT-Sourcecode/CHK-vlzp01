package befaster.solutions.CHK;

public class MultiPricingStrategy implements PricingStrategy {

    private final PricingStrategy strategy;

    public MultiPricingStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public int priceOf(Product product) {
        if(SKUItem.A.equals(product.getSkuItem())
            && product.getQuantity() >= 3 ) {
            int discountQuantity = product.getQuantity() / 3 ;
            int regularQuantity = product.getQuantity() % 3 ;
            return (discountQuantity * 130) + (regularQuantity * SKUItem.A.getPrice());
        } else if(SKUItem.B.equals(product.getSkuItem())
                && product.getQuantity() >= 2 ) {
            int discountQuantity = product.getQuantity() / 2 ;
            int regularQuantity = product.getQuantity() % 2 ;
            return (discountQuantity * 45) + (regularQuantity * SKUItem.B.getPrice());
        }
        return 0;
    }

    @Override
    public int priceOf(int quantity, int price) {
        return 0;
    }
}

