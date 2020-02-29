package befaster.solutions.CHK;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

import java.util.List;
import java.util.stream.Collectors;

public class OrderBuilder {

    public static Order createOrder(String skus) {
        Multiset<Character> productSet = HashMultiset.create();
        productSet.addAll(Lists.charactersOf(skus));
        List<Product> products = productSet.elementSet()
                .stream()
                .map(skuChar -> {
                    return new Product(
                            SKUItem.valueOf(skuChar),
                            productSet.count(skuChar)
                    );})
                .collect(Collectors.toList());
        return new Order(products);
    }
}
