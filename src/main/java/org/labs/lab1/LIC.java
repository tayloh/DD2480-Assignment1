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
     * Finds a point triplet from a given respective point distance between them
     * 
     * @param xCoordinates an array of x-coordinates
     * @param yCoordinates an array of y-coordinates
     * @param offset       the offset from where the first point is checked
     * @param distanceA    the distance between the first and the second point
     * @param distanceB    the distance between the second and third point
     * @return The three found points
     */
    public static Point2D.Double[] findPointTriplet(double[] xCoordinates, double[] yCoordinates, int offset,
            int distanceA, int distanceB) {

        int firstIndex = offset;
        int secondIndex = offset + distanceA + 1;
        int thirdIndex = offset + distanceA + distanceB + 2;

        var first = new Point2D.Double(xCoordinates[firstIndex], yCoordinates[firstIndex]);
        var second = new Point2D.Double(xCoordinates[secondIndex], yCoordinates[secondIndex]);
        var third = new Point2D.Double(xCoordinates[thirdIndex], yCoordinates[thirdIndex]);

        return new Point2D.Double[] { first, second, third };
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
            var points = findPointTriplet(xCoordinates, yCoordinates, i, cPts, dPts);

            // if angle is invalid, skip triplet
            if (points[0].equals(points[1]) || points[1].equals(points[2])) {
                continue;
            }
            // check angle requirement
            double angle = calculateAngle(points[0], points[1], points[2]);
            if (angle < (Math.PI - epsilon) || angle > (Math.PI + epsilon)) {
                return true;
            }
        }
        return false;
    }

    public static boolean condition10(double[] xCoordinates, double[] yCoordinates, int ePts, int fPts, double area1,
            int numPoints) {

        return false;
    }

}
