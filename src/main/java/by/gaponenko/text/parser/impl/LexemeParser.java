package by.gaponenko.text.parser.impl;

import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;
import by.gaponenko.text.composite.impl.TextComposite;
import by.gaponenko.text.parser.Parser;

public class LexemeParser implements Parser {
    private static final String LEXEME_DELIMITER_REGEX = "\\s";
    private Parser parser;

    public LexemeParser(){
        parser = new SymbolParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentSentence = new TextComposite(TextComponentType.SENTENCE);
        String[] lexemes = text.split(LEXEME_DELIMITER_REGEX);
        for (String element : lexemes) {
            TextComponent componentSymbol = parser.parse(element);
            componentSentence.add(componentSymbol);
        }
        return componentSentence;
    }
}
