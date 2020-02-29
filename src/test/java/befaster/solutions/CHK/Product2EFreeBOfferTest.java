package befaster.solutions.CHK;

import befaster.solutions.CHK.pricing.Product2EFreeBOffer;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Product2EFreeBOfferTest {

    private Product2EFreeBOffer offer = new Product2EFreeBOffer();

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

    @Test
    public void applyOfferRemoveProductB() {
        Set<Product> products = Stream.of(new Product(SKUItem.E,4),
                new Product(SKUItem.B,2)).collect(Collectors.toSet());
        offer.apply(products);
        Optional<Product> productB = products.stream()
                .filter(product -> product.getSkuItem().equals(SKUItem.B))
                .findFirst();
        assertThat(productB.isPresent(), equalTo(false));
    }

}
