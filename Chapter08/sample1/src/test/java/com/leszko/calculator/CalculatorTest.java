package com.leszko.calculator;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for calculator behavior.
 */
public class CalculatorTest {
     private Calculator calculator = new Calculator();

     @Test
     public void testSum() {
          assertEquals(5, calculator.sum(2, 3));
     }

     @Test
     public void testControllerSum() {
          CalculatorController controller = new CalculatorController();
          ReflectionTestUtils.setField(controller, "calculator", calculator);

          assertEquals("9", controller.sum(4, 5));
     }

     @Test
     public void testHazelcastClientConfig() {
          CalculatorApplication application = new CalculatorApplication();

          assertTrue(application.hazelcastClientConfig()
                    .getNetworkConfig()
                    .getAddresses()
                    .contains("hazelcast"));
     }
}