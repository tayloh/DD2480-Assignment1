package test.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.labs.lab1.LIC;

import static org.junit.jupiter.api.Assertions.*;

public class LICTest {
    @Test
    @DisplayName("Condition 0")
    void condition0(){
        int [] x = {1, 2, 3};
        int [] y = {1, 2, 1};

        assertEquals(true, LIC.condition0(x, y, 1));

        //expected false: distance of 2 is not greater than lenght1 = 2
        assertEquals(false, LIC.condition0(x, y, 2));

        x = new int[]{-1, 3};
        y = new int[]{-1, -1};

        assertEquals(true, LIC.condition0(x, y, 3));
        assertEquals(true, LIC.condition0(x, y, 0));

        //expected false: distance of 4 is not greater than lenght1 = 4
        assertEquals(false, LIC.condition0(x, y, 4));

        //expected false: there is no distance between two consecutive data points to be greater than lenght1
        assertEquals(false, LIC.condition0(new int[]{}, new int[]{}, 0));

        //expected false: there is no distance between two consecutive data points to be greater than lenght1
        assertEquals(false, LIC.condition0(new int[]{2}, new int[]{-3}, 0));
    }
}
