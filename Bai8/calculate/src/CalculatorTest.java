import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition() {
        int firstOperand = 10;
        int secondOperand = 10;

        int result = Calculator.calculate(
                firstOperand,
                secondOperand,
                Calculator.ADDITION);

        assertEquals(20, result);
    }

    @Test
    void testSubtraction() {
        int firstOperand = 10;
        int secondOperand = 5;

        int result = Calculator.calculate(
                firstOperand,
                secondOperand,
                Calculator.SUBTRACTION);

        assertEquals(5, result);
    }

    @Test
    void testMultiplication() {
        int firstOperand = 10;
        int secondOperand = 5;

        int result = Calculator.calculate(
                firstOperand,
                secondOperand,
                Calculator.MULTIPLICATION);

        assertEquals(50, result);
    }

    @Test
    void testDivision() {
        int firstOperand = 10;
        int secondOperand = 2;

        int result = Calculator.calculate(
                firstOperand,
                secondOperand,
                Calculator.DIVISION);

        assertEquals(5, result);
    }

    @Test
    void testDivisionByZero() {
        int firstOperand = 10;
        int secondOperand = 0;

        Exception exception = assertThrows(
                RuntimeException.class,
                () -> Calculator.calculate(
                        firstOperand,
                        secondOperand,
                        Calculator.DIVISION));

        assertEquals("Can not divide by 0", exception.getMessage());
    }

    @Test
    void testUnsupportedOperation() {
        int firstOperand = 10;
        int secondOperand = 5;

        Exception exception = assertThrows(
                RuntimeException.class,
                () -> Calculator.calculate(
                        firstOperand,
                        secondOperand,
                        '%'));

        assertEquals("Unsupported operation", exception.getMessage());
    }
}