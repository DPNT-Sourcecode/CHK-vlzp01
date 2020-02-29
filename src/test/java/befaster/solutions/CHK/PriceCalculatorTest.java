package befaster.solutions.CHK;

import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PriceCalculatorTest {

    private PriceCalculator calculator = new PriceCalculator();

    @Test
    public void priceOf() {
        Set<Product> products = Stream.of(new Product(SKUItem.A,3),
                                    new Product(SKUItem.B,4)).collect(Collectors.toSet());
        assertThat(calculator.totalPrice(products), equalTo(210));
    }

}