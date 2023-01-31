package org.labs.lab1;

/**
 * A class for the Preliminary Unlocking Matrix (PUM).
 */
public class PUM {

    private boolean[][] pum;

    /**
     * Constructs a PUM object from a custom
     * PUM matrix, used for testing purposes.
     *
     * @param customPum A custom PUM for testing
     */
    public PUM(boolean[][] customPum) {
        this.pum = customPum;
    }

    // TODO doc
    public PUM(int[][] lcm, CMV cmv) {
        // Calculates the PUM using provided LCM and provided precalculated CMV
    }


    /**
     * Gets the PUM value on index i,j.
     *
     * @param i row index
     * @param j column index
     */
    public boolean get(int i, int j) {
        return this.pum[i][j];
    }


    /**
     * Gets the number of rows in the PUM.
     */
    public int getNumRows() {
        return this.pum.length;
    }

    /**
     * Gets the number of columns in the PUM.
     */
    public int getNumColumns() {
        return this.pum[0].length;
    }

}
