package ch8recursionAndDynamicProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripleStepTest {

    private TripleStep tripleStep;

    @BeforeEach
    public void setup() {
        this.tripleStep = new TripleStep();
    }

    @Test
    void whenNoSteps_returnOne() {
        assertEquals(1, tripleStep.numberOfAscents(0));
    }

    @Test
    void whenOneStep_returnOne() {
        assertEquals(1, tripleStep.numberOfAscents(1));
    }

    @Test
    void whenTwoSteps_returnTwo() {
        assertEquals(2, tripleStep.numberOfAscents(2));
    }

    @Test
    void whenThreeSteps_returnFour() {
        assertEquals(4, tripleStep.numberOfAscents(3));
    }

    @Test
    void whenFourSteps_returnSeven() {
        assertEquals(7, tripleStep.numberOfAscents(4));
    }

    @Test
    void whenManySteps_returnCorrectCount() {
        assertEquals(906045778, tripleStep.numberOfAscents(50));
    }
}
