package by.gaponenko.text.interpreter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MathInterpreter {
    static Logger logger = LogManager.getLogger();
    private static final String SCRIPT_ENGINE_NAME = "JavaScript";

    private MathInterpreter() {
    }

    public static String calculateExpression(String mathExpression, int i, int j) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(SCRIPT_ENGINE_NAME);
        scriptEngine.put("i", i);
        scriptEngine.put("j", j);
        String calculatedMathExpression;
        try {
            calculatedMathExpression = scriptEngine.eval(mathExpression).toString();
            logger.log(Level.INFO, "Successful calculate expression: " + mathExpression);
        } catch (ScriptException e) {
            calculatedMathExpression = mathExpression;
            logger.log(Level.ERROR, "Failed calculate expression: " + mathExpression, e);
        }
        return calculatedMathExpression;
    }
}
