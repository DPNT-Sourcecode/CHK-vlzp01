package befaster.solutions.CHK;

import com.google.common.base.Objects;

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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return skuItem == product.skuItem;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(skuItem);
    }
}
