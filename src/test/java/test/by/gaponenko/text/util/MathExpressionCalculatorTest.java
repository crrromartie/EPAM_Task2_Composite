package test.by.gaponenko.text.util;

import org.junit.Assert;
import org.junit.Test;

public class MathExpressionCalculatorTest {
    @Test
    public void calculateExpressionPositiveTest() {
        String actual = by.gaponenko.text.util.MathExpressionCalculator.calculateExpression("3+2*6");
        String expected = "15";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateExpressionNegativeTest() {
        String actual = by.gaponenko.text.util.MathExpressionCalculator.calculateExpression("7*5+1");
        String expected = "55.0";
        Assert.assertNotEquals(actual, expected);
    }
}
