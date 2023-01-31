import org.junit.jupiter.api.DisplayName;
import org.labs.lab1.*;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

public class LICTest {

    // Proposed naming convention:
    // testLIC0_TypeOfData[Positive/Negative/Invalid]() { ... }

    @Test
    @DisplayName("LIC 7: Test positive cases (returns true/false correctly)")
    void testLIC7_Positive() {

        // Scenario where two sets of coordinates have dist greater than 4.2: condition
        // met, return true
        int numPoints = 5;
        int kPts = 2;
        double[] xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double [] yCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double length1 = 4.2;
        assertTrue(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1,
                inputData.numPoints));

        // Increase K_PTS by 1: there still exists a set of coordinates which meets
        // condition from above; (0,0) and (4,4)
        inputData.kPts = 3;
        assertTrue(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1,
                inputData.numPoints));
    }

    /**
     * Test case for LIC 7 whic returns false since input data is null
     */
    @Test
    @DisplayName("LIC 7 Negative: Edge case with null input")
    void testLIC7_Negative_1() {
        // Edge case with empty data: no coordinates, all other variables are 0.
        // Should return false since no coordinates are checked (the arrays are null)
        InputData inputData = new InputData();
        assertFalse(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1,
                inputData.numPoints));
    }

    /**
     * Test case for LIC 7 which returns false due to there being no set of
     * coordinates which meet the condition
     */
    @Test
    @DisplayName("LIC 7 Negative: No coordinate set meeting the condition exists")
    void testLIC7_Negative_2() {
        int numPoints = 5;
        int kPts = 2;
        double[] xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double [] yCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double length1 = 5;
        // Case where no set of coordinates with dist > 5 exists (exists with K_PTS = 3)
        assertFalse(LIC.condition7(xCoordinates, yCoordinates, kPts, length1, numPoints));
    }

    /**
     * Test case for LIC 7 which returns false due to NUMPOINTS being too small
     */
    @Test
    @DisplayName("LIC 7 Negative: NUMPOINTS too small to meet condition")
    void testLIC7_Negative_3() {
        int numPoints = 2;
        int kPts = 2;
        double[] xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double [] yCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double length1 = 4.2;
        // Not enough points: condition cannot be met since NUMPOINTS < 3
        assertFalse(LIC.condition7(xCoordinates, yCoordinates, kPts, length1, numPoints));
    }

    /**
     * Test case for LIC 7 which returns false due to K_PTS being too large
     */
    @Test
    @DisplayName("LIC 7 Negative: K_PTS too large to meet condition")
    void testLIC7_Negative_4() {
        int numPoints = 5;
        int kPts = 4;
        double[] xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double [] yCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double length1 = 4.2;
        // K_PTS is too large, does not meet the condition 1 <= K_PTS <= NUMPOINTS-2
        assertFalse(LIC.condition7(xCoordinates, yCoordinates, kPts, length1, numPoints));
    }

    /**
     * Test case with invalid parameters for LIC 7 where NUMPOINTS is greater
     * than the number of coordinates
     */
    @Test
    @DisplayName("LIC 7 Invalid: NUMPOINTS greater than number of coordinates")
    void testLIC7_Invalid_1() {
        int numPoints = 10;
        int kPts = 3;
        double[] xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double[] yCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double length1 = 6;
        // NUMPOINTS is greater than the actual number of coordinates
        // we expect the condition to throw an index out of bounds error
        assertThrows(IndexOutOfBoundsException.class, () -> LIC.condition7(xCoordinates,
                yCoordinates, kPts, length1, numPoints));
    }

    /**
     * Test case with invalid parameters for LIC 7 where coordinate arrays
     * have differing amount of elements
     */
    @Test
    @DisplayName("LIC 7 Invalid: Coordinate arrays have differing amount of elements")
    void testLIC7_Invalid_2() {
        int kPts = 3;
        double[] xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double[] yCoordinates = new double[] { 0, 1, 2, 3 };
        double length1 = 6;
        int numPoints = 5;
        // Coordinate arrays have a different number of elements: index out of bounds exception
        assertThrows(IndexOutOfBoundsException.class, () -> LIC.condition7(xCoordinates,
                yCoordinates, kPts, length1, numPoints));
    }

    @Test
    @DisplayName("LIC 8: Test positive cases (returns true/false correctly)")
    void testLIC8_Positive() {
        // Edge case with empty data: no coordinates, all other variables are 0. Should
        // return false
        InputData inputData = new InputData();
        assertFalse(LIC.condition8(inputData.xCoordinates, inputData.yCoordinates, inputData.aPts, inputData.bPts,
                inputData.radius1, inputData.numPoints));

        // Case where there exists 2 sets of coords that cannot be contained in a circle
        // with radius 1.5 (should return true)
        inputData.numPoints = 6;
        inputData.aPts = 1;
        inputData.bPts = 1;
        inputData.xCoordinates = new double[] { 0, 1, 2, 3, 4, 5 };
        inputData.yCoordinates = new double[] { 0, 0, 0, 0, 0, 0 };
        inputData.radius1 = 1.5;
        // assertTrue(LIC.condition8(inputData.xCoordinates, inputData.yCoordinates,
        // inputData.aPts, inputData.bPts, inputData.radius1, inputData.numPoints));

        // Same as above, but with radius 2 (now there are no coord sets that can be
        // contained in such a circle)
        inputData.radius1 = 2;
        assertFalse(LIC.condition8(inputData.xCoordinates, inputData.yCoordinates, inputData.aPts, inputData.bPts,
                inputData.radius1, inputData.numPoints));

        // Non-colinear points where radius is too small in both cases: returns true
        inputData.xCoordinates = new double[] { 0, 1, 1, 3, 2, 5 };
        inputData.yCoordinates = new double[] { 0, 0, 2, 0, 0, 3 };
        inputData.radius1 = 1;
        assertTrue(LIC.condition8(inputData.xCoordinates, inputData.yCoordinates, inputData.aPts, inputData.bPts,
                inputData.radius1, inputData.numPoints));
    }

    @Test
    @DisplayName("LIC 8: Test negative cases (check for exceptions)")
    void testLIC8_Negative() {
        InputData inputData = new InputData();

        // Coordinate arrays have a different number of elements: index out of bounds
        // exception
        inputData.numPoints = 6;
        inputData.aPts = 1;
        inputData.bPts = 1;
        inputData.xCoordinates = new double[] { 0, 1, 2, 3 };
        inputData.yCoordinates = new double[] { 0, 0, 0, 0, 0, 0 };
        inputData.radius1 = 1.5;
        assertThrows(IndexOutOfBoundsException.class, () -> LIC.condition8(inputData.xCoordinates,
                inputData.yCoordinates, inputData.aPts, inputData.bPts, inputData.radius1, inputData.numPoints));
    }

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

    @Test
    public void testCalculateTriangleArea() {
        // basic triangle
        var a = new Point2D.Double(0, 0);
        var b = new Point2D.Double(1, 0);
        var c = new Point2D.Double(0, 1);

        assertEquals(0.5, LIC.calculateTriangleArea(a, b, c));

        // triangle with negative coordinates
        a = new Point2D.Double(-1, -1);
        b = new Point2D.Double(1, -1);
        c = new Point2D.Double(-1, 1);

        assertEquals(2, LIC.calculateTriangleArea(a, b, c));
    }

    @Test
    public void testLIC10_Positive() {
        int numPoints = 5;
        int ePts = 1;
        int fPts = 1;
        double[] xCoordinates = new double[] { 0, 47, 5, 47, 0 };
        double[] yCoordinates = new double[] { 0, 47, 5, 47, 5 };
        // triangle is 5x5, area is 12.5
        double area1 = 12;
        // area1 is less than triangle area, test should pass
        boolean res = LIC.condition10(xCoordinates, yCoordinates, ePts, fPts, area1, numPoints);
        assertTrue(res);

        numPoints = 7;
        xCoordinates = new double[] { 1, 47, 1, 47, 2, 47, 2 };
        yCoordinates = new double[] { 0, 47, 1, 47, 1, 47, 4 };

        // first triplet has area 0.5
        // second triplet has area 1.5
        area1 = 1.4;
        // area1 is less than triangle area, test should pass
        res = LIC.condition10(xCoordinates, yCoordinates, ePts, fPts, area1, numPoints);
        assertTrue(res);
    }

    @Test
    public void testLIC10_Negative() {
        int numPoints = 5;
        int ePts = 1;
        int fPts = 1;
        double[] xCoordinates = new double[] { 0, 47, 5, 47, 0 };
        double[] yCoordinates = new double[] { 0, 47, 5, 47, 5 };
        // triangle is 5x5, area is 12.5
        double area1 = 13;
        // area1 is greater than triangle area, test should fail
        boolean res = LIC.condition10(xCoordinates, yCoordinates, ePts, fPts, area1, numPoints);
        assertFalse(res);

        numPoints = 7;
        xCoordinates = new double[] { 0, 47, 1, 47, 1, 47, 1 };
        yCoordinates = new double[] { 0, 47, 1, 47, 0, 47, 4 };

        // first triplet is 1x1, area is 0.5
        // second triplet is 1x1, area is 1.5
        area1 = 1.6;
        // area1 is greater than triangle area, test should fail
        res = LIC.condition10(xCoordinates, yCoordinates, ePts, fPts, area1, numPoints);
        assertFalse(res);
    }

    @Test
    public void testLIC10_Invalid() {
        // ePts and fPts too small
        assertThrows(Error.class, () -> LIC.condition10(null, null, -1, 1, 0, 0));
        assertThrows(Error.class, () -> LIC.condition10(null, null, 1, -1, 0, 0));
    }

    @Test
    public void testLIC11_Positive() {
        int numPoints = 10;
        int gPts = 1;
        // on index i = 5 and j = 7 x_j - x_i = 5 - 6 = -1 <= 0
        var xCoordinates = new double[] { 0, 1, 2, 3, 4, 6, 6, 5, 8, 9 };
        // y coordinates does not matter
        var yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        boolean res = LIC.condition11(xCoordinates, yCoordinates, gPts, numPoints);

        assertTrue(res);

        // test with bigger gPts
        gPts = 8;
        xCoordinates = new double[] { 9, 1, 2, 3, 4, 6, 6, 5, 8, 0 };
        res = LIC.condition11(xCoordinates, yCoordinates, gPts, numPoints);
        assertTrue(res);

    }

    @Test
    public void testLIC11_Negative() {
        int numPoints = 10;
        int gPts = 1;
        // on index i = 5 and j = 7 x_j - x_i = 7 - 5 = 2 > 0
        var xCoordinates = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // y coordinates does not matter
        var yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        boolean res = LIC.condition11(xCoordinates, yCoordinates, gPts, numPoints);

        assertFalse(res);

        // test with bigger gPts
        gPts = 8;
        xCoordinates = new double[] { 0, 1, 2, 3, 4, 6, 6, 7, 8, 9 };
        res = LIC.condition11(xCoordinates, yCoordinates, gPts, numPoints);
        assertFalse(res);

        // test with equal x-coordinates
        xCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        res = LIC.condition11(xCoordinates, yCoordinates, gPts, numPoints);
        assertFalse(res);

        // test that pairs where j >= i does not count, i.e. that order matters
        xCoordinates = new double[] { 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6 };
        res = LIC.condition11(xCoordinates, yCoordinates, gPts, numPoints);
        assertFalse(res);

    }

    @Test
    public void testLIC11_Invalid() {
        // gPts too small
        assertThrows(Error.class, () -> LIC.condition11(null, null, -1, 0));
    }

    @Test
    public void testLIC12_Positive() {
        int kPts = 1;
        double length1 = 0.9;
        double length2 = 1;
        int numPoints = 10;

        double[] xCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        double[] yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 };

        boolean res = LIC.condition12(xCoordinates, yCoordinates, kPts, length1, length2, numPoints);
        assertTrue(res);

        // test with bigger kPts
        kPts = 7;
        length1 = 5;
        xCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 };
        yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 };
        res = LIC.condition12(xCoordinates, yCoordinates, kPts, length1, length2, numPoints);
        assertTrue(res);

        // only one pair (each) that satisfies the conditions
        kPts = 3;
        length1 = 100;
        length2 = 1.1;
        xCoordinates = new double[] { 2, 4, 6, 8, 10, 9, 14, 16, 18, 120 };
        yCoordinates = new double[] { 2, 4, 6, 8, 10, 8, 14, 16, 18, 120 };

    }

    @Test
    public void testLIC12_Negative() {
        int kPts = 1;
        double length1 = 1;
        double length2 = 1;
        int numPoints = 10;

        // all distances 0
        double[] xCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        double[] yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

        boolean res = LIC.condition12(xCoordinates, yCoordinates, kPts, length1, length2, numPoints);
        assertFalse(res);

        // test with bigger kPts
        kPts = 7;
        length1 = 100;
        xCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 };
        yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 };
        res = LIC.condition12(xCoordinates, yCoordinates, kPts, length1, length2, numPoints);
        assertFalse(res);
    }

    @Test
    public void testLIC12_Invalid() {
        // kPts too small
        assertThrows(Error.class, () -> LIC.condition12(null, null, -1, 1, 1, 0));
        // length1 too small
        assertThrows(Error.class, () -> LIC.condition12(null, null, 1, -1, 1, 0));
        // length2 too small
        assertThrows(Error.class, () -> LIC.condition12(null, null, 1, 1, -1, 0));
    }

}
