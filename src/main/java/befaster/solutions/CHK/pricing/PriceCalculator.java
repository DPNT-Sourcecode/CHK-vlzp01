package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;
import befaster.solutions.CHK.SKUItem;

import java.util.Set;

public class PriceCalculator {

    private ProductOffer basketOffer = new Buy2GetOtherProductFreeOffer(SKUItem.E,SKUItem.B);

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

