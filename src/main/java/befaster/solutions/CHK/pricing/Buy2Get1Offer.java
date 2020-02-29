package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;
import befaster.solutions.CHK.SKUItem;

import java.util.Optional;
import java.util.Set;

public class Buy2Get1Offer implements ProductOffer {

    private final SKUItem skuItem;

    public Buy2Get1Offer(SKUItem skuItem) {
        this.skuItem = skuItem;
    }

    public void apply(Set<Product> orderItems) {
        Optional<Product> productResult = findProduct(orderItems,skuItem);
        if(productResult.isPresent()) {
            Product productE = productResult.get();
           if( productE.getQuantity() >= 3) {
                   int productBFreeCount = productE.getQuantity() / 3;
                    productE.setQuantity(productBFreeCount);
           }
        }
    }
}
