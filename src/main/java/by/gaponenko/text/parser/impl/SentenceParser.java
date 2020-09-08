package by.gaponenko.text.parser.impl;

import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;
import by.gaponenko.text.composite.impl.TextComposite;
import by.gaponenko.text.parser.Parser;

public class SentenceParser implements Parser {
    private static final String SENTENCE_DELIMITER_REGEX = "[.?!]\\s? | [.{3}]\\s?";

    private Parser parser;

    public SentenceParser() {
        parser = new LexemeParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentParagraph = new TextComposite(TextComponentType.PARAGRAPH);
        String[] sentences = text.split(SENTENCE_DELIMITER_REGEX);
        for (String element : sentences) {
            TextComponent componentLexeme = parser.parse(element);
            componentParagraph.add(componentLexeme);
        }
        return componentParagraph;
    }
}
