package by.gaponenko.text.parser.impl;

import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;
import by.gaponenko.text.composite.impl.TextComposite;
import by.gaponenko.text.interpreter.MathInterpreter;
import by.gaponenko.text.parser.PrimeParser;

import java.util.regex.Pattern;

public class LexemeParser implements PrimeParser {
    private static final String LEXEME_DELIMITER_REGEX = "\\s+";
    private static final String REGEX_CALCULATION = "\\p{N}+";
    private PrimeParser symbolParser;

    public LexemeParser() {
        symbolParser = new SymbolParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentSentence = new TextComposite(TextComponentType.SENTENCE);
        String[] lexemes = text.strip().split(LEXEME_DELIMITER_REGEX);
        Pattern pattern = Pattern.compile(REGEX_CALCULATION);
        for (int i = 0; i < lexemes.length; i++) {
            if (pattern.matcher(lexemes[i]).find()) {
                lexemes[i] = MathInterpreter.calculateExpression(lexemes[i]);
            }
        }
        for (String element : lexemes) {
            TextComponent componentSymbol = symbolParser.parse(element);
            componentSentence.add(componentSymbol);
        }
        return componentSentence;
    }
}
