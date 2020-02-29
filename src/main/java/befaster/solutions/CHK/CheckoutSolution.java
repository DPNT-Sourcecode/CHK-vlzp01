package befaster.solutions.CHK;

import java.util.Optional;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        Optional<Order> order = OrderBuilder.createOrder(skus);
        return order.isPresent() ? order.get().totalValue() : -1;
    }
}

