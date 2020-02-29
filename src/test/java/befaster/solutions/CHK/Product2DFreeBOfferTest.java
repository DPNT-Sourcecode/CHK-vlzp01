package befaster.solutions.CHK;

import befaster.solutions.CHK.pricing.Product2DFreeBOffer;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Product2DFreeBOfferTest {

    private Product2DFreeBOffer offer = new Product2DFreeBOffer();

    @Test
    public void applyOffer() {
        Set<Product> products = Stream.of(new Product(SKUItem.E,3),
                                    new Product(SKUItem.B,4)).collect(Collectors.toSet());
        offer.apply(products);
        Product productB = products.stream()
                .filter(product -> product.getSkuItem().equals(SKUItem.B))
                .findFirst().get();
        assertThat(productB.getQuantity(), equalTo(3));
    }

}
