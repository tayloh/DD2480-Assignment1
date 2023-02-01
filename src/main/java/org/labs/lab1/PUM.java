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

    /**
     * Calculates the PUM from the LCM and CMV.
     * 
     * @param lcm the Logical Connector Matrix
     * @param cmv the Conditions Met Vector
     */
    public PUM(String[][] lcm, CMV cmv) {
        this.pum = new boolean[lcm.length][lcm[0].length];
        for (int i = 0; i < lcm.length; i++)
            for (int j = 0; j < lcm[0].length; j++) {
                if (lcm[i][j].equals("ANDD")) {
                    //System.out.println("" + cmv.get(i) + " AND " + cmv.get(j) + "==" + (cmv.get(i) && cmv.get(j)));
                    this.pum[i][j] = (cmv.get(i) && cmv.get(j));
                } else if (lcm[i][j].equals("ORR")) {
                    this.pum[i][j] = (cmv.get(i) || cmv.get(j));
                } else if (lcm[i][j].equals("NOTUSED")) {
                    this.pum[i][j] = true;
                }
                else {
                    throw new IllegalArgumentException("Invalid LCM value");
                }
            }
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
