
import org.junit.jupiter.api.DisplayName;
import org.labs.lab1.*;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;


import static org.junit.jupiter.api.Assertions.*;

public class LICTest {

    @Test
    @DisplayName("Condition 0")
    void condition0(){
        double [] x = {1, 2, 3};
        double [] y = {1, 2, 1};

        assertEquals(true, LIC.condition0(x, y, 1));

        //expected false: distance of 2 is not greater than lenght1 = 2
        assertEquals(false, LIC.condition0(x, y, 2));

        x = new double[]{-1, 3};
        y = new double[]{-1, -1};

        assertEquals(true, LIC.condition0(x, y, 3));
        assertEquals(true, LIC.condition0(x, y, 0));

        //expected false: distance of 4 is not greater than lenght1 = 4
        assertEquals(false, LIC.condition0(x, y, 4));

        //expected false: there is no distance between two consecutive data points to be greater than lenght1
        assertEquals(false, LIC.condition0(new double[]{}, new double[]{}, 0));

        //expected false: there is no distance between two consecutive data points to be greater than lenght1
        assertEquals(false, LIC.condition0(new double[]{2}, new double[]{-3}, 0));
    }

    @Test
    @DisplayName("Condition 1")
    void condition1(){
        //Should give a radius of 0.7071
        double [] x = {0, 0, 1};
        double [] y = {0, 1, 0};

        assertEquals(true, LIC.condition1(x, y, 0.5));

        // expected false: There is three consecutive data points
        // that can all be contained within or on a circle of radius of RADIUS1
        assertEquals(false, LIC.condition1(x, y, 3));

        //Should give a radius of 5
        double [] x2 = {-6, -3, 0};
        double [] y2 = {3, 2, 3};
        assertEquals(true, LIC.condition1(x2, y2, 3));

        // expected false: There is three consecutive data points
        // that can all be contained within or on a circle of radius of RADIUS1
        assertEquals(false, LIC.condition1(x2, y2, 6));

        // all radius are: 1.58, 5 and 1.58
        double [] x3 = {-3, -6, -3, 0, -3};
        double [] y3 = {3, 3, 2, 3, 3};

        // one set of three consecutive data points that cannot all be contained within
        // or on a circle of radius RADIUS1 exists because of (-6,3), (-3,2) and (0,3)
        assertEquals(true, LIC.condition1(x3, y3, 0));
        assertEquals(true, LIC.condition1(x3, y3, 1));
        assertEquals(true, LIC.condition1(x3, y3, 3));
        assertEquals(true, LIC.condition1(x3, y3, 4.99));
        assertEquals(true, LIC.condition1(x3, y3, 4.99999));

        // expected false: There is three consecutive data points
        // that can all be contained within or on a circle of radius of RADIUS1
        assertEquals(false, LIC.condition1(x3, y3, 5));
        assertEquals(false, LIC.condition1(x3, y3, 5000000));

        double [] x4 = {-6, -3};
        double [] y4 = {3, 2};
        // expected false: There is no three consecutive data points
        assertEquals(false, LIC.condition1(x4, y4, 10));
        assertEquals(false, LIC.condition1(x4, y4, 1));
        assertEquals(false, LIC.condition1(new double[]{-2}, new double[]{3}, 10));
        assertEquals(false, LIC.condition1(new double[]{}, new double[]{}, 1));
        assertEquals(false, LIC.condition1(new double[]{-2,-2,-2}, new double[]{3,3,3}, 0));
        assertEquals(false, LIC.condition1(new double[]{-2,-2,-2}, new double[]{3,3,3}, 1));
        assertEquals(false, LIC.condition1(new double[]{-8,-7,-6}, new double[]{3,3,3}, 2));

        assertEquals(true, LIC.condition1(new double[]{-8,-7,-6}, new double[]{3,3,3}, 0.5));
    }

    @Test
    @DisplayName("Condition 2")
    void condition2(){
        // 90 degrees angle
        double [] x1 = {0, 0, 3};
        double [] y1 = {9, 0, 0};

        assertEquals(true, LIC.condition2(x1,y1,(2/3)*Math.PI));

        // expected false: 90 degrees is not less than 90 degrees or greater than 270 degrees
        assertEquals(false, LIC.condition2(x1,y1,Math.PI/2));

        // 180 degrees angle
        double [] x2 = {-10, 0, 80};
        double [] y2 = {0, 0, 0};

        // expected false: 180 degrees is not less than or greater than 180 degrees
        assertEquals(false, LIC.condition2(x2, y2,0));
        // expected false: 180 degrees is not less than 150 degrees or greater than 210 degrees
        assertEquals(false, LIC.condition2(x2, y2,Math.PI/6));

        double [] x3 = {-1, 0, -1};
        double [] y3 = { 0, -4, 0};
        assertEquals(true, LIC.condition2(x3, y3,(2/3)*Math.PI));

        // expected false: if either the first point or the last point (or both) coincides with the vertex,
        // the angle is undefined and the LIC is not satisfied by those three points.
        double [] x4 = {0, 0, -1};
        double [] y4 = {-4, -4, 0};
        assertEquals(false, LIC.condition2(x4, y4,Math.PI/3));

        double [] x5 = {6, 0, 0};
        double [] y5 = {4, -4, -4};
        assertEquals(false, LIC.condition2(x5, y5,(2/3)*Math.PI));

        double [] x6 = {0, 0, 0};
        double [] y6 = {4, 4, 4};
        assertEquals(false, LIC.condition2(x6, y6,Math.PI/3));
    }

    /**
     * Test for invalid data of AREA1 being less than 0
     */
    @Test
    @DisplayName("Condition 3 invalid data")
    void condition3_invalid_data(){

        double [] x = {-2, 0, 2};
        double [] y = {4, 8, 4};

        Throwable t = assertThrows( IllegalArgumentException.class, ()-> LIC.contidion3(x, y, -3) );
        assertEquals("area1 has to be equal to or greater than 0", t.getMessage());
    }

    /**
     * Test for condition 3 with an isosceles triangle where the area is 8
     * and AREA1 being 7.99, which should give a positive result
     */
    @Test
    @DisplayName("Condition 3 positive isosceles triangle")
    void condition3_positive_isosceles_triangle(){
        // triangle with area being 8
        double [] x = {-2, 0, 2};
        double [] y = {4, 8, 4};

        assertEquals(true, LIC.contidion3(x, y, 7.99));
    }
     /**
      * Test for condition 3 with an isosceles triangle where the area is 8
      * and AREA1 being 8, which should give a negative result
     */
    @Test
    @DisplayName("Condition 3 negative isosceles triangle")
    void condition3_negative_isosceles_triangle(){
        // triangle with area being 8
        double [] x = {-2, 0, 2};
        double [] y = {4, 8, 4};

        assertEquals(false, LIC.contidion3(x, y, 8));
    }

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

    @DisplayName("LIC 7: Test positive cases (returns true/false correctly)")
    void testLIC7_Positive() {
        // Edge case with empty data: no coordinates, all other variables are 0. Should
        // return false
        InputData inputData = new InputData();
        assertFalse(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1,
                inputData.numPoints));

        // Scenario where two sets of coordinates have dist greater than 4.2: condition
        // met, return true
        inputData.numPoints = 5;
        inputData.kPts = 2;
        inputData.xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        inputData.yCoordinates = new double[] { 0, 1, 2, 3, 4 };
        inputData.length1 = 4.2;
        assertTrue(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1,
                inputData.numPoints));

        // Increase K_PTS by 1: there still exists a set of coordinates which meets
        // condition from above; (0,0) and (4,4)
        inputData.kPts = 3;
        assertTrue(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1,
                inputData.numPoints));

        // Case where no set of coordinates with dist > 5 exists (exists with K_PTS = 3)
        inputData.kPts = 2;
        inputData.length1 = 5;
        assertFalse(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1,
                inputData.numPoints));

        // Not enough points: condition cannot be met since NUMPOINTS < 3
        inputData.numPoints = 2;
        assertFalse(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1,
                inputData.numPoints));

        // K_PTS is too large, does not meet the condition 1 <= K_PTS <= NUMPOINTS-2
        inputData.numPoints = 5;
        inputData.kPts = 4;
        assertFalse(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1,
                inputData.numPoints));
    }

    @Test
    @DisplayName("LIC 7: Test negative cases (check for exceptions)")
    void testLIC7_Negative() {
        InputData inputData = new InputData();

        // NUMPOINTS is greater than the actual number of coordinates: index out of
        // bounds exception
        inputData.numPoints = 10;
        inputData.kPts = 3;
        inputData.xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        inputData.yCoordinates = new double[] { 0, 1, 2, 3, 4 };
        inputData.length1 = 6;
        assertThrows(IndexOutOfBoundsException.class, () -> LIC.condition7(inputData.xCoordinates,
                inputData.yCoordinates, inputData.kPts, inputData.length1, inputData.numPoints));

        // Coordinate arrays have a different number of elements: index out of bounds
        // exception
        inputData.numPoints = 5;
        inputData.yCoordinates = new double[] { 0, 1, 2, 3 };
        assertThrows(IndexOutOfBoundsException.class, () -> LIC.condition7(inputData.xCoordinates,
                inputData.yCoordinates, inputData.kPts, inputData.length1, inputData.numPoints));
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

    @Test
    public void testLIC14_Positive() {
        int ePts = 1;
        int fPts = 1;
        int numPoints = 5;
        double[] xCoordinates = new double[] { 0, 47, 5, 47, 0 };
        double[] yCoordinates = new double[] { 0, 47, 5, 47, 5 };
        // triangle is 5x5, area is 12.5
        double area1 = 12;
        double area2 = 13;

        boolean res = LIC.condition14(xCoordinates, yCoordinates, ePts, fPts, area1, area2, numPoints);
        assertTrue(res);
    }

    @Test
    public void testLIC14_Negative() {
        int ePts = 1;
        int fPts = 1;
        int numPoints = 5;
        double[] xCoordinates = new double[] { 0, 47, 5, 47, 0 };
        double[] yCoordinates = new double[] { 0, 47, 5, 47, 5 };
        // triangle is 5x5, area is 12.5
        double area1 = 13;
        double area2 = 13;
        boolean res = LIC.condition14(xCoordinates, yCoordinates, ePts, fPts, area1, area2, numPoints);
        assertFalse(res);
        area1 = 12;
        area2 = 12;
        res = LIC.condition14(xCoordinates, yCoordinates, ePts, fPts, area1, area2, numPoints);
        assertFalse(res);
    }
    
    @Test
    public void testLIC14_Invalid() {
        // ePts or fPts too small
        assertThrows(Error.class, () -> LIC.condition14(null, null, -1, 1, 0, 0, 0));
        assertThrows(Error.class, () -> LIC.condition14(null, null, 1, -1, 0, 0, 0));
        // areas too small
        assertThrows(Error.class, () -> LIC.condition14(null, null, 1, 1, -1, 0, 0));
        assertThrows(Error.class, () -> LIC.condition14(null, null, 1, 1, 0, -1, 0));
    }

}
