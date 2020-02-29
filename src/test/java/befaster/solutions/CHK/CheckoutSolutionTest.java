package befaster.solutions.CHK;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CheckoutSolutionTest {

    private CheckoutSolution solution = new CheckoutSolution();

    @Test
    public void checkout_illegal_SKU() {
        assertThat(solution.checkout(null),equalTo(-1));
    }
}

