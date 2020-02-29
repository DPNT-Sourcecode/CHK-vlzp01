package befaster.solutions.CHK;

public interface PriceStrategy {

    default int priceOf(Product product) {
        return product.getQuantity() * product.getSkuItem().getPrice();
    }
}
