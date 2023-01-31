import org.labs.lab1.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FUVTest {


    /**
     * Asserts true
     * The first element of the FUV should be true since all elements
     * in the first row of the input PUM is true.
     */
    @Test
    public void testFUV_Positive_1() {
        boolean[][] customPumMatrix = {
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
        };

        PUM pum = new PUM(customPumMatrix);

        FUV fuv = new FUV(pum,
                new boolean[] {true, true, true, true, true,
                        true, true, true, true, true,
                        true, true, true, true, true});

        boolean result = fuv.get(0);
        assertTrue(result);
    }

    /**
     * Asserts true
     * The second element of the FUV should be true since
     * the PUV excludes the second condition.
     */
    @Test
    public void testFUV_Positive_2(){
        boolean[][] customPumMatrix = {
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
        };

        PUM pum = new PUM(customPumMatrix);

        // Second element of PUV is false (don't consider that condition)
        FUV fuv = new FUV(pum,
                new boolean[] {true, false, true, true, true,
                        true, true, true, true, true,
                        true, true, true, true, true});

        boolean result = fuv.get(1);
        assertTrue(result);
    }


    /**
     * Asserts false
     * First condition should be false since the PUM
     * contains at least one false element in the first row.
     */
    @Test
    public void testFUV_Negative_1(){
        boolean[][] customPumMatrix = {
                {true, true, true, true, true, false, true, true, true, true, true, true, true, true, true},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
        };

        PUM pum = new PUM(customPumMatrix);

        FUV fuv = new FUV(pum,
                new boolean[] {true, true, true, true, true,
                        true, true, true, true, true,
                        true, true, true, true, true});

        boolean result = fuv.get(0);
        assertFalse(result);
    }


    /**
     * Asserts throw
     * PUV length is not the same as the number of LIC conditions.
     */
    @Test
    public void testFUV_Invalid_1() {
        boolean[][] customPumMatrix = {
                {true, true, true, true, true, false, true, true, true, true, true, true, true, true, true},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
        };

        final PUM pum = new PUM(customPumMatrix);

        final boolean[] puv = new boolean[] {false, true};

        assertThrows(IllegalArgumentException.class, () -> new FUV(pum, puv));

    }

    /**
     * Asserts throw
     * PUM number of rows/columns is not the same as the number
     * of LIC conditions.
     */
    @Test
    public void testFUV_Invalid_2() {
        boolean[][] customPumMatrix = {
                {true, true, true, true, true, false, true, true, true, true, true, true, true, true, true},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false},
                {true, false, false, true, false, true, false, false, true, false, true, false, false , true, false}
        };

        final PUM pum = new PUM(customPumMatrix);

        final boolean[] puv = new boolean[] {false, true};

        assertThrows(IllegalArgumentException.class, () -> new FUV(pum, puv));

    }

}
