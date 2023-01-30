package org.labs.lab1;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * A class for the Conditions Met Vector (CMV).
 */
public class CMV {

    private boolean[] cmv;

    // TODO doc
    public CMV(InputData data) {
        // Computes cmv using LIC static methods
        this.cmv = new boolean[15];
        this.cmv[9] = LIC.condition9(data);
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
