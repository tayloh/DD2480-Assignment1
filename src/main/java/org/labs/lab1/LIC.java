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

}
