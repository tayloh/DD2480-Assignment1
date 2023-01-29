package org.labs.lab1;

/**
 * Utility class containing functions
 * for calculating Launch Interceptor Conditions (LICs) 0-14.
 */
public class LIC {

    // Feel free to add helper functions

    /**
     * Check if condition 0 is met: there exists at least one set of two
     * consecutive data points that have a distance greater than LENGTH1.
     *
     * @param xCoords contains all x coordinates
     * @param yCoords contains all y coordinates
     * @param length1 contains LENGTH1 from the input-data
     * @return if condition 0 is true or not
     */
    public static boolean condition0(int[] xCoords, int[] yCoords, double length1) {

        for(int i = 0 ; i < xCoords.length -1; i++){
            double distance = calcDistance(xCoords[i],yCoords[i],xCoords[i+1],yCoords[i+1]);
            if(distance > length1){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param xCoord first x coordinate
     * @param yCoord first y coordinate
     * @param xCoord1 second x coordinate
     * @param yCoord1 second y coordinate
     * @return the distance between the first and second coordinate
     */
    private static double calcDistance(int xCoord, int yCoord, int xCoord1, int yCoord1) {
        double xDiff = xCoord - xCoord1;
        double yDiff = yCoord - yCoord1;

        return Math.sqrt( Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }

}
