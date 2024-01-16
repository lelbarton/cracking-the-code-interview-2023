package ch8recursionAndDynamicProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParensTest {

    private Parens parens;

    @BeforeEach
    public void setup() {
        this.parens = new Parens();
    }

    @Test
    void whenNisZero_returnEmptySet() {
        Set<String> validPairs = parens.getValidPairs(0);
        HashSet<Object> strings = new HashSet<>();

        assertEquals(strings, validPairs);
    }

    @Test
    void whenNis1_returnSetOfParenPair() {
        Set<String> validPairs = parens.getValidPairs(1);
        HashSet<Object> strings = new HashSet<>();
        strings.add("()");

        assertEquals(strings, validPairs);
    }

    @Test
    void whenNis2_returnCompleteSetOfParenPair() {
        Set<String> validPairs = parens.getValidPairs(2);
        Set<String> strings = Set.of("()()", "(())");

        assertEquals(strings, validPairs);
    }

    @Test
    void whenNisLarge_returnCompleteSetOfParenPair() {
        Set<String> validPairs = parens.getValidPairs(4);
        Set<String> strings = Set.of("()()()()", "(()())()", "(()(()))", "()()(())", "(())()()", "(((())))", "()((()))", "()(())()", "()(()())", "(()()())", "((()()))", "((()))()", "((())())");

        assertEquals(strings, validPairs);
    }
}
