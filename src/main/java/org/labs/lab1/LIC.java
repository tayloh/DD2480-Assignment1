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
     * Definition of the LIC 7 boolean condition
     * @param xCoords
     * @param yCoords
     * @param kPts
     * @param length1
     * @param numPoints
     * @return
     */
    public static boolean condition7(double[] xCoords, double[] yCoords, int kPts, double length1, int numPoints) {
        if (numPoints >= 3 && kPts >= 1 && kPts <= numPoints - 2) {
            for (int i = 0; i + kPts + 1 < numPoints; i++) {
                double dist = Math.sqrt(Math.pow(xCoords[i+kPts+1] - xCoords[i], 2) + Math.pow(yCoords[i+kPts+1] - yCoords[i], 2));
                if (dist > length1) return true;
            }
        }
        return false;
    }

    /**
     * Definition of the LIC 8 boolean condition
     * @param xCoords
     * @param yCoords
     * @param aPts
     * @param bPts
     * @param radius1
     * @param numPoints
     * @return
     */
    public static boolean condition8(double[] xCoords, double[] yCoords, int aPts, int bPts, double radius1, int numPoints) {
        if (numPoints >= 5 && 1 <= aPts && 1 <= bPts && aPts + bPts <= (numPoints - 2)) {
            for (int i = 0; i + aPts + bPts + 2 < numPoints; i++) {
                int p1 = i;
                int p2 = i + aPts + 1;
                int p3 = i + aPts + bPts + 2;

                if (findSmallestCircle(xCoords[p1], yCoords[p1], xCoords[p2], yCoords[p2], xCoords[p3], yCoords[p3]) > radius1) return true;
            }
        }
        return false;
    }

    /**
     * Function to find the minimal enclosing circle of a triangle (defined by 3 points)
     * Based on algorithm for the MEC problem from: https://www.cs.mcgill.ca/~cs507/projects/1998/jacob/solutions.html
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @return the radius of the minimum enclosing circle
     */
    private static double findSmallestCircle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double radius = 0;

        // distances from the 3 points to one another
        double dist12 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double dist13 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double dist23 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        // angles in the triangle made up by the 3 points
        double p1Angle = Math.acos((Math.pow(dist12, 2) + Math.pow(dist13, 2) - Math.pow(dist23, 2)) / (2 * dist12 * dist13));
        double p2Angle = Math.acos((Math.pow(dist12, 2) + Math.pow(dist23, 2) - Math.pow(dist13, 2)) / (2 * dist12 * dist23));
        double p3Angle = Math.acos((Math.pow(dist13, 2) + Math.pow(dist23, 2) - Math.pow(dist12, 2)) / (2 * dist13 * dist23));

        // loop until either current angle is obtuse or we find that all angles are acute
        double currAngle = p3Angle;
        double currSide = dist12;
        double otherAngle1 = p1Angle;
        double otherAngle2 = p2Angle;
        while(true) {
            // current angle is obtuse: return circle with its diameter along the side opposite of current angle
            if (currAngle >= Math.PI / 2) {
                radius = currSide / 2;
                break;
            }
            else {
                // all angles are acute: return the unique circumcircle radius
                if (otherAngle1 < Math.PI / 2 && otherAngle2 < Math.PI / 2) {
                    radius = (dist12 * dist13 * dist23) / Math.sqrt((dist12+dist13+dist23)*(dist13+dist23-dist12)*(dist23+dist12-dist13)*(dist12+dist13-dist23));
                    break;
                }
                else {
                    // one of the other angles is obtuse: check which one and set it to currAngle
                    // also switch currSide so it is the side opposite to the new currAngle

                    if (otherAngle1 >= Math.PI / 2) {
                        double temp = currAngle;
                        currAngle = otherAngle1;
                        otherAngle1 = temp;
                        currSide = currAngle == p1Angle ? dist23 : (currAngle == p2Angle ? dist13 : dist12);
                    }
                    else {
                        double temp = currAngle;
                        currAngle = otherAngle2;
                        otherAngle2 = temp;
                        currSide = currAngle == p1Angle ? dist23 : (currAngle == p2Angle ? dist13 : dist12);
                    }
                }
            }
        }

        return radius;
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
    public static boolean condition10(double[] xCoordinates, double[] yCoordinates, int ePts, int fPts, double area1, int numPoints) {
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
        if (gPts < 0) {
            throw new Error("Invalid input provided, gPts must be greater than 0");
        }
        if (numPoints < 3) {
            return false;
        }
        int nPossiblePairs = numPoints - (gPts + 1);
        for (int i = 0; i < nPossiblePairs; i++) {
            var points = findPointPair(xCoordinates, yCoordinates, i, gPts);
            if (points[1].x - points[0].x < 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the distance between two points
     * 
     * @param a the first point
     * @param b the second point
     * @return the distance between the two points
     */
    public static double calculateDistance(Point2D.Double a, Point2D.Double b) {
        return Math.hypot(b.x - a.x, b.y - a.y);
    }

    /**
     * Checks the 12th condition of the LIC
     * Checks that there is two points (a, b) separated by kPts points such that
     * the distance between them is greater than length1 and two points (c, d)
     * separated by kPts points such that the distance between them is less than
     * length2
     * 
     * @param xCoordinates an array of x-coordinates
     * @param yCoordinates an array of y-coordinates
     * @param kPts         the number of points between the two points
     * @param length1      the distance that the first pair of points should exceed
     * @param length2      the distance that the second pair of points should be
     *                     less than
     * @param numPoints    the total number of points
     * @return true if the two pairs of points are found, false otherwise
     * 
     */
    public static boolean condition12(double[] xCoordinates, double[] yCoordinates, int kPts, double length1,
            double length2, int numPoints) {
        if (kPts < 0 || length1 < 0 || length2 < 0) {
            throw new Error("Invalid input provided, kPts and lengths must be greater than 0");
        }
        if (numPoints < 3) {
            return false;
        }
        boolean foundGreater = false;
        boolean foundLesser = false;
        int nPossiblePairs = numPoints - (kPts + 1);
        for (int i = 0; i < nPossiblePairs; i++) {
            var points = findPointPair(xCoordinates, yCoordinates, i, kPts);
            double distance = calculateDistance(points[0], points[1]);
            if (distance > length1) {
                foundGreater = true;
            }
            if (distance < length2) {
                foundLesser = true;
            }
            if (foundGreater && foundLesser) {
                break;
            }
        }
        return foundGreater && foundLesser;
    }

}
