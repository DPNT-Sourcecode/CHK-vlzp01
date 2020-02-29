package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;

import java.util.Set;

public class PriceCalculator {

    private ProductOffer basketOffer = new Product2EFreeBOffer();

    public Integer totalPrice(Set<Product> orderItems) {
        basketOffer.apply(orderItems);
        int totalPrice = 0;
        for(Product orderItem : orderItems) {
            totalPrice += PricingStrategyFactory
                    .getStrategy(orderItem.getSkuItem())
                    .priceOf(orderItem.getQuantity(),orderItem.getSkuItem().getPrice());
        }
        return totalPrice;
    }
}
