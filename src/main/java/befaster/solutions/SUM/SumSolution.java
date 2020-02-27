package befaster.solutions.SUM;

import befaster.runner.SolutionNotImplementedException;

@SuppressWarnings("unused")
public class SumSolution {

    public int compute(int x, int y) {
        if(x < 0 || x > 100)
            throw new IllegalArgumentException("summand should be a positive integer between 0-100");
        return x + y;
    }

}


