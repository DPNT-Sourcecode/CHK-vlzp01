package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompositeMultiPricingStrategy {

    private final PricingStrategy strategy;
    private final int discountThreshold;
    private final int discountPrice;


    public CompositeMultiPricingStrategy(PricingStrategy strategy, int discountThreshold, int discountPrice) {
        this.strategy = strategy;
        this.discountThreshold = discountThreshold;
        this.discountPrice = discountPrice;
    }

    public int priceOf(List<Product> products) {
        int totalPrice = 0;
        //sort in reverse pricing order,so that the order items grouping occurs in top priced items first
        products.sort(Comparator.comparing((Product product) -> product.getSkuItem().getPrice()).reversed());
        List<Product> scannedProducts = new ArrayList<>(products.size());
        int scannedQuantity = 0;
        // calculate discount price
        for(Product product:products) {
            scannedQuantity += product.getQuantity();
            // if eligible for discount threshold, apply discount
            if(scannedQuantity >= discountThreshold) {
                scannedProducts.clear();
                totalPrice += (scannedQuantity / discountThreshold) * discountPrice;
                scannedQuantity = scannedQuantity % discountThreshold;
                if(scannedQuantity > 0) {
                    product.setQuantity(scannedQuantity);
                    scannedProducts.add(product);
                }
            } else {
                scannedProducts.add(product);
            }
        }
        // calculate regular price for remaining
        for(Product product:scannedProducts) {
            totalPrice += strategy.priceOf(product.getQuantity(),product.getSkuItem().getPrice());
        }
        return totalPrice;
    }
}
