package befaster.solutions.CHK;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CheckoutSolutionTest {

    private CheckoutSolution solution = new CheckoutSolution();

    @Test
    public void checkout_illegal_SKU() {
        assertThat(solution.checkout(null),equalTo(0));
        assertThat(solution.checkout(""),equalTo(0));
    }

    @Test
    public void checkout_price() {
        assertThat(solution.checkout("ABCD"), equalTo(115));
        assertThat(solution.checkout("AAAABBBCD"), equalTo(130 + 50 + 45 + 30 + 20 + 15));
        //with checkout 2nd version rules
        assertThat(solution.checkout("AAAAAAAAABBBCDEE"), equalTo(200+ 130 + 50 + 45 + 20 + 15 + 80));
        //with checkout 3rd version rules
        assertThat(solution.checkout("AAAAAAAAABBBCDEEFFF"), equalTo(200+ 130 + 50 + 45 + 20 + 15 + 80 + 20));
    }
}
