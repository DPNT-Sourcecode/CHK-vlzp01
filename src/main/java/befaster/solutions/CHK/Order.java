package befaster.solutions.CHK;

import java.util.List;
import java.util.Set;

public class Order {

    private Set<Product> products;

    public Order(Set<Product> products) {
        this.products = products;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Integer totalValue() {
        MultiItemPriceCalculator calculator = new MultiItemPriceCalculator();
        return products.stream()
                .mapToInt(calculator::priceOf)
                .sum();
    }
}
