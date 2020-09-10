package by.gaponenko.text.parser.impl;

import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;
import by.gaponenko.text.composite.impl.TextComposite;
import by.gaponenko.text.parser.PrimeParser;

public class ParagraphParser implements PrimeParser {
    private static final String PARAGRAPH_DELIMITER_REGEX = "\n";

    private PrimeParser sentenceParser;

    public ParagraphParser() {
        sentenceParser = new SentenceParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentText = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = text.strip().split(PARAGRAPH_DELIMITER_REGEX);
        for (String element : paragraphs) {
            TextComponent componentSentence = sentenceParser.parse(element);
            componentText.add(componentSentence);
        }
        return componentText;
    }
}
