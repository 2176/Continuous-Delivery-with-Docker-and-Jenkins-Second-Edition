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

     /**
      * Tests adding two numbers with the calculator.
      */
     @Test
     public void testSum() {
          assertEquals(5, calculator.sum(2, 3));
     }

     /**
      * Tests the calculator controller sum endpoint logic.
      */
     @Test
     public void testControllerSum() {
          CalculatorController controller = new CalculatorController();
          ReflectionTestUtils.setField(controller, "calculator", calculator);

          assertEquals("9", controller.sum(4, 5));
     }

     /**
      * Tests that the Hazelcast client config contains the expected address.
      */
     @Test
     public void testHazelcastClientConfig() {
          CalculatorApplication application = new CalculatorApplication();

          assertTrue(application.hazelcastClientConfig()
                    .getNetworkConfig()
                    .getAddresses()
                    .contains("hazelcast"));
     }
}