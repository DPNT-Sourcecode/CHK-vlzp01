package befaster.solutions.CHK;

import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderBuilder {

    public static Optional<Order> createOrder(String skus) {
        if(Strings.isNullOrEmpty(skus)) return Optional.empty();
        Multiset<Character> productSet = HashMultiset.create();
        productSet.addAll(Lists.charactersOf(skus));
        try {
            Set<Product> products = productSet.elementSet()
                    .stream()
                    .map(skuChar -> {
                        return new Product(
                                SKUItem.valueOf(skuChar),
                                productSet.count(skuChar)
                        );})
                    .collect(Collectors.toSet());
            return Optional.of(new Order(products));
        }catch (IllegalArgumentException ex) {
            return Optional.empty();
        }

    }
}
