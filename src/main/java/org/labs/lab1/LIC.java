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
     * Finds a point pair from a given respective point distance between them
     * 
     * @param xCoordinates an array of x-coordinates
     * @param yCoordinates an array of y-coordinates
     * @param offset       the offset from where the first point is checked
     * @param distance     the distance between the first and the second point
     * @return The two found points
     */
    public static Point2D.Double[] findPointPair(double[] xCoordinates, double[] yCoordinates, int offset,
            int distance) {
        int firstIndex = offset;
        int secondIndex = offset + distance + 1;

        var first = new Point2D.Double(xCoordinates[firstIndex], yCoordinates[firstIndex]);
        var second = new Point2D.Double(xCoordinates[secondIndex], yCoordinates[secondIndex]);

        return new Point2D.Double[] { first, second };
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

    /**
     * Calculates the area of a triangle with the three given points as vertices
     * 
     * @param a the first point
     * @param b the second point
     * @param c the third point
     * @return the area of the triangle
     */
    public static double calculateTriangleArea(Point2D.Double a, Point2D.Double b, Point2D.Double c) {
        return Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
    }

    /**
     * Checks the 10th condition of the LIC
     * Asserts that there is a triplet of points wich encloses a triangle with an
     * area that exceeds area1
     * The points are selected with the requirement to have ePts respective fPts
     * number of points between them.
     * 
     * @param xCoordinates an array of x-coordinates
     * @param yCoordinates an array of y-coordinates
     * @param ePts         the number of points between the first and the second
     *                     selected point
     * @param fPts         the number of points between the second and third
     *                     selected point
     * @param area1        the area that the triangle should exceed
     * @param numPoints    the total number of points
     * @return true if the area of the triangle exceeds the area1 param, false
     *         otherwise
     */
    public static boolean condition10(double[] xCoordinates, double[] yCoordinates, int ePts, int fPts, double area1,
            int numPoints) {
        if (ePts < 1 || fPts < 1) {
            throw new Error("Invalid input provided, ePts and fPts must be greater than 0");
        }
        if (numPoints < 5) {
            return false;
        }
        int nPossibleTriplets = numPoints - (ePts + fPts + 2);
        for (int i = 0; i < nPossibleTriplets; i++) {
            var points = findPointTriplet(xCoordinates, yCoordinates, i, ePts, fPts);
            double area = calculateTriangleArea(points[0], points[1], points[2]);
            if (area > area1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the 11th condition of the LIC
     * Checks if there exists a set of two points (a, b) separated by gPts points
     * such that bx-ax < 0 and a comes before b in the sequence of points.
     * 
     * @param xCoordinates an array of x-coordinates
     * @param yCoordinates an array of y-coordinates
     * @param gPts         the number of points between the two points
     * @param numPoints    the total number of points
     * @return
     * 
     */
    public static boolean condition11(double[] xCoordinates, double[] yCoordinates, int gPts, int numPoints) {
        return false;
    }

}
