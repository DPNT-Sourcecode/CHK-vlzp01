package befaster.solutions.CHK;

import befaster.solutions.CHK.pricing.Buy2Get1Offer;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Buy2Get1OfferTest {

    private Buy2Get1Offer offer = new Buy2Get1Offer(SKUItem.F);

    @Test
    public void applyOffer() {
        Set<Product> products = Stream.of(new Product(SKUItem.F,5)).collect(Collectors.toSet());
        offer.apply(products);
        Product product = offer.findProduct(products,SKUItem.F).get();
        assertThat(product.getQuantity(), equalTo(4));

        products = Stream.of(new Product(SKUItem.F,6)).collect(Collectors.toSet());
        offer.apply(products);
        product = offer.findProduct(products,SKUItem.F).get();
        assertThat(product.getQuantity(), equalTo(4));
    }

}
