package org.labs.lab1;

/**
 * Class for storing all input data to the LaunchInterceptor program.
 */
public class InputData {

    /**
     * The number of planar data points.
     */
    public int numPoints;
    /**
     * The x-coordinates of points.
     */
    public double[] xCoordinates;

    /**
     * The y-coordinates of points.
     */
    public double[] yCoordinates;

    /**
     * The Logical Connector Matrix.
     */
    public int[][] LCM;

    /**
     * The Preliminary Unlocking Vector
     */
    public boolean[] PUV;

    /**
     * Length in LICs 0 , 7 , 12
     */
    public double length1;

    /**
     * Maximum length in LIC 12
     */
    public double length2;

    /**
     * Radius in LICs 1, 8, 13
     */
    public double radius1;

    /**
     * Maximum radius in LIC 13
     */
    public double radius2;

    /**
     * Deviation from PI in LICs 2, 9
     */
    public double epsilon;

    /**
     * Area in LICs 3, 10, 14
     */
    public double area1;

    /**
     * Maximum area in LIC 14
     */
    public double area2;

    /**
     * No. of quadrants in LIC 4
     */
    public int quads;

    /**
     * Distance in LIC 6
     */
    public double dist;

    /**
     * No. of int. pts. in LICs 8, 13
     */
    public int aPts;

    /**
     * No. of int. pts. in LICs 8, 13
     */
    public int bPts;

    /**
     * No. of int. pts. in LIC 9
     */
    public int cPts;

    /**
     * No. of int. pts. in LIC 9
     */
    public int dPts;

    /**
     * No. of int. pts. in LICs 10, 14
     */
    public int ePts;

    /**
     * No. of int. pts. in LICs 10, 14
     */
    public int fPts;

    /**
     * No. of int. pts. in LIC 11
     */
    public int gPts;

    /**
     * No. of int. pts. in LICs 7, 12
     */
    public int kPts;

    /**
     * No. of consecutive points in LIC 6
     */
    public int nPts;

    /**
     * No. of consecutive points in LIC 4
     */
    public int qPts;


    /**
     * Used to construct an object holding all input data.
     */
    public InputData(double[] xCoordinates, double[] yCoordinates, int[][] LCM, boolean[] PUV,
                     double length1, double length2, double radius1, double radius2, double epsilon,
                     double area1, double area2, int quads, double dist, int aPts, int bPts, int cPts,
                     int dPts, int ePts, int fPts, int gPts, int kPts, int nPts, int qPts) {
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
        this.LCM = LCM;
        this.PUV = PUV;
        this.length1 = length1;
        this.length2 = length2;
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.epsilon = epsilon;
        this.area1 = area1;
        this.area2 = area2;
        this.quads = quads;
        this.dist = dist;
        this.aPts = aPts;
        this.bPts = bPts;
        this.cPts = cPts;
        this.dPts = dPts;
        this.ePts = ePts;
        this.fPts = fPts;
        this.gPts = gPts;
        this.kPts = kPts;
        this.nPts = nPts;
        this.qPts = qPts;
        this.numPoints = xCoordinates.length;
    }

}
