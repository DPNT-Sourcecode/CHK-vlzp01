package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;
import befaster.solutions.CHK.SKUItem;

import java.util.Optional;
import java.util.Set;

public class BuyNGetSameProductOffer implements ProductOffer {

    private final SKUItem skuItem;
    private final int discountThreshold;

    public BuyNGetSameProductOffer(SKUItem skuItem, int discountThreshold) {
        this.discountThreshold = discountThreshold;
        this.skuItem = skuItem;
    }

    public void apply(Set<Product> orderItems) {
        Optional<Product> productResult = findProduct(orderItems,skuItem);
        if(productResult.isPresent()) {
            Product product = productResult.get();
            if( product.getQuantity() >= (discountThreshold + 1)) {
               product.setQuantity(product.getQuantity() - product.getQuantity() / (discountThreshold + 1));
            }
        }
    }
}
