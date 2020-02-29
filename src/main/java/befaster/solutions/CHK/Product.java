package befaster.solutions.CHK;

public class Product {
    private SKUItem skuItem;
    private int quantity;

    public Product(SKUItem skuItem, int quantity) {
        this.skuItem = skuItem;
        this.quantity = quantity;
    }

    public SKUItem getSkuItem() {
        return skuItem;
    }

    public int getQuantity() {
        return quantity;
    }
}

