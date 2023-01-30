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
    public static boolean condition0(double[] xCoords, double[] yCoords, double length1) {

        for(int i = 0 ; i < xCoords.length -1; i++){
            double distance = calcDistance(xCoords[i],yCoords[i],xCoords[i+1],yCoords[i+1]);
            if(distance > length1){
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the distance between two coordinates
     *
     * @param xCoord first x coordinate
     * @param yCoord first y coordinate
     * @param xCoord1 second x coordinate
     * @param yCoord1 second y coordinate
     * @return the distance between the first and second coordinate
     */
    private static double calcDistance(double xCoord, double yCoord, double xCoord1, double yCoord1) {
        double xDiff = xCoord - xCoord1;
        double yDiff = yCoord - yCoord1;

        return Math.sqrt( Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }

    /**
     * Check if condition 1 is met: there exists at least one set of three consecutive data points
     * that can NOT all be contained within or on a circle of radius of RADIUS1
     *
     * @param xCoords contains all x coordinates
     * @param yCoords contains all y coordinates
     * @param radius1 contains RADIUS1 from the input-data
     * @return if condition 1 is true or not
     */
    public static boolean condition1(double[] xCoords, double[] yCoords, double radius1) {
        for(int i = 0 ; i < xCoords.length -2; i++){
            //check if it's a Collinear (they build a straight line)
            if(isCollinear(xCoords[i], yCoords[i], xCoords[i+1], yCoords[i+1], xCoords[i+2], yCoords[i+2])){
                double greatestDistance = getGreatestDistance(xCoords[i], yCoords[i], xCoords[i+1], yCoords[i+1], xCoords[i+2], yCoords[i+2]);
                //if the line is larger than the diameter of the circle, the points can not fit in the circle
                if(greatestDistance > radius1 * 2){
                    return true;
                }
            }else {
                double r = findCircleRadius(xCoords[i], yCoords[i], xCoords[i+1], yCoords[i+1], xCoords[i+2], yCoords[i+2]);

                // if r > radius1 then the three data points can NOT be contained within or on a circle of radius radius1
                if (r > radius1){
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * Calculates the greatest distance of three points
     *
     * @param xCoord first x coordinate
     * @param yCoord first y coordinate
     * @param xCoord1 second x coordinate
     * @param yCoord1 second y coordinate
     * @param xCoord2 third x coordinate
     * @param yCoord2 third y coordinate
     * @return the greatest distance of the three points
     */
    private static double getGreatestDistance(double xCoord, double yCoord, double xCoord1, double yCoord1, double xCoord2, double yCoord2) {
        double distanceA = calcDistance(xCoord,yCoord,xCoord1,yCoord1);
        double distanceB = calcDistance(xCoord,yCoord,xCoord2,yCoord2);
        double distanceC = calcDistance(xCoord1,yCoord1,xCoord2,yCoord2);
        double greatestDistance = distanceC;
        if(distanceA > distanceC){
            if(distanceA > distanceB){
                greatestDistance = distanceA;
            }else {
                greatestDistance = distanceB;
            }
        } else if (distanceB > distanceC) {
            greatestDistance = distanceB;
        }
        return greatestDistance;
    }

    /**
     * Checks if the three points are collinear
     *
     * @param xCoord first x coordinate
     * @param yCoord first y coordinate
     * @param xCoord1 second x coordinate
     * @param yCoord1 second y coordinate
     * @param xCoord2 third x coordinate
     * @param yCoord2 third y coordinate
     * @return if the three points are collinear
     */
    private static boolean isCollinear(double xCoord, double yCoord, double xCoord1, double yCoord1, double xCoord2, double yCoord2) {
        double triangleArea = 0.5*(xCoord * (yCoord1 - yCoord2) + xCoord1 * (yCoord2 - yCoord) + xCoord2 * (yCoord - yCoord1));
        return triangleArea == 0;
    }

    /**
     * Finds the radius of the circles
     *
     * @param x1 first x coordinate
     * @param y1 first y coordinate
     * @param x2 second x coordinate
     * @param y2 second y coordinate
     * @param x3 third x coordinate
     * @param y3 third y coordinate
     * @return the radius of the circles
     */
    private static double findCircleRadius(double x1, double y1, double x2, double y2, double x3, double y3){

        //x^2 + y^2 + 2*g*x + 2*f*y + c = 0
        //centre is (h = -g, k = -f) and radius r
        //r^2 = h^2 + k^2 - c

        double xDiff12 = x1 - x2;
        double xDiff13 = x1 - x3;

        double yDiff12 = y1 - y2;
        double yDiff13 = y1 - y3;

        double yDiff21 = y2 - y1;
        double yDiff31 = y3 - y1;

        double xDiff21 = x2 - x1;
        double xDiff31 = x3 - x1;

        double expoXDiff13 = (Math.pow(x1, 2) - Math.pow(x3, 2));

        double expoYDiff13 = (Math.pow(y1, 2) - Math.pow(y3, 2));

        double expoXDiff21 = (Math.pow(x2, 2) - Math.pow(x1, 2));

        double expoYDiff21 = (Math.pow(y2, 2) - Math.pow(y1, 2));

        double f = ((expoXDiff13) * (xDiff12)
                + (expoYDiff13) * (xDiff12)
                + (expoXDiff21) * (xDiff13)
                + (expoYDiff21) * (xDiff13))
                / (2 * ((yDiff31) * (xDiff12) - (yDiff21) * (xDiff13)));
        double g = ((expoXDiff13) * (yDiff12)
                + (expoYDiff13) * (yDiff12)
                + (expoXDiff21) * (yDiff13)
                + (expoYDiff21) * (yDiff13))
                / (2 * ((xDiff31) * (yDiff12) - (xDiff21) * (yDiff13)));

        double c = -Math.pow(x1, 2) - Math.pow(y1, 2) - 2 * g * x1 - 2 * f * y1;
        double h = -g;
        double k = -f;

        double r = Math.sqrt(h * h + k * k - c);

        return r;
    }

    /**
     * Check if condition 2 is met: there exists at least one set of three consecutive data points which
     * form an angle such that: angle < (PI−EPSILON) or angle > (PI+EPSILON)
     * The second of the three consecutive points is always the vertex (center) of the angle. The angle is undefined
     * and the LIC is not satisfied for three points if the first or last (or both) point is coincides with the vertex.
     *
     * @param xCoords contains all x coordinates
     * @param yCoords contains all y coordinates
     * @param epsilon contains EPSILON from the input-data
     * @return if condition 2 is met.
     */
    public static boolean condition2(double[] xCoords, double[] yCoords, double epsilon) {
        for(int i = 0 ; i < xCoords.length -2; i++) {
            if((xCoords[i] == xCoords[i+1] && yCoords[i] == yCoords[i+1])
            || (xCoords[i+2] == xCoords[i+1] && yCoords[i+2] == yCoords[i+1]) ){
               continue;
            }

            double ax = xCoords[i] - xCoords[i+1];
            double ay = yCoords[i] - yCoords[i+1];
            double bx = xCoords[i+2] - xCoords[i+1];
            double by = yCoords[i+2] - yCoords[i+1];

            double va = Math.atan2(ay, ax);
            double vb = Math.atan2(by, bx);
            double angle = vb - va;

            //Adding 360 degrees if the angle is negative (gives the same angle)
            if (angle < 0) {
                angle += (2*Math.PI);
            }

            if(angle < Math.PI - epsilon || angle > Math.PI + epsilon){
                return true;
            }

        }
        return false;
    }
}
