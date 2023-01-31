import org.labs.lab1.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * A class for testing the Preliminary Unlocking Matrix (PUM).
 */
public class PUMTest {
    /**
     * Tests the PUM constructor.
     * Runs feeds the PUM with a custom LCM and CMV and checks if the PUM contains
     * the expected value.
     * Asserts True if the values are as expected.
     */
    @Test
    public void testPUMConstructor() {
        var testLCM = new String[][] {
                { "ANDD", "ORR" },
                { "ORR", "ANDD" } };
        var testCMV = new CMV(new boolean[] { true, false });
        var testPUM = new PUM(testLCM, testCMV);
        // index 0,0 is true AND true = true
        boolean a = testPUM.get(0, 0);
        // index 0,1 is true OR false = true
        boolean b = testPUM.get(0, 1);
        // index 1,0 is false OR true = true
        boolean c = testPUM.get(1, 0);
        // index 1,1 is false AND false = false
        boolean d = testPUM.get(1, 1);

        var expected = new boolean[] { true, true, true, false };
        var actual = new boolean[] { a, b, c, d };

        assertArrayEquals(expected, actual);
    }
}
