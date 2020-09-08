package by.gaponenko.text.parser.impl;

import by.gaponenko.text.composite.SymbolType;
import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;
import by.gaponenko.text.composite.impl.SymbolLeaf;
import by.gaponenko.text.composite.impl.TextComposite;
import by.gaponenko.text.parser.Parser;

public class SymbolParser implements Parser {
    private static final String SYMBOL_DELIMITER_REGEX = "";
    private static final String PUNCTUATION_REGEX = "\\.{3}|[.,?!]";

    @Override
    public TextComponent parse(String text) {
        TextComponent componentLexeme = new TextComposite(TextComponentType.LEXEME);
        String[] symbols = text.split(SYMBOL_DELIMITER_REGEX);
        for (String element : symbols) {
            TextComponent componentSymbol;
            if (element.matches(PUNCTUATION_REGEX)) {
                componentSymbol = new SymbolLeaf(SymbolType.PUNCTUATION, element);
            } else {
                componentSymbol = new SymbolLeaf(SymbolType.LETTER, element);
            }
            componentLexeme.add(componentSymbol);
        }
        return componentLexeme;
    }
}
