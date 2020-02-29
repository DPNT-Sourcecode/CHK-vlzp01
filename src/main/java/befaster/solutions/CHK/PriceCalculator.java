package befaster.solutions.CHK;

public interface PriceCalculator {

    default int priceOf(Product product) {
        return product.getQuantity() * product.getSkuItem().getPrice();
    }
}

