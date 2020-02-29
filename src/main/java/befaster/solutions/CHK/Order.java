package befaster.solutions.CHK;

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
        return new PriceCalculator().totalPrice(products);
    }
}

