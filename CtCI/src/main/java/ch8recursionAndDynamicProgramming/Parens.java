package ch8recursionAndDynamicProgramming;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Parens {

    // n = 0 -> ""
    // n = 1 -> ()
    // n = 2 -> ()(), (())
    // n = 3 -> ()()(), (()()), ()(()), (())(), ((()))
    // n = 4 -> ()()()(), (()())(), ()(()()), ((()())), ()(())(), (()(())), ()()(()), (())()(), ((())()), ()((())), ((()))(), (((())))
    // assuming set for previous n is correct, we can add a new set as prefix or suffix, or enclosing whole string.
    // this isn't super efficient because we make a lot of duplicate strings.
    public Set<String> getValidPairs(int n) {
        return printValidPairsRecursive(n);
    }

    private Set<String> printValidPairsRecursive(int n) {
        if (n == 0) {
            return new HashSet<>();
        }
        if (n == 1) {
            return Set.of("()");
        }

        Set<String> substrings = printValidPairsRecursive(n - 1);

        return substrings.stream()
                .map((str) -> {
                    String first = "()" + str;
                    String second = str + "()";
                    String third = "(" + str + ")";

                    HashSet<String> strings = new HashSet<>();
                    strings.add(first);
                    strings.add(second);
                    strings.add(third);

                    return strings;
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
