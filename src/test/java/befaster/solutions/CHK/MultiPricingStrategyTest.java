package befaster.solutions.CHK;

import befaster.solutions.CHK.pricing.MultiPricingStrategy;
import befaster.solutions.CHK.pricing.PriceCalculator;
import befaster.solutions.CHK.pricing.RegularPricingStrategy;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MultiPricingStrategyTest {

    private MultiPricingStrategy strategy = new MultiPricingStrategy(new RegularPricingStrategy(),2,120);

    @Test
    public void priceOf() {
        assertThat(strategy.priceOf(3,SKUItem.K.getPrice()), equalTo(190));
    }

}

