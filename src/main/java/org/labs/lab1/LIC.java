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


    /**
     * Returns true if there exists at least one set of qPts consecutive data points that
     * lie in more than quads quadrants, else false.
     * @param xCoords points x-coordinates
     * @param yCoords points y-coordinates
     * @param qPts consecutive data points
     * @param quads number of quadrants
     * @param numPoints number of points
     */
    public static boolean condition4(double[] xCoords, double yCoords[], int qPts, int quads, int numPoints) {
        if (!(2 <= qPts && qPts <= numPoints)) {
            throw new IllegalArgumentException("qPts not within correct range.");
        }

        if (!(1 <= quads && quads <= 3)) {
            throw  new IllegalArgumentException("quads not within correct range");
        }

        for (int i = 0; i < numPoints - qPts; i++) {
            // For each point, check if the next three points
            // lie in at least quads+1 different quadrants.
            // At most, they can lie on 4 different quadrants,
            // don't just count them; since we need to keep track of which
            // quadrants has already been "visited":
            boolean[] quadrantHasPoint = {false, false, false, false};

            for (int conecutiveIndex = 0; conecutiveIndex < qPts; conecutiveIndex++) {
                double x = xCoords[i + conecutiveIndex];
                double y = yCoords[i + conecutiveIndex];

                // Priority is given by quadrant number (for when x or y is 0)
                // Quadrant 1
                if (x >= 0 && y >= 0) {
                    quadrantHasPoint[0] = true;
                }
                // Quadrant 2
                else if (x < 0 && y >= 0) {
                    quadrantHasPoint[1] = true;
                }
                // Quadrant 3
                else if (x <= 0 && y < 0) {
                    quadrantHasPoint[2] = true;
                }
                // Quadrant 4
                else if (x > 0 && y < 0) {
                    quadrantHasPoint[3] = true;
                }

            }

            // Check how many quadrants were visited
            int consecutiveQuadrants = 0;
            for (int j = 0; j < quadrantHasPoint.length; j++) {
                if (quadrantHasPoint[j]) {
                    consecutiveQuadrants++;
                }
            }

            // If it's more than quads, return true
            if (consecutiveQuadrants > quads) {
                return true;
            }

        }

        return false;
    }

    /**
     * Returns true if there exists at least one set of two consecutive data points
     * (X[i],Y[i]) and (X[j],Y[j]), such that X[j]-X[i] < 0 (where i = j-1), else false.
     * @param xCoords points x-coordinates
     * @param yCoords points y-coordinates
     */
    public static boolean condition5(double[] xCoords, double yCoords[]) {

        // If there are less than 2 points this can never be true
        if (xCoords.length != yCoords.length || xCoords.length < 2) {
            return false;
        }

        for (int j = 1; j < xCoords.length; j++) {
            int i = j - 1;
            if (xCoords[j] - xCoords[i] < 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean condition6(double[] xCoords, double yCoords[]) {
        return true;
    }

}
