package by.gaponenko.text.parser.impl;

import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;
import by.gaponenko.text.composite.impl.TextComposite;
import by.gaponenko.text.parser.Parser;

public class ParagraphParser implements Parser {
    private static final String PARAGRAPH_DELIMITER_REGEX = "\\n";

    private Parser parser;

    public ParagraphParser() {
        parser = new SentenceParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentText = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = text.split(PARAGRAPH_DELIMITER_REGEX);
        for (String element : paragraphs) {
            TextComponent componentSentence = parser.parse(element);
            componentText.add(componentSentence);
        }
        return componentText;
    }
}
