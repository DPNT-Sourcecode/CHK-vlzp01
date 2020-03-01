package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;
import befaster.solutions.CHK.SKUItem;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PriceCalculator {

    public Integer totalPrice(Set<Product> orderItems) {
        // apply basket offers
        currentOffers().forEach(offer -> offer.apply(orderItems));
        int totalPrice = 0;
        // find price for non composite items
        List<Product> nonCompositeProducts =
        for(Product orderItem : orderItems) {
            totalPrice += PricingStrategyFactory
                    .getStrategy(orderItem.getSkuItem())
                    .priceOf(orderItem.getQuantity(),orderItem.getSkuItem().getPrice());
        }
        return totalPrice;
    }

    private List<ProductOffer> currentOffers() {
        return Arrays.asList(
                new BuyNGetOtherProductOffer(SKUItem.E,SKUItem.B,2),
                new BuyNGetSameProductOffer(SKUItem.F,2),
                new BuyNGetOtherProductOffer(SKUItem.N,SKUItem.M,3),
                new BuyNGetOtherProductOffer(SKUItem.R,SKUItem.Q,3),
                new BuyNGetSameProductOffer(SKUItem.U,3));
    }

    private Set<SKUItem> compositeProducts() {
        
    }
}

