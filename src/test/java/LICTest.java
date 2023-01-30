import org.labs.lab1.*;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

public class LICTest {

    // Proposed naming convention:
    // testLIC0_TypeOfData[Positive/Negative/Invalid]() { ... }

    @Test
    public void testCalculateAngle_Positive() {

        var a = new Point2D.Double(2, 0);
        var b = new Point2D.Double(0, 0);
        var c = new Point2D.Double(0, 2);

        assertEquals(Math.PI / 2, LIC.calculateAngle(a, b, c));

        a = new Point2D.Double(2, 1);
        b = new Point2D.Double(1, 1);
        c = new Point2D.Double(2, 2);

        assertEquals(Math.PI / 4, LIC.calculateAngle(a, b, c));
    }

    @Test
    public void testLIC9_Negative() {
        // if less than five points, condition should be false
        int numPoints = 4;
        int dPts = 1;
        int cPts = 1;

        var res = LIC.condition9(null, null, cPts, dPts, 0, numPoints);
        assertFalse(res);

        // if no valid angles, condition should be false
        numPoints = 9;
        cPts = 1;
        dPts = 1;
        double[] xCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        double[] yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 };

        res = LIC.condition9(xCoordinates, yCoordinates, cPts, dPts, 0, 9);
        assertFalse(res);

        // test with valid angles
        numPoints = 5;
        // basic, 90 deg angle
        xCoordinates = new double[] { 1, 47, 0, 47, 0 };
        yCoordinates = new double[] { 0, 47, 0, 47, 1 };

        // if epsilon is PI, PI + ep = 2PI, PI - ep = 0, both tests should fail
        double epsilon = Math.PI;
        res = LIC.condition9(xCoordinates, yCoordinates, cPts, dPts, epsilon, numPoints);
        assertFalse(res);
    }

    @Test
    public void testLIC9_Positive() {
        // test with valid angles
        int numPoints = 5;
        int cPts = 1;
        int dPts = 1;

        // basic triangle, angle is PI/2
        double[] xCoordinates = new double[] { 1, 47, 0, 47, 0 };
        double[] yCoordinates = new double[] { 0, 47, 0, 47, 1 };

        // angle is allowed to be below PI - epsilon
        double epsilon = Math.PI * 0.25; // epsilon is 3PI/4
        boolean res = LIC.condition9(xCoordinates, yCoordinates, cPts, dPts, epsilon, numPoints);
        assertTrue(res);

        // angle is allowed to be above PI + epsilon
        epsilon = Math.PI * 0.75 * (-1); // epsilon is -3PI/4
        res = LIC.condition9(xCoordinates, yCoordinates, cPts, dPts, epsilon, numPoints);
        assertTrue(res);
    }

    @Test
    public void testLIC9_Invalid() {
        // cPts and dPts too small
        assertThrows(Error.class, () -> LIC.condition9(null, null, -1, 1, 0, 0));
        assertThrows(Error.class, () -> LIC.condition9(null, null, 1, -1, 0, 0));
    }
}
