package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        if(Strings.isNullOrEmpty(skus)) return -1;
        HashMultiset<Character> productSet = HashMultiset.create();
        productSet.addAll(Lists.charactersOf(skus));
        productSet.s
        return 0;
    }
}
