package org.labs.lab1;

/**
 * A class for the Final Unlocking Vector (FUV).
 */
public class FUV {

    private boolean[] fuv;


    /**
     * Constructs the Final Unlocking Vector (FUV).
     * @param pum Preliminary Unlocking Matrix (PUM)
     * @param puv Preliminary Unlocking Vector (PUV)
     */
    public FUV(PUM pum, boolean[] puv) {

        if (puv.length != LIC.NUM_CONDITIONS || pum.getRowLength() != LIC.NUM_CONDITIONS) {
            throw new IllegalArgumentException("PUM and PUV sizes are incompatible with the number of conditions.");
        }

        this.fuv = new boolean[LIC.NUM_CONDITIONS];
        // Calculates the FUV using PUM and PUV

        /*
        Specification is ambiguous:
        Assume puv = [true, true, false]

        Says don't consider LIC 2 (it's false) (it actually means don't consider row index 2)
        Says if any element of a row is false -> false (doesn't say whether to consider LIC 2 here)

        lic0 [true, true, false] not full row is true
        lic1 [true, true, true] full row is true
        lic2 [false, false, true] not full row is true, but we shouldn't care about lic2, so it becomes true anyway

        Results:
        -> false (in another interpretation, this would be true)
        -> true
        -> false -> true

        Additionally, it says to ignore the value at i==j (example nr. 3) which results in
        [.      .       .]
        [true, false, true] -> true since if row is 1 we should ignore col value at 1 (see last example in 2.3)
        [.      .       .]
        it also interferes with the statement that "all elements of PUM row i should be true"

        Weird specification, but I think it's part of the assignment for it to be ambiguous.
        */

        for (int i = 0; i < pum.getRowLength(); i++) {

            boolean rowHasAllTrue = true;
            // Check the elements in the row
            for (int j = 0; j < pum.getColumnLength(); j++) {
                // Following the example nr. 3 in 2.3 FUV
                if (i == j) continue;

                // If one element in the row for this condition is false,
                // then the corresponding FUV element is false.
                if (!pum.get(i, j)) {
                    rowHasAllTrue = false;
                    break;
                }
            }

            // If PUV[i] is false, then the corresponding LIC should not be
            // considered when signaling the interceptor launch
            if (!puv[i] || rowHasAllTrue) {
                this.fuv[i] = true;
            }
            else {
                // This is default, but to be explicit...
                this.fuv[i] = false;
            }
        }
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
