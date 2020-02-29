package befaster.solutions.CHK;

import befaster.solutions.CHK.pricing.PriceCalculator;

import java.util.HashSet;
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
        return new PriceCalculator().totalPrice(new HashSet<>(products));
    }
}

