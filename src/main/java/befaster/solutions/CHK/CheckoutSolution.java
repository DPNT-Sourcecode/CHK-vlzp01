package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        if(Strings.isNullOrEmpty(skus)) return -1;
        Multiset<Character> productSet = HashMultiset.create();
        productSet.addAll(Lists.charactersOf(skus));
        List<Product> products = productSet.stream()
                .map(skuChar -> {
                    return new Product(
                            SKUItem.valueOf(skuChar),
                            productSet.count(skuChar)
                    );})
                .collect(Collectors.toList());
        return 0;
    }
}

