package combiner;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CombinerTest {

    Combiner testCombiner;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testCombiner = new Combiner();
    }

    @Test
    void validateTooLong() {
        assertFalse(testCombiner.validate("23456"));
    }

    @Test
    void validateInvalidCharacters() {
        assertFalse(testCombiner.validate("2f3"));
    }

    @Test
    void validateValidInput() {
        assertAll(
                () -> assertTrue(testCombiner.validate("2345")),
                () -> assertTrue(testCombiner.validate(""))
        );
    }

    @Test
    void numberOfCombinations() {

        assertAll(
                () -> assertEquals(0, testCombiner.getAllCombinations("").size()),
                () -> assertEquals(3, testCombiner.getAllCombinations("2").size()),
                () -> assertEquals(Math.pow(3, 2), testCombiner.getAllCombinations("23").size()),
                () -> assertEquals(Math.pow(3, 3), testCombiner.getAllCombinations("234").size()),
                () -> assertEquals(Math.pow(3, 4), testCombiner.getAllCombinations("2345").size()),
                () -> assertEquals(Math.pow(4, 2), testCombiner.getAllCombinations("79").size())
        );
    }

    @Test
    void noDuplicates() {
        List<String> testCombinations = testCombiner.getAllCombinations("2379");
        Set<String> combinationset = new HashSet<>(testCombinations);

        assertEquals(combinationset.size(), testCombinations.size());
    }

    @Test
    void directAssertion() {
        List<String> testCombinations = testCombiner.getAllCombinations("23");
        List<String> expected = new ArrayList<>(Arrays.asList("ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf"));

        assertEquals(expected, testCombinations);

    }


}