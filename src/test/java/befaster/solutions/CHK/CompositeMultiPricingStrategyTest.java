package befaster.solutions.CHK;

import befaster.solutions.CHK.pricing.CompositeMultiPricingStrategy;
import befaster.solutions.CHK.pricing.PriceCalculator;
import befaster.solutions.CHK.pricing.RegularPricingStrategy;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CompositeMultiPricingStrategyTest {

    private CompositeMultiPricingStrategy strategy = new CompositeMultiPricingStrategy(new RegularPricingStrategy(),3,45);

    @Test
    public void priceOf() {
        List<Product> products = Stream.of(new Product(SKUItem.S,1),new Product(SKUItem.T,1),
                new Product(SKUItem.X,1),new Product(SKUItem.Y,1),new Product(SKUItem.Z,1)).collect(Collectors.toList());
        assertThat(strategy.priceOf(products), equalTo(45 + 37));
    }

}

