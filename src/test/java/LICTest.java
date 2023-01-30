import org.junit.jupiter.api.DisplayName;
import org.labs.lab1.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LICTest {

    // Proposed naming convention:
    // testLIC0_TypeOfData[Positive/Negative/Invalid]() { ... }

    @Test
    @DisplayName("LIC 7: Test positive cases (returns true/false correctly)")
    void testLIC7_Positive() {
        // Edge case with empty data: no coordinates, all other variables are 0. Should return false
        InputData inputData = new InputData();
        assertFalse(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1, inputData.numPoints));

        // Scenario where two sets of coordinates have dist greater than 4.2: condition met, return true
        inputData.numPoints = 5;
        inputData.kPts = 2;
        inputData.xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        inputData.yCoordinates = new double[] { 0, 1, 2, 3, 4 };
        inputData.length1 = 4.2;
        assertTrue(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1, inputData.numPoints));

        // Increase K_PTS by 1: there still exists a set of coordinates which meets condition from above; (0,0) and (4,4)
        inputData.kPts = 3;
        assertTrue(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1, inputData.numPoints));

        // Case where no set of coordinates with dist > 5 exists (exists with K_PTS = 3)
        inputData.kPts = 2;
        inputData.length1 = 5;
        assertFalse(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1, inputData.numPoints));

        // Not enough points: condition cannot be met since NUMPOINTS < 3
        inputData.numPoints = 2;
        assertFalse(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1, inputData.numPoints));

        // K_PTS is too large, does not meet the condition 1 <= K_PTS <= NUMPOINTS-2
        inputData.numPoints = 5;
        inputData.kPts = 4;
        assertFalse(LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1, inputData.numPoints));
    }

    @Test
    @DisplayName("LIC 7: Test negative cases (check for exceptions)")
    void testLIC7_Negative() {
        InputData inputData = new InputData();

        // NUMPOINTS is greater than the actual number of coordinates: index out of bounds exception
        inputData.numPoints = 10;
        inputData.kPts = 3;
        inputData.xCoordinates = new double[] { 0, 1, 2, 3, 4 };
        inputData.yCoordinates = new double[] { 0, 1, 2, 3, 4 };
        inputData.length1 = 6;
        assertThrows(IndexOutOfBoundsException.class, () -> LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1, inputData.numPoints));

        // Coordinate arrays have a different number of elements: index out of bounds exception
        inputData.numPoints = 5;
        inputData.yCoordinates = new double[] { 0, 1, 2, 3 };
        assertThrows(IndexOutOfBoundsException.class, () -> LIC.condition7(inputData.xCoordinates, inputData.yCoordinates, inputData.kPts, inputData.length1, inputData.numPoints));
    }
}
