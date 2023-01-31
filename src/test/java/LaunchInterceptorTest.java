import org.labs.lab1.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LaunchInterceptorTest {
    
    @Test
    public void testLaunchInterceptor_Positive_1() {

    }

    @Test
    public void testLaunchInterceptor_Positive_2() {

    }

    @Test
    public void testLaunchInterceptor_Negative_1() {

    }

    @Test
    public void testLaunchInterceptor_Negative_2() {

    }

    /**
     * Asserts throw
     * Should throw since number of points < 2
     */
    @Test
    public void testLaunchInterceptor_Invalid_1() {
        InputData mockData = new InputData(
                new double[]{1},
                new double[]{1},
                new String[][] {{"ORR"}},
                new boolean[]{true},
                1,
                1,
                1,
                1,
                0,
                1,
                1,
                2,
                1,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                3
        );

        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptor.DECIDE(mockData));
    }

    /**
     * Asserts throw
     * Should throw since number of points > 100
     */
    @Test
    public void testLaunchInterceptor_Invalid_2() {
        double[] xCoords = new double[101];
        double[] yCoords = new double[101];

        InputData mockData = new InputData(
                xCoords,
                yCoords,
                new String[][] {{"ORR"}},
                new boolean[]{true},
                1,
                1,
                1,
                1,
                0,
                1,
                1,
                2,
                1,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                3
        );

        assertThrows(IllegalArgumentException.class, () -> LaunchInterceptor.DECIDE(mockData));
    }

}
