package befaster.solutions.HLO;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;

public class HelloSolutionTest {

    @Test
    public void hello(){
        HelloSolution helloSolution = new HelloSolution();
        assertThat(helloSolution.hello("some name"),equalTo("Hello World!"));
    }
}


