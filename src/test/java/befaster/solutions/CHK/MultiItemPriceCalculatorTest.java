package befaster.solutions.CHK;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MultiItemPriceCalculatorTest {

    @Test
    public void buildCompositeOrder() {
        MultiItemPriceCalculator calculator = new MultiItemPriceCalculator();
        Product productA = new Product(SKUItem.A,2);
        assertThat(calculator.priceOf(productA), equalTo(100));
    }



}
