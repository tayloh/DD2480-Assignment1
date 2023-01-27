package org.labs.lab1;

public class Main {

    /**
     * @param args
     * Used to test the LaunchInterceptor with mockup data.
     */
    public static void main(String[] args) {

        // Temporary empty input data, don't use
        // this constructor for InputData, it's just placeholder.
        InputData madeUpData = new InputData();

        LaunchInterceptor.DECIDE(madeUpData);
    }
}