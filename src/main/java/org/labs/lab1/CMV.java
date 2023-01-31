package org.labs.lab1;

/**
 * A class for the Conditions Met Vector (CMV).
 */
public class CMV {

    private boolean[] cmv;

    // TODO doc
    public CMV(InputData data) {
        // Computes cmv using LIC static methods
        cmv = new boolean[15];
        cmv[0] = LIC.condition0(data.xCoordinates, data.yCoordinates, data.length1);
        cmv[1] = LIC.condition1(data.xCoordinates, data.yCoordinates, data.radius1);
        cmv[2] = LIC.condition2(data.xCoordinates, data.yCoordinates, data.epsilon);
        cmv[3] = LIC.condition3(data.xCoordinates, data.yCoordinates, data.area1);
        cmv[4] = LIC.condition4(data.xCoordinates, data.yCoordinates, data.qPts, data.quads, data.numPoints);
        cmv[5] = LIC.condition5(data.xCoordinates, data.yCoordinates);
        cmv[6] = LIC.condition6(data.xCoordinates, data.yCoordinates, data.nPts, data.dist, data.numPoints);
        cmv[7] = LIC.condition7(data.xCoordinates, data.yCoordinates, data.kPts, data.length1, data.numPoints);
        cmv[8] = LIC.condition8(data.xCoordinates, data.yCoordinates, data.aPts, data.bPts, data.radius1, data.numPoints);
        cmv[9] = LIC.condition9(data.xCoordinates, data.yCoordinates, data.cPts, data.dPts, data.epsilon, data.numPoints);
        cmv[10] = LIC.condition10(data.xCoordinates, data.yCoordinates, data.ePts, data.fPts, data.area1, data.numPoints);
        cmv[11] = LIC.condition11(data.xCoordinates, data.yCoordinates, data.gPts, data.numPoints);
        cmv[12] = LIC.condition12(data.xCoordinates, data.yCoordinates, data.kPts, data.length1, data.length2, data.numPoints);
        cmv[13] = LIC.condition13(data.xCoordinates, data.yCoordinates, data.aPts, data.bPts, data.radius1, data.radius2, data.numPoints);
        cmv[14] = LIC.condition14(data.xCoordinates, data.yCoordinates, data.ePts, data.fPts, data.area1, data.area2, data.numPoints);
    }

    /**
     * Constructs a CMV object from a custom boolean vector. Used in testing
     * @param customCmv the custom CMV
     */
    public CMV(boolean[] customCmv) {
        this.cmv = customCmv;
    }


    /**
     * Gets the i:th element of the CMV.
     */
    public boolean get(int i) {
        // Checks if i is within bounds
        if (i < 0 || i > 14) {
            throw new IndexOutOfBoundsException(String.format("Index %d must be between 0 and 14 (inclusive)", i));
        }
        // Gets the ith element of the computed cmv
        return this.cmv[i];
    }

    /**
     * Gets the length of the CVM.
     */
    public int getLength() {
        return this.cmv.length;
    }

}
