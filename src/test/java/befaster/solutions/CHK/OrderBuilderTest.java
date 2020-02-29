package befaster.solutions.CHK;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class OrderBuilderTest {

    @Test
    public void buildOrder() {
        Order order = OrderBuilder.createOrder("AA");
        assertThat(order.getProducts(), hasSize(1));
        assertThat(order.getProducts().iterator().next().getSkuItem(), equalTo(SKUItem.A));
    }

    @Test
    public void buildCompositeOrder() {
        Order order = OrderBuilder.createOrder("AABADDCCC");
        assertThat(order.getProducts(), hasSize(4));
        Product productA = order.getProducts().stream()
                    .filter(product -> product.getSkuItem().equals(SKUItem.A))
                    .findFirst().get();
        assertThat(productA.getQuantity(), equalTo(3));
        Product productB = order.getProducts().stream()
                .filter(product -> product.getSkuItem().equals(SKUItem.B))
                .findFirst().get();
        assertThat(productB.getQuantity(), equalTo(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void buildInvalidOrder() {
        Order order = OrderBuilder.createOrder("XYZ");
        order.getProducts();
    }

}


