package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;
import befaster.solutions.CHK.SKUItem;

import java.util.Optional;
import java.util.Set;

public class BuyNGetOtherProductOffer implements ProductOffer {

    private final SKUItem buy2Item;
    private final SKUItem freeItem;
    private final int discountThreshold;

    public BuyNGetOtherProductOffer(SKUItem buy2Item, SKUItem freeItem,int discountThreshold) {
        this.buy2Item = buy2Item;
        this.freeItem = freeItem;
        this.discountThreshold = discountThreshold;
    }

    public void apply(Set<Product> orderItems) {
        Optional<Product> productBuy2Result = findProduct(orderItems,buy2Item);
        if(productBuy2Result.isPresent()) {
            Product productE = productBuy2Result.get();
           if( productE.getQuantity() >= discountThreshold) {
               Optional<Product> freeProductResult = findProduct(orderItems,freeItem);
               if(freeProductResult.isPresent()) {
                   Product freeProduct = freeProductResult.get();
                   int freeProductCount = productE.getQuantity() / discountThreshold;
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
