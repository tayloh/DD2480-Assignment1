import org.labs.lab1.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LaunchInterceptorTest {

    /**
     * Asserts true
     * Should return true since all conditions except 13 and 14 are met,
     * which are accounted for by the connectors in the LCM,
     * furthermore, the PUV is fully set to true
     */
    @Test
    public void testLaunchInterceptor_Positive_1() {
        InputData mockData = new InputData(
                new double[]{1, 0, 0,  0, -2},
                new double[]{0, 0, 1, -1,  0},
                new String[][]{
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "NOTUSED"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "ANDD", "ANDD", "ANDD", "ANDD", "NOTUSED", "NOTUSED"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "NOTUSED"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "NOTUSED", "ANDD", "ANDD", "ANDD", "ANDD", "NOTUSED", "NOTUSED"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "NOTUSED"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "NOTUSED"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "NOTUSED", "ANDD", "ANDD", "ANDD", "ANDD", "NOTUSED", "NOTUSED"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "ORR"},
                        {"ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "NOTUSED", "ORR", "NOTUSED", "ANDD", "ANDD", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "ANDD", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "NOTUSED", "ANDD", "NOTUSED", "ANDD", "ANDD", "NOTUSED", "NOTUSED"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ORR", "ORR", "NOTUSED", "ANDD", "ANDD", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "ANDD", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "ORR", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "ORR"}
                },
                new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                1.5,       // length1
                2,              // length2
                1,           // radius1
                0.01,           // radius2
                0,              // epsilon
                0.8,           // area1
                0,              // area2
                2,              // quads
                0.5,           // dist
                1,              // aPts
                1,              // bPts
                1,              // cPts
                1,              // dPts
                1,              // ePts
                1,              // fPts
                2,              // gPts
                2,              // kPts
                5,              // nPts
                5               // qPts
        );

        assertTrue(LaunchInterceptor.DECIDE(mockData));
    }

    /**
     * Asserts true
     * Should return true since PUV is fully set to false
     */
    @Test
    public void testLaunchInterceptor_Positive_2() {
        InputData mockData = new InputData(
                new double[]{0, 1, 0, -1, -1},
                new double[]{0, 0, 0, 1, -1},
                new String[][]{
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                },
                new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                1,       // length1
                2,              // length2
                0.2,           // radius1
                0.2,           // radius2
                0,              // epsilon
                0.3,           // area1
                1,              // area2
                3,              // quads
                3,           // dist
                2,              // aPts
                3,              // bPts
                2,              // cPts
                3,              // dPts
                3,              // ePts
                3,              // fPts
                4,              // gPts
                4,              // kPts
                5,              // nPts
                5               // qPts
        );

        assertTrue(LaunchInterceptor.DECIDE(mockData));

    }

    /**
     * Asserts true
     * Should return true since the LCM only contains NOTUSED connectors
     */
    @Test
    public void testLaunchInterceptor_Positive_3() {

        InputData mockData = new InputData(
                new double[]{0, 1, 0, -1, -1},
                new double[]{0, 0, 0, 1, -1},
                new String[][]{
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                        {"NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED", "NOTUSED"},
                },
                new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                1,       // length1
                2,              // length2
                0.2,           // radius1
                0.2,           // radius2
                0,              // epsilon
                0.3,           // area1
                1,              // area2
                3,              // quads
                3,           // dist
                2,              // aPts
                3,              // bPts
                2,              // cPts
                3,              // dPts
                3,              // ePts
                3,              // fPts
                4,              // gPts
                4,              // kPts
                5,              // nPts
                5               // qPts
        );

        assertTrue(LaunchInterceptor.DECIDE(mockData));
    }

    /**
     * Asserts false
     * Should return false since all connectors in the LCM
     * is ANDD, not all conditions are met, and the PUV does
     * not exclude the umnet conditions
     */
    @Test
    public void testLaunchInterceptor_Negative_1() {

        InputData mockData = new InputData(
                new double[]{0, 1, 0, -1, -1},
                new double[]{0, 0, 0, 1, -1},
                new String[][]{
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                },
                new boolean[]{false, false, false, false, true, true, true, false, false, false, false, true, true, true, true},
                1,       // length1
                2,              // length2
                0.2,           // radius1
                0.2,           // radius2
                0,              // epsilon
                0.3,           // area1
                1,              // area2
                3,              // quads
                3,           // dist
                2,              // aPts
                3,              // bPts
                2,              // cPts
                3,              // dPts
                3,              // ePts
                3,              // fPts
                4,              // gPts
                4,              // kPts
                5,              // nPts
                5               // qPts
        );

        assertFalse(LaunchInterceptor.DECIDE(mockData));
    }

    /**
     * Asserts false
     * Should return false; PUV specifies only one condition as true
     * but that condition is not met
     */
    @Test
    public void testLaunchInterceptor_Negative_2() {
        InputData mockData = new InputData(
                new double[]{0, 1, 0, -1, -1},
                new double[]{0, 0, 0, 1, -1},
                new String[][]{
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                        {"ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD", "ANDD"},
                },
                new boolean[]{true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                10,       // length1
                2,              // length2
                0.2,           // radius1
                0.2,           // radius2
                0,              // epsilon
                0.3,           // area1
                1,              // area2
                3,              // quads
                3,           // dist
                2,              // aPts
                3,              // bPts
                2,              // cPts
                3,              // dPts
                3,              // ePts
                3,              // fPts
                4,              // gPts
                4,              // kPts
                5,              // nPts
                5               // qPts
        );

        assertFalse(LaunchInterceptor.DECIDE(mockData));
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
                new String[][]{{"ORR"}},
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
                new String[][]{{"ORR"}},
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
