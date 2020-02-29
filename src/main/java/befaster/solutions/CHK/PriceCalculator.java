package befaster.solutions.CHK;

import java.util.Set;

public class PriceCalculator {

    public Integer totalPrice(Set<Product> orderItems) {
        int totalPrice = 0;
        for(Product orderItem : orderItems) {
            totalPrice += PricingStrategyFactory
                    .getStrategy(orderItem.getSkuItem())
                    .priceOf(orderItem.getQuantity(),orderItem.getSkuItem().getPrice());
        }
        return totalPrice;
    }
}


