package org.labs.lab1;

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

    public static boolean condition7(double[] xCoords, double[] yCoords, int kPts, double length1, int numPoints) {
        if (numPoints >= 3 && kPts >= 1 && kPts <= numPoints - 2) {
            for (int i = 0; i + kPts + 1 < numPoints; i++) {
                double dist = Math.sqrt(Math.pow(xCoords[i+kPts+1] - xCoords[i], 2) + Math.pow(yCoords[i+kPts+1] - yCoords[i], 2));
                if (dist > length1) return true;
            }
        }
        return false;
    }

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

}
