import org.labs.lab1.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LICTest {

    // Proposed naming convention:
    // testLIC0_TypeOfData[Positive/Negative/Invalid]() { ... }

    @Test
    public void testLIC4_Positive() {
        // Should be true since there is a consecutive sequence of points
        // that visit the following quadrants in this order:
        //  ... quadrant 1, quadrant 4, quadrant 2, quadrant 3 ...
        double[] xCoords = new double[]{0,   0,  1, -1,  0, -1.0};
        double[] yCoords = new double[]{0.1, 0, -1,  0, -1, -0.5};
        int qPts = 5;
        int quads = 3;
        int numPoints = xCoords.length;
        boolean result = LIC.condition4(xCoords, yCoords, qPts, quads, numPoints);

        assertTrue(result);
    }

    @Test
    public void  testLIC4_Negative() {
        // Should be false since all points lie in the same quadrant
        // and we request it should be > 1

        double[] xCoords = new double[]{1, 0, 1, 1, 1, 0, 0, 1, 0, 0};
        double[] yCoords = new double[]{1, 0, 1, 1, 1, 0, 1, 0, 0, 0};
        int qPts = 10;
        int quads = 1;
        int numPoints = xCoords.length;

        boolean result = LIC.condition4(xCoords, yCoords, qPts, quads, numPoints);
        assertFalse(result);

        // Should be false since qPts is less than quad+1
        // (we can never visit quad+1 distinct quadrants consecutively using only qPts points then)
        xCoords = new double[]{0,   0,  1, -1,  0, -1.0};
        yCoords = new double[]{0.1, 0, -1,  0, -1, -0.5};
        qPts = 3;
        quads = 3;
        numPoints = xCoords.length;
        result = LIC.condition4(xCoords, yCoords, qPts, quads, numPoints);

        assertFalse(result);
    }

    @Test
    public void testLIC4_Invalid() {
        // Invalid since qPts=1 is less than 2
        assertThrows(
                IllegalArgumentException.class,
                () -> LIC.condition4(null, null, 1, 3, 10)
        );

        // Invalid since qPts=11 is more than numPoints=10
        // This could be implemented to return false instead I guess
        assertThrows(
                IllegalArgumentException.class,
                () -> LIC.condition4(null, null, 11, 3, 10)
        );

        // Invalid since quads=0 is less than 1
        assertThrows(
                IllegalArgumentException.class,
                () -> LIC.condition4(null, null, 5, 0, 10)
        );

        // Invalid since quads=4 is larger than 3
        assertThrows(
                IllegalArgumentException.class,
                () -> LIC.condition4(null, null, 5, 4, 10)
        );
    }

}
