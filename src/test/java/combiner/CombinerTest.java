package combiner;

import org.junit.jupiter.api.Test;

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
                () -> assertEquals(Math.pow(3, 4), testCombiner.getAllCombinations("2345").size())

        );
    }
}