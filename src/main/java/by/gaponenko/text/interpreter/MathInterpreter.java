package by.gaponenko.text.interpreter;

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

    public static String calculateExpression(String mathExpression) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(SCRIPT_ENGINE_NAME);
        String calculatedMathExpression;
        try {
            calculatedMathExpression = scriptEngine.eval(mathExpression).toString();
            logger.info("Successful calculate expression: " + mathExpression);
        } catch (ScriptException e) {
            calculatedMathExpression = mathExpression;
            logger.error("Failed calculate expression: " + mathExpression, e);
        }
        return calculatedMathExpression;
    }
}
