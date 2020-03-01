package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;
import befaster.solutions.CHK.SKUItem;

import java.util.Optional;
import java.util.Set;

public class Buy2GetOtherProductFreeOffer implements ProductOffer {

    private final SKUItem buy2Item;
    private final SKUItem freeItem;

    public Buy2GetOtherProductFreeOffer(SKUItem buy2Item, SKUItem freeItem) {
        this.buy2Item = buy2Item;
        this.freeItem = freeItem;
    }

    public void apply(Set<Product> orderItems) {
        Optional<Product> productBuy2Result = findProduct(orderItems,buy2Item);
        if(productBuy2Result.isPresent()) {
            Product productE = productBuy2Result.get();
           if( productE.getQuantity() >= 2) {
               Optional<Product> freeProductResult = findProduct(orderItems,freeItem);
               if(freeProductResult.isPresent()) {
                   Product freeProduct = freeProductResult.get();
                   int freeProductCount = productE.getQuantity() / 2;
                   int adjustedProductBCount = Math.max(0,freeProduct.getQuantity() - freeProductCount);
                   if(adjustedProductBCount == 0)
                       orderItems.remove(freeProduct);
                   else
                       freeProduct.setQuantity(adjustedProductBCount);
               }
           }
        }
    }
}
