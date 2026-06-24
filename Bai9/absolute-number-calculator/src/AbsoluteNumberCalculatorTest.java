import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AbsoluteNumberCalculatorTest {

    @Test
    @DisplayName("Kiểm thử tìm giá trị tuyệt đối của số 0")
    void testFindAbsolute0() {
        int number = 0;
        int expected = 0;
        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Kiểm thử tìm giá trị tuyệt đối của số 1")
    void testFindAbsolute1() {
        int number = 1;
        int expected = 1;
        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Kiểm thử tìm giá trị tuyệt đối của số -1")
    void testFindAbsoluteNegative1() {
        int number = -1;
        int expected = 1;
        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }
}