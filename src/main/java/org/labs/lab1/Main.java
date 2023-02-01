package org.labs.lab1;

public class Main {

    /**
     * @param args
     * Used to run the LaunchInterceptor with mock data.
     */
    public static void main(String[] args) {

        // Change input here to try out the program
        // Not used for actual testing, see LaunchInterceptorTest instead
        // Data below is the same as for testLaunchInterceptor_Positive_1()
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

        LaunchInterceptor.DECIDE(mockData);
    }
}