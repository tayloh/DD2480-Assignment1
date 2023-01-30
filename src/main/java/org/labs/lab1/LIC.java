package org.labs.lab1;

import java.awt.geom.Point2D;

/**
 * Utility class containing functions
 * for calculating Launch Interceptor Conditions (LICs) 0-14.
 */
public class LIC {

    // Feel free to add helper functions

    public static boolean condition0(int[] xCoords, int[] yCoords, double length1) {
        // This is just an example of a LIC declaration
        return true;
    }

    /**
     * Calculates the angle between three double-precision 2D-points where b is the
     * vertex
     *
     * @param a the first point
     * @param b the second point and vertex
     * @param c the last point
     * @return the angle between the two vectors BA and BC
     */
    public static double calculateAngle(Point2D.Double a, Point2D.Double b, Point2D.Double c) {
        return Math.atan2(c.y - b.y, c.x - b.x) - Math.atan2(a.y - b.y, a.x - b.x);
    }

    /**
     * Checks the condition 9 of the LIC.
     * Asserts that there is a triplet of points where the angle between them is
     * more than PI + epsilon or less than PI - epsilon.
     * The points are selected with the requirement to have cPts respective dPts
     * number of points between them.
     *
     * @param data the InputData provided to the CMV
     * @return True if the condition is met, False otherwise.
     */
    public static boolean condition9(double[] xCoordinates, double[] yCoordinates, int cPts, int dPts, double epsilon,
            int numPoints) {
        // check that input is valid
        if (cPts < 1 || dPts < 1) {
            throw new Error("Invalid input provided");
        }
        // check that we have enough points to measure
        if (numPoints < 5) {
            return false;
        }
        int nPossibleTriplets = numPoints - (cPts + dPts + 2);
        for (int i = 0; i < nPossibleTriplets; i++) {
            // extract points
            int firstIndex = i;
            int secondIndex = i + cPts + 1;
            int thirdIndex = i + cPts + dPts + 2;

            var first = new Point2D.Double(xCoordinates[firstIndex], yCoordinates[firstIndex]);
            var second = new Point2D.Double(xCoordinates[secondIndex], yCoordinates[secondIndex]);
            var third = new Point2D.Double(xCoordinates[thirdIndex], yCoordinates[thirdIndex]);

            // if angle is invalid, skip triplet
            if (first.equals(second) || second.equals(third)) {
                continue;
            }
            // check angle requirement
            double angle = calculateAngle(first, second, third);
            if (angle < (Math.PI - epsilon) || angle > (Math.PI + epsilon)) {
                return true;
            }
        }
        return false;
    }

}
