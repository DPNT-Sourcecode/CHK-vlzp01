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
        assertThat(order.getProducts().get(0).getSkuItem(), equalTo(SKUItem.A));
    }

    @Test
    public void buildCompositeOrder() {
        Order order = OrderBuilder.createOrder("AABADDCCC");
        assertThat(order.getProducts(), hasSize(4));
        //assertThat(order.getProducts().get(0).getSkuItem(), equalTo(SKUItem.A));
    }


}



