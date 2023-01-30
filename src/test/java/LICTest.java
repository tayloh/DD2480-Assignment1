package test.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.labs.lab1.LIC;

import static org.junit.jupiter.api.Assertions.*;

public class LICTest {
    @Test
    @DisplayName("Condition 0")
    void condition0(){
        double [] x = {1, 2, 3};
        double [] y = {1, 2, 1};

        assertEquals(true, LIC.condition0(x, y, 1));

        //expected false: distance of 2 is not greater than lenght1 = 2
        assertEquals(false, LIC.condition0(x, y, 2));

        x = new double[]{-1, 3};
        y = new double[]{-1, -1};

        assertEquals(true, LIC.condition0(x, y, 3));
        assertEquals(true, LIC.condition0(x, y, 0));

        //expected false: distance of 4 is not greater than lenght1 = 4
        assertEquals(false, LIC.condition0(x, y, 4));

        //expected false: there is no distance between two consecutive data points to be greater than lenght1
        assertEquals(false, LIC.condition0(new double[]{}, new double[]{}, 0));

        //expected false: there is no distance between two consecutive data points to be greater than lenght1
        assertEquals(false, LIC.condition0(new double[]{2}, new double[]{-3}, 0));
    }

    @Test
    @DisplayName("Condition 1")
    void condition1(){
        //Should give a radius of 0.7071
        double [] x = {0, 0, 1};
        double [] y = {0, 1, 0};

        assertEquals(true, LIC.condition1(x, y, 0.5));

        // expected false: There is three consecutive data points
        // that can all be contained within or on a circle of radius of RADIUS1
        assertEquals(false, LIC.condition1(x, y, 3));

        //Should give a radius of 5
        double [] x2 = {-6, -3, 0};
        double [] y2 = {3, 2, 3};
        assertEquals(true, LIC.condition1(x2, y2, 3));

        // expected false: There is three consecutive data points
        // that can all be contained within or on a circle of radius of RADIUS1
        assertEquals(false, LIC.condition1(x2, y2, 6));

        // all radius are: 1.58, 5 and 1.58
        double [] x3 = {-3, -6, -3, 0, -3};
        double [] y3 = {3, 3, 2, 3, 3};

        // one set of three consecutive data points that cannot all be contained within
        // or on a circle of radius RADIUS1 exists because of (-6,3), (-3,2) and (0,3)
        assertEquals(true, LIC.condition1(x3, y3, 0));
        assertEquals(true, LIC.condition1(x3, y3, 1));
        assertEquals(true, LIC.condition1(x3, y3, 3));
        assertEquals(true, LIC.condition1(x3, y3, 4.99));
        assertEquals(true, LIC.condition1(x3, y3, 4.99999));

        // expected false: There is three consecutive data points
        // that can all be contained within or on a circle of radius of RADIUS1
        assertEquals(false, LIC.condition1(x3, y3, 5));
        assertEquals(false, LIC.condition1(x3, y3, 5000000));

        double [] x4 = {-6, -3};
        double [] y4 = {3, 2};
        // expected false: There is no three consecutive data points
        assertEquals(false, LIC.condition1(x4, y4, 10));
        assertEquals(false, LIC.condition1(x4, y4, 1));
        assertEquals(false, LIC.condition1(new double[]{-2}, new double[]{3}, 10));
        assertEquals(false, LIC.condition1(new double[]{}, new double[]{}, 1));
        assertEquals(false, LIC.condition1(new double[]{-2,-2,-2}, new double[]{3,3,3}, 0));
        assertEquals(false, LIC.condition1(new double[]{-2,-2,-2}, new double[]{3,3,3}, 1));
        assertEquals(false, LIC.condition1(new double[]{-8,-7,-6}, new double[]{3,3,3}, 2));

        assertEquals(true, LIC.condition1(new double[]{-8,-7,-6}, new double[]{3,3,3}, 0.5));
    }
}
