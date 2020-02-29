package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;
import befaster.solutions.CHK.SKUItem;

import java.util.Optional;
import java.util.Set;

public class Product2DFreeBOffer  implements ProductOffer {
    public void apply(Set<Product> orderItems) {
        Optional<Product> productEResult = findProduct(orderItems,SKUItem.E);
        if(productEResult.isPresent()) {
            Product productE = productEResult.get();
           if( productE.getQuantity() >= 2) {
               Optional<Product> productBResult = findProduct(orderItems,SKUItem.B);
               if(productBResult.isPresent()) {
                   Product productB = productBResult.get();
                   int productBFreeCount = productE.getQuantity() / 2;
                   int adjustedProductBCount = Math.max(0,productB.getQuantity() - productBFreeCount);
                   if(adjustedProductBCount == 0)
                       orderItems.remove(productB);
                   else
                       productB.setQuantity(adjustedProductBCount);
               }
           }
        }
    }

    private Optional<Product> findProduct(Set<Product> orderItems, SKUItem skuItem) {
        return orderItems.stream()
                .filter(orderItem -> skuItem.equals(orderItem.getSkuItem()))
                .findFirst();
    }
}
