package befaster.solutions.CHK;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MultiItemPriceCalculatorTest {

    @Test
    public void priceOf() {
        MultiItemPriceCalculator calculator = new MultiItemPriceCalculator();
        Product productA = new Product(SKUItem.A,4);
        assertThat(calculator.priceOf(productA), equalTo(180));
        Product productB = new Product(SKUItem.B,3);
        assertThat(calculator.priceOf(productB), equalTo(75));
    }



}



