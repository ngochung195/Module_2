import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    void testFizz() {
        int number = 3;
        String expected = "Fizz";

        String result = FizzBuzz.fizzBuzz(number);

        assertEquals(expected, result);
    }

    @Test
    void testBuzz() {
        int number = 5;
        String expected = "Buzz";

        String result = FizzBuzz.fizzBuzz(number);

        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz() {
        int number = 15;
        String expected = "FizzBuzz";

        String result = FizzBuzz.fizzBuzz(number);

        assertEquals(expected, result);
    }

    @Test
    void testNotFizzBuzz() {
        int number = 2;
        String expected = "2";

        String result = FizzBuzz.fizzBuzz(number);

        assertEquals(expected, result);
    }
}