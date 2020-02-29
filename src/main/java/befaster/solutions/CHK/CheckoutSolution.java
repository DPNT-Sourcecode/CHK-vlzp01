package befaster.solutions.CHK;

import com.google.common.base.Strings;

import java.util.Optional;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        if(Strings.isNullOrEmpty(skus)) return 0;
        Optional<Order> order = OrderBuilder.createOrder(skus);
        return order.isPresent() ? order.get().totalValue() : -1;
    }
}

