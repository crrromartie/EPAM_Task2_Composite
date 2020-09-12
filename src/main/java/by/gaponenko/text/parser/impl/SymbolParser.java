package by.gaponenko.text.parser.impl;

import by.gaponenko.text.composite.SymbolType;
import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;
import by.gaponenko.text.composite.impl.SymbolLeaf;
import by.gaponenko.text.composite.impl.TextComposite;
import by.gaponenko.text.parser.PrimeParser;

public class SymbolParser implements PrimeParser {
    private static final String SYMBOL_DELIMITER_REGEX = "";
    private static final String PUNCTUATION_REGEX = "[\\p{Punct}\\s]";
    private static final String NUMBER_REGEX = "\\d";

    @Override
    public TextComponent parse(String text) {
        TextComponent componentLexeme = new TextComposite(TextComponentType.LEXEME);
        String[] symbols = text.strip().split(SYMBOL_DELIMITER_REGEX);
        for (String element : symbols) {
            SymbolType symbolType;
            if (!element.isBlank()) {
                if (element.matches(PUNCTUATION_REGEX)) {
                    symbolType = SymbolType.PUNCTUATION;
                } else if (element.matches(NUMBER_REGEX)) {
                    symbolType = SymbolType.NUMBER;
                } else {
                    symbolType = SymbolType.LETTER;
                }
                TextComponent component = new SymbolLeaf(symbolType, element.charAt(0));
                componentLexeme.add(component);
            }
        }
        return componentLexeme;
    }
}
