package org.labs.lab1;

/**
 * A class for the Preliminary Unlocking Matrix (PUM).
 */
public class PUM {

    private boolean[][] pum;

    // TODO doc
    public PUM(int[][] lcm, CMV cmv){
        // Calculates the PUM using provided LCM and provided precalculated CMV
    }


    /**
     * Gets the PUM value on index i,j.
     * @param i row index
     * @param j column index
     */
    public boolean get(int i, int j) {
        // Checks if within bounds for i, j
        // Gets the pum value on position [i][j]
        return true;
    }


    /**
     * Gets the row length of the PUM.
     */
    public int getRowLength(){
        return this.pum.length;
    }

    /**
     * Gets the column length of the PUM.
     */
    public int getColumnLength(){
        return this.pum[0].length;
    }

}
