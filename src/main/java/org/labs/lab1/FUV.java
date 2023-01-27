package org.labs.lab1;

/**
 * A class for the Final Unlocking Vector (FUV).
 */
public class FUV {

    private boolean[] fuv;

    // TODO doc
    public FUV(PUM pum, boolean[] puv) {
        // Calculates the FUV using PUM and PUV
    }

    /**
     * Gets the i:th element of the FUV.
     */
    public boolean get(int i) {
        return this.fuv[i];
    }


    /**
     * Gets the length of the FUV.
     */
    public int getLength() {
        return this.fuv.length;
    }

}
