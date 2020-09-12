package test.by.gaponenko.text.interpreter;

import by.gaponenko.text.interpreter.MathInterpreter;
import org.junit.Assert;
import org.junit.Test;

public class MathInterpreterTest {
    @Test
    public void calculateExpressionPositiveTest() {
        String actual = MathInterpreter.calculateExpression("3+2*6");
        String expected = "15";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateExpressionNegativeTest() {
        String actual = MathInterpreter.calculateExpression("7*5+1");
        String expected = "55";
        Assert.assertNotEquals(actual, expected);
    }
}
