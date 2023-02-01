import org.junit.jupiter.api.DisplayName;
import org.labs.lab1.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CMVTest {
    /**
     * Assert true
     * Construct input data which makes LIC 0 true, and check if cmg.get(0) returns true
     */
    @Test
    @DisplayName("CMV Positive: Input data with condition 0 true")
    public void testCMV_Positive_1() {
        InputData inputData = new InputData(new double[] { 0, 1, 3 }, new double[] { 0, 0, 0 },
                new String[][]{}, new boolean[]{}, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 3, 2);
        CMV cmv = new CMV(inputData);
        assertTrue(cmv.get(0));
    }

    /**
     * Assert false
     * Construct input data for which LIC 10 is false (there is one coord set with triangle area 5, but
     * area1 is set to 6). Checks if cmv.get(10) matches this
     *
     */
    @Test
    @DisplayName("CMV Negative: Input data with condition 10 false")
    public void testCMV_Negative_1() {
        InputData inputData = new InputData(new double[] { 0, 1, 3, 4, 5 }, new double[] { 0, 0, 2, 0, 0 },
                new String[][]{}, new boolean[]{}, 1, 1, 1, 1, 1, 6,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 2);
        CMV cmv = new CMV(inputData);
        assertFalse(cmv.get(10));
    }

    /**
     * Assert throw exception
     * Attempt to access CMV element outside the array (LIC 0-14), expect index out of bounds
     */
    @Test
    @DisplayName("CMV Invalid: Trying to access LIC index outside range 0-14")
    public void testCMV_Invalid_1() {
        InputData inputData = new InputData(new double[] { 0, 1, 3 }, new double[] { 0, 0, 0 },
                new String[][]{}, new boolean[]{}, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 2);
        CMV cmv = new CMV(inputData);
        assertThrows(IndexOutOfBoundsException.class, () -> cmv.get(20));
    }
}
