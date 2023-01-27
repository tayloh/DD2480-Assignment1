package org.labs.lab1;

public class LaunchInterceptor {


    /**
     * Decides whether an interceptor should be launched based on
     * input radar tracking information. Prints YES if launch, NO if no launch.
     * @param data all input data: lcm, puv, points, parameters for LICs, etc
     * @return true if launch, false if no launch
     */
    public static boolean DECIDE(InputData data) {

        // Note that none of these are implemented.
        CMV cmv = new CMV(data);
        PUM pum = new PUM(data.LCM, cmv);
        FUV fuv = new FUV(pum, data.PUV);

        // If any condition in the final unlocking vector
        // is false, we don't launch.
        for (int i = 0; i < fuv.getLength(); i++) {
            if (!fuv.get(i)) return false;
            System.out.println("NO");
        }
        System.out.println("YES");
        return true;
    }

}
