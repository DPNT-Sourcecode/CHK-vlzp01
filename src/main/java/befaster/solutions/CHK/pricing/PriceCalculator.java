package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;
import befaster.solutions.CHK.SKUItem;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PriceCalculator {

    private ProductOffer basketOffer = new Buy2GetOtherProductFreeOffer(SKUItem.E,SKUItem.B);

    public Integer totalPrice(Set<Product> orderItems) {
        currentOffers().forEach(offer -> offer.apply(orderItems));
        int totalPrice = 0;
        for(Product orderItem : orderItems) {
            totalPrice += PricingStrategyFactory
                    .getStrategy(orderItem.getSkuItem())
                    .priceOf(orderItem.getQuantity(),orderItem.getSkuItem().getPrice());
        }
        return totalPrice;
    }

    private List<ProductOffer> currentOffers() {
        return Arrays.asList(new Buy2GetOtherProductFreeOffer(SKUItem.E,SKUItem.B),
                                new Buy2Get1Offer(SKUItem.F));
    }
}
