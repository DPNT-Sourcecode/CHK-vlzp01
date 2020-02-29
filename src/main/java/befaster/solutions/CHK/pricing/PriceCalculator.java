package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;

import java.util.Set;

public class PriceCalculator {

    private PriceAdjuster adjuster;

    public Integer totalPrice(Set<Product> orderItems) {
        adjuster.apply(orderItems);
        int totalPrice = 0;
        for(Product orderItem : orderItems) {
            totalPrice += PricingStrategyFactory
                    .getStrategy(orderItem.getSkuItem())
                    .priceOf(orderItem.getQuantity(),orderItem.getSkuItem().getPrice());
        }
        return totalPrice;
    }
}

