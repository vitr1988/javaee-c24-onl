package lesson34.log.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    @Test
    public void testSum() {
        CalculatorService calculatorService = new CalculatorService(1, 0);
        Assertions.assertEquals(1, calculatorService.sum());

        CalculatorService calculatorService2 = new CalculatorService(1, -1);
        Assertions.assertEquals(0, calculatorService2.sum());

        CalculatorService calculatorService3 = new CalculatorService(100500, -100);
        Assertions.assertEquals(100400, calculatorService3.sum());
    }

    @Test
    public void testMinus() {
        CalculatorService calculatorService = new CalculatorService(1, 0);
        Assertions.assertEquals(1, calculatorService.minus());

        CalculatorService calculatorService2 = new CalculatorService(1, -1);
        Assertions.assertEquals(2, calculatorService2.minus());

        CalculatorService calculatorService3 = new CalculatorService(100500, -100);
        Assertions.assertEquals(100600, calculatorService3.minus());
    }

    @Test
    public void testDiv() {
        CalculatorService calculatorService = new CalculatorService(1, 1);
        Assertions.assertEquals(1, calculatorService.div());

        CalculatorService calculatorService2 = new CalculatorService(10, 2);
        Assertions.assertEquals(5, calculatorService2.div());
    }

    @Test
    public void testDivWithException() {
        CalculatorService calculatorService = new CalculatorService(1, 0);
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            calculatorService.div();
        });
        Assertions.assertEquals("/ by zero", thrown.getMessage());
    }
}
