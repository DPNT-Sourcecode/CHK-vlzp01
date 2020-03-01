package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;
import befaster.solutions.CHK.SKUItem;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PriceCalculator {

    public Integer totalPrice(Set<Product> orderItems) {
        // apply basket offers
        currentOffers().forEach(offer -> offer.apply(orderItems));
        int totalPrice = 0;
        EnumSet<SKUItem> compositeSKUItems = compositeSKUItems();
        // find price for non composite items
        Predicate<Product> nonCompositeSKUs = product -> ! compositeSKUItems.contains(product.getSkuItem());
        List<Product> nonCompositeProducts = filterProducts(orderItems,nonCompositeSKUs);
        for(Product orderItem : nonCompositeProducts) {
            totalPrice += PricingStrategyFactory
                    .getStrategy(orderItem.getSkuItem())
                    .priceOf(orderItem.getQuantity(),orderItem.getSkuItem().getPrice());
        }
        // find price for composite items
        Predicate<Product> compositeSKUs = product -> compositeSKUItems.contains(product.getSkuItem());
        List<Product> compositeProducts = filterProducts(orderItems,compositeSKUs);
        CompositeMultiPricingStrategy strategy = new CompositeMultiPricingStrategy(new RegularPricingStrategy(),3,45);
        totalPrice += strategy.priceOf(compositeProducts);
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

    private EnumSet<SKUItem> compositeSKUItems() {
        return EnumSet.of(SKUItem.S,SKUItem.T,SKUItem.X,SKUItem.Y,SKUItem.Z);
    }

    private List<Product> filterProducts(Set<Product> orderItems, Predicate<Product> filter) {
        return orderItems.stream()
                .filter(filter)
                .collect(Collectors.toList());

    }
}
