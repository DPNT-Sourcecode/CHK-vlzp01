package befaster.solutions.CHK;

import befaster.solutions.CHK.pricing.PriceCalculator;
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
        assertThat(calculator.totalPrice(products), equalTo(220));
    }

    @Test
    public void priceOf_R2Rule() {
        Set<Product> products = Stream.of(new Product(SKUItem.A,9)).collect(Collectors.toSet());
        assertThat(calculator.totalPrice(products), equalTo(200 + 130 + 50));
        products.add(new Product(SKUItem.E,1));
        assertThat(calculator.totalPrice(products), equalTo(200 + 130 + 50 + 40));
    }

    @Test
    public void priceOf_R5Rule() {
        Set<Product> products = Stream.of(new Product(SKUItem.A,9),new Product(SKUItem.E,1),
                new Product(SKUItem.K,2),new Product(SKUItem.X,3)).collect(Collectors.toSet());
        assertThat(calculator.totalPrice(products), equalTo(200 + 130 + 50 + 40 + 120 + 45));
    }

}


