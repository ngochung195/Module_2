import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CylinderTest {

    @Test
    void testGetVolumeRadius0Height0() {
        int radius = 0;
        int height = 0;

        double expected = 0;
        double result = Cylinder.getVolume(radius, height);

        assertEquals(expected, result, 0.000001);
    }

    @Test
    void testGetVolumeRadius1Height0() {
        int radius = 1;
        int height = 0;

        double expected = 2 * Math.PI;
        double result = Cylinder.getVolume(radius, height);

        assertEquals(expected, result, 0.000001);
    }

    @Test
    void testGetVolumeRadius1Height1() {
        int radius = 1;
        int height = 1;

        double expected = 4 * Math.PI;
        double result = Cylinder.getVolume(radius, height);

        assertEquals(expected, result, 0.000001);
    }
}