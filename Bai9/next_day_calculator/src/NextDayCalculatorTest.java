import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextDayCalculatorTest {

    @Test
    void testNormalDay() {
        String expected = "2/1/2018";

        String actual = NextDayCalculator.getNextDay(1, 1, 2018);

        assertEquals(expected, actual);
    }

    @Test
    void testEndOfMonthJanuary() {
        String expected = "1/2/2018";
        String actual = NextDayCalculator.getNextDay(31, 1, 2018);

        assertEquals(expected, actual);
    }

    @Test
    void testEndOfMonthApril() {
        String expected = "1/5/2018";
        String actual = NextDayCalculator.getNextDay(30, 4, 2018);

        assertEquals(expected, actual);
    }

    @Test
    void testEndOfFebruaryNormalYear() {
        String expected = "1/3/2018";
        String actual = NextDayCalculator.getNextDay(28, 2, 2018);

        assertEquals(expected, actual);
    }

    @Test
    void testEndOfFebruaryLeapYear() {
        String expected = "1/3/2020";
        String actual = NextDayCalculator.getNextDay(29, 2, 2020);

        assertEquals(expected, actual);
    }

    @Test
    void testEndOfYear() {
        String expected = "1/1/2019";
        String actual = NextDayCalculator.getNextDay(31, 12, 2018);

        assertEquals(expected, actual);
    }
}