package befaster.solutions.CHK;

public class MultiItemPriceCalculator implements PriceCalculator {

    @Override
    public int priceOf(Product product) {
        if(SKUItem.A.equals(product.getSkuItem())
            && product.getQuantity() > 3 ) {
            return 0;
        }
        return PriceCalculator.super.priceOf(product);
    }
}


