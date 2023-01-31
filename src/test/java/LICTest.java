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

    // LIC5 has no invalid input to test for.
    @Test
    public void testLIC5_Positive() {

        // Should return true since 1 - 5 < 0
        double[] xCoords = new double[] {1, 1, 5, 1};
        double[] yCoords = new double[] {0, 1, 1, 0};

        boolean result = LIC.condition5(xCoords, yCoords);
        assertTrue(result);
    }

    @Test
    public void testLIC5_Negative(){

        // Should return false since no consec. points such that
        // X[j] - X[i] < 0 (j = i-1)
        double[] xCoords = new double[] {1, 1, 1, 5};
        double[] yCoords = new double[] {0, 1, 1, 0};

        boolean result = LIC.condition5(xCoords, yCoords);
        assertFalse(result);

        // Should return false since there are less than 2 points
        xCoords = new double[] {0};
        yCoords = new double[] {0};

        result = LIC.condition5(xCoords, yCoords);
        assertFalse(result);
    }

    @Test
    public void testLIC6_Positive() {

        // Should return true since one of the points are far away from the
        // line between (0, 1) and (0, 0)
        double[] xCoords = new double[] {1, 10, 1, 0, 1};
        double[] yCoords = new double[] {0, 10, 1, 0, 1};

        int nPts = 4;
        int dist = 1;
        int numPoints = 5;

        boolean result = LIC.condition6(xCoords, yCoords, nPts, dist, numPoints);
        assertTrue(result);

        // Should return true since first and last coincides and one point is further
        // away than dist from that coinciding point
        xCoords = new double[] {1, 10, 0, 1, 1};
        yCoords = new double[] {1, 10, 0, 1, 1};
        nPts = 4;
        dist = 1;
        numPoints = 5;

        result = LIC.condition6(xCoords, yCoords, nPts, dist, numPoints);
        assertTrue(result);
    }

    @Test
    public void testLIC6_Negative() {
        // Should return false since all points lie on a line
        double[] xCoords = new double[] {1, 2, 3, 4, 5};
        double[] yCoords = new double[] {1, 2, 3, 4, 5};

        int nPts = 4;
        int dist = 1;
        int numPoints = 5;

        boolean result = LIC.condition6(xCoords, yCoords, nPts, dist, numPoints);
        assertFalse(result);

        // Should return false since numPoints < 3
        numPoints = 2;
        result = LIC.condition6(xCoords, yCoords, nPts, dist, numPoints);
        assertFalse(result);
    }

    @Test
    public void testLIC6_Invalid() {
        // Should throw since nPts < 3
        assertThrows(IllegalArgumentException.class,
                () -> LIC.condition6(null, null, 2, 1, 5));

        // Should throw since nPts > numPoints
        assertThrows(IllegalArgumentException.class,
                () -> LIC.condition6(null, null, 6, 1, 5));

        // Should throw since dist < 0
        assertThrows(IllegalArgumentException.class,
                () -> LIC.condition6(null, null, 4, -1, 5));
    }


}
