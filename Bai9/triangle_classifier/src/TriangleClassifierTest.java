import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TriangleClassifierTest {
    @Test
    public void testEquilateralTriangle() {
        String expected = "Tam giác đều";

        String actual = TriangleClassifier.getTriangleClassifier(2, 2, 2);

        assertEquals(expected, actual);
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals("Tam giác cân",
                TriangleClassifier.getTriangleClassifier(2, 2, 3));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals("Tam giác thường",
                TriangleClassifier.getTriangleClassifier(3, 4, 5));
    }

    @Test
    public void testNotTriangleNegative() {
        assertEquals("Không phải là tam giác",
                TriangleClassifier.getTriangleClassifier(8, 2, 3));
    }

    @Test
    public void testNotTriangleNegativeNumber() {
        assertEquals("Không phải là tam giác",
                TriangleClassifier.getTriangleClassifier(-1, 2, 1));
    }

    @Test
    public void testNotTriangleZero() {
        assertEquals("Không phải là tam giác",
                TriangleClassifier.getTriangleClassifier(0, 1, 1));
    }
}
