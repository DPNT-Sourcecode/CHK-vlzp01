package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;
import befaster.solutions.CHK.SKUItem;

import java.util.Optional;
import java.util.Set;

public interface ProductOffer {
    void apply(Set<Product> products);

    default Optional<Product> findProduct(Set<Product> orderItems, SKUItem skuItem) {
        return orderItems.stream()
                .filter(orderItem -> skuItem.equals(orderItem.getSkuItem()))
                .findFirst();
    }
}
