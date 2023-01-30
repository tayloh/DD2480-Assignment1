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
        InputData data = new InputData();
        // if less than five points, condition should be false
        data.numPoints = 4;
        data.dPts = 1;
        data.cPts = 1;

        var cmv = new CMV(data);
        assertFalse(cmv.get(9));

        // if no valid angles, condition should be false
        data.numPoints = 9;
        data.cPts = 1;
        data.dPts = 1;
        data.xCoordinates = new double[]{1, 1, 1, 1, 1, 1, 1, 1, 1};
        data.yCoordinates = new double[]{1, 1, 1, 1, 1, 1, 1, 1, 1};

        cmv = new CMV(data);
        assertFalse(cmv.get(9));

        // test with valid angles
        data.numPoints = 5;
        // basic, 90 deg angle
        data.xCoordinates = new double[]{1, 47, 0, 47, 0};
        data.yCoordinates = new double[]{0, 47, 0, 47, 1};

        // if epsilon is PI, PI + ep = 2PI, PI - ep = 0, both tests should fail
        data.epsilon = Math.PI;
        cmv = new CMV(data);
        assertFalse(cmv.get(9));
    }

    @Test
    public void testLIC9_Positive() {

        InputData data = new InputData();
        // test with valid angles
        data.numPoints = 5;
        data.cPts = 1;
        data.dPts = 1;

        // basic triangle, angle is PI/2
        data.xCoordinates = new double[]{1, 47, 0, 47, 0};
        data.yCoordinates = new double[]{0, 47, 0, 47, 1};

        // angle is allowed to be below PI - epsilon
        data.epsilon = Math.PI * 0.25; // epsilon is 3PI/4
        var cmv = new CMV(data);
        assertTrue(cmv.get(9));

        // angle is allowed to be above PI + epsilon
        data.epsilon = Math.PI * 0.75 * (-1); // epsilon is -3PI/4
        cmv = new CMV(data);
        assertTrue(cmv.get(9));
    }

    @Test
    public void testLIC9_Invalid() {
        InputData data = new InputData();

        // cPts and dPts too small
        data.cPts = -1;
        assertThrows(Error.class, () -> new CMV(data));
        data.cPts = 1;
        data.dPts = -1;
        assertThrows(Error.class, () -> new CMV(data));
    }
}
