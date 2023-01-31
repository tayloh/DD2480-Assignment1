import org.labs.lab1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputProviderTest {

    /**
     * Test the InputProvider class
     * Runs some sample tests to assert that the LCM holds excpected values
     * Especially asserts that the corners of the matrix are correctly fillied in,
     * as these are filled dynamically in the constructor.
     */
    @Test
    public void testInputProvider() {
        InputProvider inputProvider = new InputProvider();
        var LCM = inputProvider.LCM;

        // some sample tests
        assertEquals("ANDD", LCM[0][0]);
        assertEquals("ANDD", LCM[3][3]);
        assertEquals("ORR", LCM[2][0]);
        assertEquals("ORR", LCM[0][2]);
        assertEquals("NOTUSED", LCM[0][14]);
        assertEquals("NOTUSED", LCM[14][0]);
        assertEquals("NOTUSED", LCM[14][14]);
        assertEquals("NOTUSED", LCM[10][10]);
    }

}
