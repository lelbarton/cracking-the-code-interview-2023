package ch8recursionAndDynamicProgramming;

import java.util.Arrays;

public class TripleStep {

    public int numberOfAscents(int steps) {
        int[] ascentCount = new int[steps + 1];
        Arrays.fill(ascentCount, -1);

        return numberOfAscentsRecursive(steps, ascentCount);
    }

    private int numberOfAscentsRecursive(int steps, int[] ascentCount) {
        if (steps < 0) {
            return 0;
        }
        if (steps == 0) {
            return 1;
        }

        if (ascentCount[steps] != -1) {
            return ascentCount[steps];
        }

        int total = numberOfAscentsRecursive(steps - 1, ascentCount) +
                numberOfAscentsRecursive(steps - 2, ascentCount) +
                numberOfAscentsRecursive(steps - 3, ascentCount);

        ascentCount[steps] = total;

        return total;
    }
}
