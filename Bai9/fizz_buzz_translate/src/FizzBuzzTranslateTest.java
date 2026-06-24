import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzTranslateTest {

    @Test
    public void testDivisibleBy3() {
        assertEquals("Fizz", FizzBuzzTranslate.translate(6));
    }

    @Test
    public void testContains3() {
        assertEquals("Fizz", FizzBuzzTranslate.translate(13));
    }

    @Test
    public void testDivisibleBy5() {
        assertEquals("Buzz", FizzBuzzTranslate.translate(10));
    }

    @Test
    public void testContains5() {
        assertEquals("Buzz", FizzBuzzTranslate.translate(52));
    }

    @Test
    public void testFizzBuzzDivisible() {
        assertEquals("FizzBuzz", FizzBuzzTranslate.translate(15));
    }

    @Test
    public void testFizzBuzzContains() {
        assertEquals("FizzBuzz", FizzBuzzTranslate.translate(53));
    }

    @Test
    public void testNormalNumber1Digit() {
        assertEquals("một", FizzBuzzTranslate.translate(1));
    }

    @Test
    public void testNormalNumber2Digits() {
        assertEquals("hai sáu", FizzBuzzTranslate.translate(26));
    }

    @Test
    void testInvalidLow() {
        assertThrows(IllegalArgumentException.class,
                () -> FizzBuzzTranslate.translate(0));
    }

    @Test
    void testInvalidHigh() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzzTranslate.translate(100));
    }
}