
import org.junit.jupiter.api.DisplayName;
import org.labs.lab1.*;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;


import static org.junit.jupiter.api.Assertions.*;

public class LICTest {

    /**
     * Asserts true
     * Should return true since there is a set of two consecutive data points
     * which has a distance greater than length1
     */
    @Test
    @DisplayName("LIC 0 Positive 1: one set meeting the criteria")
    void testLIC0_Positive_1(){
        double [] x = {-1, 3};
        double [] y = {-1, -1};

        assertTrue(LIC.condition0(x, y, 3));
    }

    /**
     * Asserts true
     * Should return true since there is a set of two consecutive data points
     * which has a distance greater than length1
     */
    @Test
    @DisplayName("LIC 0 Positive 2: one set meeting the criteria, one set that does not")
    void testLIC0_Positive_2(){
        double [] x = {1, 2, 3};
        double [] y = {1, 2, 1};

        assertTrue(LIC.condition0(x, y, 1));
    }

    /**
     * Asserts false
     * Should return false since there is not a set of two consecutive data points
     * that has a distance greater than length1
     */
    @Test
    @DisplayName("LIC 0 Negative 1: no set meeting the criteria")
    void testLIC0_Negative_1(){
        double [] x = {1, 2, 2};
        double [] y = {1, 2, 1};

        assertFalse(LIC.condition0(x, y, 2));
    }

    /**
     * Asserts false
     * Should return false since the distance of the two data points is equal to
     * (and not greater) than length1
     */
    @Test
    @DisplayName("LIC 0 Negative 2: distance and length1 being equal ")
    void testLIC0_Negative_2(){
        double [] x = {-5, -1};
        double [] y = {-1, -1};

        assertEquals(false, LIC.condition0(x, y, 4));
    }

    /**
     * Asserts false
     * Should return false since there is no distance between two consecutive data points
     * to be greater than length1
     */
    @Test
    @DisplayName("LIC 0 Negative 3: test with only one data point")
    void testLIC0_Negative_3(){
        assertFalse(LIC.condition0(new double[]{2}, new double[]{-3}, 0));
    }

    /**
     * Asserts false
     * Should return false since there is no distance between two consecutive data points
     * to be greater than length1
     */
    @Test
    @DisplayName("LIC 0 Negative 4: test with only one data points")
    void testLIC0_Negative_4(){
        assertFalse(LIC.condition0(new double[]{}, new double[]{}, 0));
    }

    /**
     * Asserts throws
     * Should throw error since length1 is invalid
     */
    @Test
    @DisplayName("LIC 0 invalid: test with invalid length")
    void testLIC0_Invalid(){
        Throwable t = assertThrows(Error.class, () -> LIC.condition0(new double[]{}, new double[]{}, -1));
        assertEquals("Invalid input provided, length1 must be equal to or greater than 0", t.getMessage());
    }

    /**
     * Asserts true
     * Should return true since there exists at least one set data points does not fit in the circle with radius
     */
    @Test
    @DisplayName("LIC 1 Positive 1: the set of data points does not fit in the circle")
    void testLIC1_Positive_1(){
        double [] x = {0, 0, 1};
        double [] y = {0, 1, 0};

        assertTrue(LIC.condition1(x, y, 0.5));
    }

    /**
     * Asserts true
     * Should return true since there exists at least one set data points does not fit in the circle with radius
     */
    @Test
    @DisplayName("LIC 1 Positive 2: one set (out of three) does not fit in the circle")
    void testLIC1_Positive_2(){
        // all radius are: 1.58, 5 and 1.58
        double [] x = {-3, -6, -3, 0, -3};
        double [] y = {3, 3, 2, 3, 3};

        // or on a circle of radius RADIUS1 exists because of (-6,3), (-3,2) and (0,3)
        assertEquals(true, LIC.condition1(x, y, 4.99999));
    }
    /**
     * Asserts true
     * Should return true since the only existing set which are collinear does not fit
     * in the circle of radius RADIUS1
     */
    @Test
    @DisplayName("LIC 1 Positive 3: one collinear set")
    void testLIC1_Positive_3(){
        assertTrue(LIC.condition1(new double[]{-8, -7, -6}, new double[]{3, 3, 3}, 0.5));
    }

    /**
     * Asserts false
     * Should return false since there exists a set of three data points that
     * can all be contained within or on a circle of radius of RADIUS1
     */
    @Test
    @DisplayName("LIC 1 Negative 1: no set of data points that does not fit in the circle")
    void testLIC1_Negative_1(){
        double [] x = {0, 0, 1};
        double [] y = {0, 1, 0};

        assertFalse(LIC.condition1(x, y, 3));
    }
    /**
     * Asserts false
     * Should return false since there exists no set of three data points that
     * can not all be contained within or on a circle of radius of RADIUS1
     */
    @Test
    @DisplayName("LIC 1 Negative 2: no set of data points")
    void testLIC1_Negative_2(){
        assertFalse(LIC.condition1(new double[]{}, new double[]{}, 1));
    }
    /**
     * Asserts false
     * Should return false since the set which is a point fits in the circle
     * of radius RADIUS1
     */
    @Test
    @DisplayName("LIC 1 Negative 3: one set with same position")
    void testLIC1_Negative_3(){
        assertFalse(LIC.condition1(new double[]{-2,-2,-2}, new double[]{3,3,3}, 1));
    }

    /**
     * Asserts throw
     * Should throw error because of invalid RADIUS1 (less than 0)
     */
    @Test
    @DisplayName("LIC 1 Invalid 1: test with  invalid radius1")
    void testLIC1_Invalid(){
        Throwable t = assertThrows(Error.class, () -> LIC.condition1(new double[]{}, new double[]{}, -1));
        assertEquals("Invalid input provided, radius1 must be equal to or greater than 0", t.getMessage());

    }

    /**
     * Asserts throw
     * Should throw error because of invalid epsilon value
     */
    @Test
    @DisplayName("LIC 2 Invalid: test with  invalid radius1")
    void testLIC2_Invalid(){
        Throwable t = assertThrows(Error.class, () -> LIC.condition2(new double[]{}, new double[]{}, -1));
        assertEquals("Invalid input provided, epsilon must be equal to or greater than 0, but less than Pi", t.getMessage());

    }
    /**
     * Asserts true
     * Should return true since 90 < 180 - 60 (angle < Math.PI - epsilon) is true
     */
    @Test
    @DisplayName("LIC 2 Positive 1: meets condition")
    void testLIC2_Positive_1(){
        // 90 degrees angle
        double [] x = {0, 0, 3};
        double [] y = {9, 0, 0};

        assertTrue(LIC.condition2(x, y, Math.PI / 3));
    }
    /**
     * Asserts false
     * Should return true since 90 < 90 (angle < Math.PI - epsilon) is false and
     * 90 > 270 (angle > Math.PI + epsilon) is false
     */
    @Test
    @DisplayName("LIC 2 Negative 1: does not meet condition")
    void testLIC2_Negative_1(){
        // 90 degrees angle
        double [] x = {0, 0, 3};
        double [] y = {9, 0, 0};

        assertTrue(LIC.condition2(x, y, Math.PI / 3));
    }
    /**
     * Asserts false
     * Should return true since if either the first point or the last point (or both) coincides with the vertex,
     * the angle is undefined and the LIC is not satisfied by those three points.
     */
    @Test
    @DisplayName("LIC 2 Negative 2: one coincides with the vertex")
    void testLIC2_Negative_2(){
        double [] x4 = {0, 0, -1};
        double [] y4 = {-4, -4, 0};
        assertFalse(LIC.condition2(x4, y4, Math.PI / 3));
    }
    /**
     * Asserts false
     * Should return true since if either the first point or the last point (or both) coincides with the vertex,
     * the angle is undefined and the LIC is not satisfied by those three points.
     */
    @Test
    @DisplayName("LIC 2 Negative 3: both coincides with the vertex")
    void testLIC2_Negative_3(){
        double [] x6 = {0, 0, 0};
        double [] y6 = {4, 4, 4};
        assertFalse(LIC.condition2(x6, y6, Math.PI / 3));
    }

    /**
     * Asserts throw
     * Should throw error because of invalid data of AREA1 being less than 0
     */
    @Test
    @DisplayName("LIC 3 Invalid: invalid area1 value")
    void testLIC3_Invalid(){

        double [] x = {-2, 0, 2};
        double [] y = {4, 8, 4};

        Throwable t = assertThrows( IllegalArgumentException.class, ()-> LIC.condition3(x, y, -3) );
        assertEquals("area1 has to be equal to or greater than 0", t.getMessage());
    }

    /**
     * Asserts true
     * Should return true since there exists one set, an isosceles triangle,
     * with an area of 8 that will not fit in a circle of area AREA1 (7.99)
     */
    @Test
    @DisplayName("LIC 3 positive 1: isosceles triangle")
    void testLIC3_Positive_1(){
        // triangle with area being 8
        double [] x = {-2, 0, 2};
        double [] y = {4, 8, 4};

        assertTrue(LIC.condition3(x, y, 7.99));
    }

     /**
      * Asserts false
      * Should return false since there does not exist one set,that will not fit in a circle of area AREA1
      * the isosceles triangle with area 8 fits in a circle area of 8
     */
    @Test
    @DisplayName("LIC 3 positive 1: negative isosceles triangle")
    void testLIC3_Negative_1(){
        // triangle with area being 8
        double [] x = {-2, 0, 2};
        double [] y = {4, 8, 4};

        assertFalse(LIC.condition3(x, y, 8));
    }

    /**
     * Asserts true
     * Should return true since there exists a consecutive sequence of five points
     * that visits all four quadrants
     */
    @Test
    public void testLIC4_Positive_1() {
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

    /**
     * Asserts true
     * Should return true since the points are
     * distributed among three distinct quadrants
     * and we check for > 2.
     *
     * Only detects true if it checks all points
     * (added as part of bugfix; it did not check the last point)
     */
    @Test
    public void testLIC4_Positive_2() {
        // Quadrant nrs: 1, 1, 3, 1, 2
        double[] xCoords = new double[]{0, 0,  0, 1, -1};
        double[] yCoords = new double[]{0, 0, -1, 0,  0};
        int qPts = 5;
        int quads = 2;
        int numPoints = xCoords.length;
        boolean result = LIC.condition4(xCoords, yCoords, qPts, quads, numPoints);

        assertTrue(result);
    }

    /**
     * Asserts false
     * Should return false since all points lite in the same quadrants
     * and this test checks for > 1 quadrants
     */
    @Test
    public void  testLIC4_Negative_1() {
        // Should be false since all points lie in the same quadrant
        // and we request it should be > 1

        double[] xCoords = new double[]{1, 0, 1, 1, 1, 0, 0, 1, 0, 0};
        double[] yCoords = new double[]{1, 0, 1, 1, 1, 0, 1, 0, 0, 0};
        int qPts = 10;
        int quads = 1;
        int numPoints = xCoords.length;

        boolean result = LIC.condition4(xCoords, yCoords, qPts, quads, numPoints);
        assertFalse(result);
    }

    /**
     * Asserts false
     * Should return false since qPts < quad + 1
     * (we can never visit quad + 1 quadrants with
     * using qPts consecutive points)
     */
    @Test
    public void  testLIC4_Negative_2() {
        // Should be false since qPts is less than quad+1
        // (we can never visit quad+1 distinct quadrants consecutively using only qPts points then)
        double[] xCoords = new double[]{0, 0, 1, -1, 0, -1.0};
        double[] yCoords = new double[]{0.1, 0, -1, 0, -1, -0.5};
        int qPts = 3;
        int quads = 3;
        int numPoints = xCoords.length;
        boolean result = LIC.condition4(xCoords, yCoords, qPts, quads, numPoints);

        assertFalse(result);
    }

    /**
     * Asserts throw
     * Should throw since qPts < 2
     */
    @Test
    public void testLIC4_Invalid_1() {
        // Invalid since qPts=1 is less than 2
        assertThrows(
                IllegalArgumentException.class,
                () -> LIC.condition4(null, null, 1, 3, 10)
        );
    }

    /**
     * Asserts throw
     * Should throw since qPts > numPoints
     */
    @Test
    public void testLIC4_Invalid_2() {
        // Invalid since qPts=11 is more than numPoints=10
        // This could be implemented to return false instead I guess
        assertThrows(
                IllegalArgumentException.class,
                () -> LIC.condition4(null, null, 11, 3, 10)
        );
    }

    /**
     * Asserts throw
     * Should throw since quads < 1
     */
    @Test
    public void testLIC4_Invalid_3() {
        // Invalid since quads=0 is less than 1
        assertThrows(
                IllegalArgumentException.class,
                () -> LIC.condition4(null, null, 5, 0, 10)
        );
    }

    /**
     * Asserts throw
     * Should throw since quads > 3
     */
    @Test
    public void testLIC4_Invalid_4() {
        // Invalid since quads=4 is larger than 3
        assertThrows(
                IllegalArgumentException.class,
                () -> LIC.condition4(null, null, 5, 4, 10)
        );
    }


    // OBS: LIC5 has no invalid input to test for.

    /**
     * Asserts true
     * Should return true since there exists consecutive
     * points such that x[i+1] - x[i] < 0
     */
    @Test
    public void testLIC5_Positive_1() {

        // Should return true since 1 - 5 < 0
        double[] xCoords = new double[] {1, 1, 5, 1};
        double[] yCoords = new double[] {0, 1, 1, 0};

        boolean result = LIC.condition5(xCoords, yCoords);
        assertTrue(result);
    }

    /**
     * Asserts false
     * Should return false since there exist no consecutive points
     * such that x[i+1]-x[i] < 0
     */
    @Test
    public void testLIC5_Negative_1(){

        // Should return false since no consec. points such that
        // X[j] - X[i] < 0 (j = i-1)
        double[] xCoords = new double[] {1, 1, 1, 5};
        double[] yCoords = new double[] {0, 1, 1, 0};

        boolean result = LIC.condition5(xCoords, yCoords);
        assertFalse(result);
    }

    /**
     * Asserts false
     * Should return false since there are less than 2 points
     */
    @Test
    public void testLIC5_Negative_2(){
        // Should return false since there are less than 2 points
        double[] xCoords = new double[]{0};
        double[] yCoords = new double[]{0};

        boolean result = LIC.condition5(xCoords, yCoords);
        assertFalse(result);
    }

    /**
     * Asserts true
     * Should return true since of the points are further away than dist from
     * the line between (0, 1) and (0, 0)
     */
    @Test
    public void testLIC6_Positive_1() {

        // Should return true since one of the points are far away from the
        // line between (0, 1) and (0, 0)
        double[] xCoords = new double[] {1, 10, 1, 0, 1};
        double[] yCoords = new double[] {0, 10, 1, 0, 1};

        int nPts = 4;
        int dist = 1;
        int numPoints = 5;

        boolean result = LIC.condition6(xCoords, yCoords, nPts, dist, numPoints);
        assertTrue(result);
    }

    /**
     * Asserts true
     * Should return true since first and last points coincide and one consecutive
     * point in between is further away than dist from that coinciding point
     */
    @Test
    public void testLIC6_Positive_2() {

        // Should return true since first and last coincides and one point is further
        // away than dist from that coinciding point
        double[] xCoords = new double[]{1, 10, 0, 1, 1};
        double[] yCoords = new double[]{1, 10, 0, 1, 1};
        int nPts = 4;
        int dist = 1;
        int numPoints = 5;

        boolean result = LIC.condition6(xCoords, yCoords, nPts, dist, numPoints);
        assertTrue(result);
    }

    /**
     * Asserts false
     * Should return false since all points lie on the same line
     */
    @Test
    public void testLIC6_Negative_1() {
        // Should return false since all points lie on a line
        double[] xCoords = new double[] {1, 2, 3, 4, 5};
        double[] yCoords = new double[] {1, 2, 3, 4, 5};

        int nPts = 4;
        int dist = 1;
        int numPoints = 5;

        boolean result = LIC.condition6(xCoords, yCoords, nPts, dist, numPoints);
        assertFalse(result);
    }

    /**
     * Asserts false
     * Should return false since numPoints < 3
     */
    @Test
    public void testLIC6_Negative_2() {
        double[] xCoords = new double[] {1, 10, 1, 1, 5};
        double[] yCoords = new double[] {1, 10, 1, 1, 5};

        int nPts = 4;
        int dist = 1;

        // Should return false since numPoints < 3
        int numPoints = 2;
        boolean result = LIC.condition6(xCoords, yCoords, nPts, dist, numPoints);
        assertFalse(result);
    }

    /**
     * Asserts throw
     * Should throw since nPts < 3
     */
    @Test
    public void testLIC6_Invalid_1() {
        // Should throw since nPts < 3
        assertThrows(IllegalArgumentException.class,
                () -> LIC.condition6(null, null, 2, 1, 5));
    }

    /**
     * Asserts throw
     * Should throw since nPts > numPoints
     */
    @Test
    public void testLIC6_Invalid_2() {
        // Should throw since nPts > numPoints
        assertThrows(IllegalArgumentException.class,
                () -> LIC.condition6(null, null, 6, 1, 5));
    }

    /**
     * Asserts throw
     * Should throw since dist < 0
     */
    @Test
    public void testLIC6_Invalid_3() {
        // Should throw since dist < 0
        assertThrows(IllegalArgumentException.class,
                () -> LIC.condition6(null, null, 4, -1, 5));
    }

    /**
     * Test case for LIC 7 which returns true since two coordinate sets meet the condition
     */
    @Test
    @DisplayName("LIC 7 Positive: Two coordinate sets meet the condition")
    void testLIC7_Positive_1() {
        // Scenario where two sets of coordinates have dist greater than 4.2: condition
        // met, return true
        int numPoints = 5;
        int kPts = 2;
        double[] xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double [] yCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double length1 = 4.2;
        assertTrue(LIC.condition7(xCoordinates, yCoordinates, kPts, length1, numPoints));
    }

    /**
     * Test case for LIC 7 which returns true since one coordinate set meet the condition
     */
    @Test
    @DisplayName("LIC 7 Positive: One coordinate set meets the condition")
    void testLIC7_Positive_2() {
        // Increase K_PTS by 1 from above test case: there still exists a
        // set of coordinates which meet condition from above; (0,0) and (4,4)
        int numPoints = 5;
        int kPts = 3;
        double[] xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double [] yCoordinates = new double[] { 0, 1, 2, 3, 4 };
        double length1 = 4.2;
        assertTrue(LIC.condition7(xCoordinates, yCoordinates, kPts, length1, numPoints));
    }

    /**
     * Test case for LIC 7 which returns false since input data is null
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

    /**
     * Test for LIC 8 which returns true for a set of colinear points where the radius is too
     * small to contain any of them
     */
    @Test
    @DisplayName("LIC 8 Positive: Colinear points that cannot be contained")
    void testLIC8_Positive_1() {
        // Case where there exists 2 sets of coords that cannot be contained in a circle
        // with radius 1.5 (should return true)
        int numPoints = 6;
        int aPts = 1;
        int bPts = 1;
        double[] xCoordinates = new double[] { 0, 1, 2, 3, 4, 5 };
        double[] yCoordinates = new double[] { 0, 0, 0, 0, 0, 0 };
        double radius1 = 1.5;
        assertTrue(LIC.condition8(xCoordinates, yCoordinates, aPts, bPts, radius1, numPoints));
    }

    /**
     * Test for LIC 8 which returns true for a set of non-colinear points that cannot be contained
     * in any given circle
     */
    @Test
    @DisplayName("LIC 8 Positive: Non-colinear points that cannot be contained")
    void testLIC8_Positive_2() {
        // Non-colinear points where radius is too small in both cases: returns true
        int numPoints = 6;
        int aPts = 1;
        int bPts = 1;
        double[] xCoordinates = new double[] { 0, 1, 1, 3, 2, 5 };
        double[] yCoordinates = new double[] { 0, 0, 2, 0, 0, 3 };
        double radius1 = 1;
        assertTrue(LIC.condition8(xCoordinates, yCoordinates, aPts, bPts, radius1, numPoints));
    }

    /**
     * Test case for LIC 8 which returns false since input is null
     */
    @Test
    @DisplayName("LIC 8 Negative: Edge case with null input")
    void testLIC8_Negative_1() {
        // Edge case with empty data: no coordinates, all other variables are 0.
        // Should return false since no coordinates are checked (the arrays are null)
        InputData inputData = new InputData();
        assertFalse(LIC.condition8(inputData.xCoordinates, inputData.yCoordinates, inputData.aPts, inputData.bPts, inputData.radius1,
                inputData.numPoints));
    }

    /**
     * Test case for LIC 8 which returns false since all coordinate sets can be contained in some circle
     */
    @Test
    @DisplayName("LIC 8 Negative: All set of coordinates can be contained in a circle with given radius")
    void testLIC8_Negative_2() {
        int numPoints = 6;
        int aPts = 1;
        int bPts = 1;
        double[] xCoordinates = new double[] { 0, 1, 2, 3, 4, 5 };
        double[] yCoordinates = new double[] { 0, 0, 0, 0, 0, 0 };
        double radius1 = 2;
        // With radius 2, now there are no coord sets can be contained in such a circle
        assertFalse(LIC.condition8(xCoordinates, yCoordinates, aPts, bPts, radius1, numPoints));
    }

    /**
     * Test case with invalid parameters for LIC 8 where coordinate arrays
     * have differing amount of elements
     */
    @Test
    @DisplayName("LIC 8 Invalid: Coordinate arrays have differing amount of elements")
    void testLIC8_Invalid_1() {
        int numPoints = 6;
        int aPts = 1;
        int bPts = 1;
        double[] xCoordinates = new double[] { 0, 1, 2, 3 };
        double[] yCoordinates = new double[] { 0, 0, 0, 0, 0, 0 };
        double radius1 = 1.5;
        // Coordinate arrays have a different number of elements: index out of bounds exception
        assertThrows(IndexOutOfBoundsException.class, () -> LIC.condition8(xCoordinates,
                yCoordinates, aPts, bPts, radius1, numPoints));
    }

    /**
     * Asserts true
     * Checks that the calculateAngle method returns the correct angle for some
     * sample points. First triangle is a right angle triangle, second triangle is a
     * 45 degree angle triangle
     */
    @Test
    @DisplayName("Calculate angle method returns correct angle")
    public void testCalculateAngle_Positive() {

        var a = new Point2D.Double(2, 0);
        var b = new Point2D.Double(0, 0);
        var c = new Point2D.Double(0, 2);

        var first = LIC.calculateAngle(a, b, c);

        a = new Point2D.Double(2, 1);
        b = new Point2D.Double(1, 1);
        c = new Point2D.Double(2, 2);

        var second = LIC.calculateAngle(a, b, c);

        var expected = new double[] { Math.PI / 2, Math.PI / 4 };
        var actual = new double[] { first, second };

        assertArrayEquals(expected, actual);
    }

    /**
     * Checks that the condition is false when number of points is below 5
     */
    @Test
    @DisplayName("LIC 9 Negative: Less than 5 points")
    public void testLIC9_Negative_1() {
        // if less than five points, condition should be false
        int numPoints = 4;
        int dPts = 1;
        int cPts = 1;

        var res = LIC.condition9(null, null, cPts, dPts, 0, numPoints);
        assertFalse(res);
    }

    /**
     * Checks that the condition is false when there are no valid angles
     */
    @Test
    @DisplayName("LIC 9 Negative: No valid angles")
    public void testLIC9_Negative_2() {
        int cPts = 1;
        int dPts = 1;
        double[] xCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        double[] yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 };

        var res = LIC.condition9(xCoordinates, yCoordinates, cPts, dPts, 0, 9);
        assertFalse(res);
    }

    /**
     * Checks that the condition is false when there are valid angles, but the
     * epsilon is too large
     */
    @Test
    @DisplayName("LIC 9 Negative: Epsilon is too large")
    public void testLIC9_Negative_3() {
        // basic, 90 deg angle
        var xCoordinates = new double[] { 1, 47, 0, 47, 0 };
        var yCoordinates = new double[] { 0, 47, 0, 47, 1 };

        // if epsilon is PI, PI + ep = 2PI, PI - ep = 0, both tests should fail
        double epsilon = Math.PI;
        boolean res = LIC.condition9(xCoordinates, yCoordinates, 1, 1, epsilon, xCoordinates.length);
        assertFalse(res);
    }

    /**
     * Checks that the condition is true when there are valid angles, and the angle
     * is below PI - epsilon
     */
    @Test
    @DisplayName("LIC 9 Positive: Angle is below PI - epsilon")
    public void testLIC9_Positive_1() {
        // basic triangle, angle is PI/2
        double[] xCoordinates = new double[] { 1, 47, 0, 47, 0 };
        double[] yCoordinates = new double[] { 0, 47, 0, 47, 1 };

        double epsilon = Math.PI * 0.25; // epsilon is 3PI/4
        boolean res = LIC.condition9(xCoordinates, yCoordinates, 1, 1, epsilon, xCoordinates.length);
        assertTrue(res);
    }

    /**
     * Cehcks that the condition is true when there are valid angles, and the angle
     * is above PI + epsilon
     */
    @Test
    @DisplayName("LIC 9 Positive: Angle is above PI + epsilon")
    public void testLIC9_Positive_2() {
        // basic triangle, angle is PI/2
        double[] xCoordinates = new double[] { 1, 47, 0, 47, 0 };
        double[] yCoordinates = new double[] { 0, 47, 0, 47, 1 };

        var epsilon = Math.PI * 0.75 * (-1); // epsilon is -3PI/4
        var res = LIC.condition9(xCoordinates, yCoordinates, 1, 1, epsilon, xCoordinates.length);
        assertTrue(res);
    }

    /**
     * Checks that the method throws an error when cPts or dPts are negative
     */
    @Test
    @DisplayName("LIC 9 Throws: cPts or dPts is negative")
    public void testLIC9_Invalid() {
        assertThrows(Error.class, () -> LIC.condition9(null, null, -1, 1, 0, 0));
        assertThrows(Error.class, () -> LIC.condition9(null, null, 1, -1, 0, 0));
    }

    /**
     * Tests that the calculateTriangleArea method returns the correct area for a
     * sample triangle made of positive coordinates
     */
    @Test
    @DisplayName("Calculate triangle area method returns correct area, positive coordinates")
    public void testCalculateTriangleArea_1() {
        var a = new Point2D.Double(0, 0);
        var b = new Point2D.Double(1, 0);
        var c = new Point2D.Double(0, 1);

        assertEquals(0.5, LIC.calculateTriangleArea(a, b, c));
    }

    /**
     * Tests that the calculateTriangleArea method returns the correct area for a
     * sample triangle made of negative coordinates
     */
    @Test
    @DisplayName("Calculate triangle area method returns correct area, negative coordinates")
    public void testCalculateTriangleArea_2() {
        var a = new Point2D.Double(-1, -1);
        var b = new Point2D.Double(1, -1);
        var c = new Point2D.Double(-1, 1);

        assertEquals(2, LIC.calculateTriangleArea(a, b, c));
    }

    /**
     * Tests that the condition is true when passed a single triangle of area
     * greater than the area parameter
     */
    @Test
    @DisplayName("LIC 10 Positive: Single triangle area greater than area parameter")
    public void testLIC10_Positive_1() {
        double[] xCoordinates = new double[] { 0, 47, 5, 47, 0 };
        double[] yCoordinates = new double[] { 0, 47, 5, 47, 5 };
        // triangle is 5x5, area is 12.5
        double area1 = 12;
        // area1 is less than triangle area, test should pass
        boolean res = LIC.condition10(xCoordinates, yCoordinates, 1, 1, area1, xCoordinates.length);
        assertTrue(res);
    }

    /**
     * Tests that the condition is true when passed both a triangle that exceeds the
     * area parameter, and a triangle that does not
     */
    @Test
    @DisplayName("LIC 10 Positive: Multiple triangles, one greater than area parameter")
    public void testLIC10_Positive_2() {
        var xCoordinates = new double[] { 1, 47, 1, 47, 2, 47, 2 };
        var yCoordinates = new double[] { 0, 47, 1, 47, 1, 47, 4 };

        // first triplet has area 0.5
        // second triplet has area 1.5
        var area1 = 1.4;
        // area1 is less than triangle area, test should pass
        var res = LIC.condition10(xCoordinates, yCoordinates, 1, 1, area1, xCoordinates.length);
        assertTrue(res);
    }

    /**
     * Tests that the condition is false when passed a single triangle of area less
     * than the area parameter
     */
    @Test
    @DisplayName("LIC 10 Negative: Single triangle area less than area parameter")
    public void testLIC10_Negative_1() {
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
    }

    /**
     * Tests that the condition is false when passed two triangles, wich both have
     * areas less than the area parameter
     */
    @Test
    @DisplayName("LIC 10 Negative: Multiple triangles, all less than area parameter")
    public void testLIC10_Negative_2() {
        var xCoordinates = new double[] { 0, 47, 1, 47, 1, 47, 1 };
        var yCoordinates = new double[] { 0, 47, 1, 47, 0, 47, 4 };

        // first triplet is 1x1, area is 0.5
        // second triplet is 1x1, area is 1.5
        var area1 = 1.6;
        // area1 is greater than triangle area, test should fail
        var res = LIC.condition10(xCoordinates, yCoordinates, 1, 1, area1, xCoordinates.length);
        assertFalse(res);
    }

    /**
     * Checks that the method throws an error when ePts or fPts are negative
     */
    @Test
    @DisplayName("LIC 10 Throws: ePts or fPts is negative")
    public void testLIC10_Invalid() {
        assertThrows(Error.class, () -> LIC.condition10(null, null, -1, 1, 0, 0));
        assertThrows(Error.class, () -> LIC.condition10(null, null, 1, -1, 0, 0));
    }

    /**
     * Checks that a the condition is true when one single pair of points fulfills
     * the criteria of x_j - x_i < 0
     */
    @Test
    @DisplayName("LIC 11 Positive: Single pair of points fulfills criteria")
    public void testLIC11_Positive() {
        int numPoints = 10;
        int gPts = 1;
        // on index i = 5 and j = 7 x_j - x_i = 5 - 6 = -1 < 0
        var xCoordinates = new double[] { 0, 1, 2, 3, 4, 6, 6, 5, 8, 9 };
        // y coordinates does not matter
        var yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        boolean res = LIC.condition11(xCoordinates, yCoordinates, gPts, numPoints);

        assertTrue(res);
    }

    /**
     * Check that the condition is false when no pair of points fulfills the
     * criteria of x_j - x_i < 0, as the x-coordinates are increasing
     */
    @Test
    @DisplayName("LIC 11 Negative: No pair of points fulfills criteria")
    public void testLIC11_Negative_1() {
        int numPoints = 10;
        int gPts = 1;
        var xCoordinates = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // y coordinates does not matter
        var yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        boolean res = LIC.condition11(xCoordinates, yCoordinates, gPts, numPoints);

        assertFalse(res);
    }

    /**
     * Check that the condition x_j - x_i < 0 is not fulfilled when x_i = x_j, i.e.
     * the x-coordinates are all equal
     */
    @Test
    @DisplayName("LIC 11 Negative: All x-coordinates are equal")
    public void testLIC11_Negative_2() {
        var xCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        var yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        var res = LIC.condition11(xCoordinates, yCoordinates, 1, xCoordinates.length);
        assertFalse(res);

    }

    /**
     * Check that pairs where j >= i does not count, i.e. that order matters
     */
    @Test
    @DisplayName("LIC 11 Negative: Order matters")
    public void testLIC11_Negative_3() {
        var xCoordinates = new double[] { 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6 };
        var yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        var res = LIC.condition11(xCoordinates, yCoordinates, 1, xCoordinates.length);
        assertFalse(res);
    }

    /**
     * Check that the method throws an error when gPts is negative
     */
    @Test
    @DisplayName("LIC 11 Throws: gPts is negative")
    public void testLIC11_Invalid() {
        assertThrows(Error.class, () -> LIC.condition11(null, null, -1, 0));
    }

    /**
     * Check that the condition is true when one pair of points fulfills the
     * criteria of beeing greater than length1 apart and multiple points fulfills
     * the criteria of beeing less than length2 apart
     */
    @Test
    @DisplayName("LIC 12 Positive: One pair of points fulfills criteria 1, Multiple points fulfills criteria 2")
    public void testLIC12_Positive_1() {
        double length1 = 0.9;
        double length2 = 1;

        double[] xCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        double[] yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 };

        boolean res = LIC.condition12(xCoordinates, yCoordinates, 1, length1, length2, xCoordinates.length);
        assertTrue(res);
    }

    /**
     * Test that the condition is true when exactly one pair of points fulfills the
     * criteria of beeing greater than length1 apart and exactly one pair of points
     * fulfills the criteria of beeing less than length2 apart
     */
    @Test
    @DisplayName("LIC 12 Positive: Exactly one pair of fulfills the criteras respectively")
    public void testLIC12_Positive_2() {
        var length1 = 100;
        var length2 = 1.1;
        var xCoordinates = new double[] { 2, 4, 6, 8, 10, 9, 14, 16, 18, 120 };
        var yCoordinates = new double[] { 2, 4, 6, 8, 10, 8, 14, 16, 18, 120 };
        boolean res = LIC.condition12(xCoordinates, yCoordinates, 1, length1, length2, xCoordinates.length);
        assertTrue(res);
    }

    /**
     * Tests that the condition is false when no pair of points fulfills the
     * criteria of beeing greater than length2 apart, by having all distances 0
     */
    @DisplayName("LIC 12 Negative: All distances 0")
    @Test
    public void testLIC12_Negative() {
        int kPts = 1;
        double length1 = 1;
        double length2 = 1;
        int numPoints = 10;

        double[] xCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        double[] yCoordinates = new double[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

        boolean res = LIC.condition12(xCoordinates, yCoordinates, kPts, length1, length2, numPoints);
        assertFalse(res);
    }

    /**
     * Check that the method throws an error when kPts or lengths is negative
     */
    @Test
    @DisplayName("LIC 12 Throws: kPts or lengths is negative")
    public void testLIC12_Invalid() {
        // kPts too small
        assertThrows(Error.class, () -> LIC.condition12(null, null, -1, 1, 1, 0));
        // length1 too small
        assertThrows(Error.class, () -> LIC.condition12(null, null, 1, -1, 1, 0));
        // length2 too small
        assertThrows(Error.class, () -> LIC.condition12(null, null, 1, 1, -1, 0));
    }

    /**
     * Check that the condition is true when one triangle both exceeds area1 and is
     * below area2
     */
    @Test
    @DisplayName("LIC 14 Positive: One triangle exceeds area1 and is below area2")
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

    /** Check that the condition is false when no triangle exceeds area1 */
    @Test
    @DisplayName("LIC 14 Negative: No triangle exceeds area1")
    public void testLIC14_Negative_1() {
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
    }

    /** Check that the condition is false when no triangle is below area2 */
    @Test
    @DisplayName("LIC 14 Negative: No triangle is below area2")
    public void testLIC14_Negative_2() {
        int ePts = 1;
        int fPts = 1;
        int numPoints = 5;
        double[] xCoordinates = new double[] { 0, 47, 5, 47, 0 };
        double[] yCoordinates = new double[] { 0, 47, 5, 47, 5 };
        // triangle is 5x5, area is 12.5
        var area1 = 12;
        var area2 = 12;
        boolean res = LIC.condition14(xCoordinates, yCoordinates, ePts, fPts, area1, area2, numPoints);
        assertFalse(res);
    }

    /**
     * Check that the method throws an error when ePts, fPts, area1 or area2 is
     * negative
     */
    @Test
    @DisplayName("LIC 14 Throws: ePts, fPts, area1 or area2 is negative")
    public void testLIC14_Invalid() {
        // ePts or fPts too small
        assertThrows(Error.class, () -> LIC.condition14(null, null, -1, 1, 0, 0, 0));
        assertThrows(Error.class, () -> LIC.condition14(null, null, 1, -1, 0, 0, 0));
        // areas too small
        assertThrows(Error.class, () -> LIC.condition14(null, null, 1, 1, -1, 0, 0));
        assertThrows(Error.class, () -> LIC.condition14(null, null, 1, 1, 0, -1, 0));
    }

    @Test
    @DisplayName("LIC 13: Test invalid radius1")
    void testLIC13_Invalid_Radius1() {
        Throwable t = assertThrows(Error.class, () -> LIC.condition13(null, null, 1, 1, -1, 0, 0));
        assertEquals("Invalid input provided, radius1 must be greater than 0", t.getMessage());
    }
    @Test
    @DisplayName("LIC 13: Test invalid radius2")
    void testLIC13_Invalid_Radius2() {
        Throwable t = assertThrows(Error.class, () -> LIC.condition13(null, null, 1, 1, 0, -1, 0));
        assertEquals("Invalid input provided, radius2 must be greater than 0", t.getMessage());
    }
    @Test
    @DisplayName("LIC 13: Test invalid aPts")
    void testLIC13_Invalid_APts() {
        Throwable t = assertThrows(Error.class, () -> LIC.condition13(null, null, 0, 1, 0, 0, 0));
        assertEquals("Invalid input provided, aPts must be greater than 1", t.getMessage());
    }
    @Test
    @DisplayName("LIC 13: Test invalid bPts")
    void testLIC13_Invalid_BPts() {
        Throwable t = assertThrows(Error.class, () -> LIC.condition13(null, null, 1, 0, 0, 0, 0));
        assertEquals("Invalid input provided, bPts must be greater than 1", t.getMessage());
    }
    @Test
    @DisplayName("LIC 13: Test positive")
    void testLIC13_Positive() {
        // the data points on index 0, 2, 5 has a radius of 0.7071
        double [] x = {0, 0, 0, 0, 0, 1};
        double [] y = {0, 0, 1, 0, 0, 0};
        int aPts =1;
        int bPts =2;
        assertTrue(LIC.condition13(x, y, aPts, bPts, 0.5, 1, 6));
    }
    @Test
    @DisplayName("LIC 13: Test negative")
    void testLIC13_Negative() {
        // the data points on index 0, 2, 5 has a radius of 0.7071
        double [] x = {0, 0, 0, 0, 0, 1};
        double [] y = {0, 0, 1, 0, 0, 0};
        int aPts =1;
        int bPts =2;
        assertFalse(LIC.condition13(x, y, aPts, bPts, 0.5, 0.7, 6));
    }

}
