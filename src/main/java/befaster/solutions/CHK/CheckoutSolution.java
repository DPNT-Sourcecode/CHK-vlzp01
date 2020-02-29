package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        Optional<Order> order = OrderBuilder.createOrder(skus);
        return order.isPresent() ? order.get().totalValue() : -1;
    }
}



