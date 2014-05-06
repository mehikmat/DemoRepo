import org.junit.Test;
import test.jaxws.server.impl.CalculatorServiceImpl;

import static org.junit.Assert.*;

/*
 * Service test
 * @author hdhamee
 * @date 5/5/14 4:49 PM
 *
 */
public class CalculatorServiceImplTest {
    @Test
    public void testSumService() {
        CalculatorServiceImpl classUnderTest = new CalculatorServiceImpl();
        assertEquals("30.0",String.valueOf(classUnderTest.mul(5,6)));
    }
}
