package by.gaponenko.text.parser.impl;

import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;
import by.gaponenko.text.composite.impl.TextComposite;
import by.gaponenko.text.parser.PrimeParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements PrimeParser {
    private static final String SENTENCE_REGEX = "[^.!?\\s][^.!?]*(?:[.!?](?!['\\\"]?\\s|$)[^.!?]*)*[.!?]?['\\\"]?(?=\\s|$)";

    private PrimeParser lexemeParser;

    public SentenceParser() {
        lexemeParser = new LexemeParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentParagraph = new TextComposite(TextComponentType.PARAGRAPH);
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        List<String> sentences = new ArrayList<>();
        while (matcher.find()) {
            sentences.add(matcher.group());
        }
        for (String element : sentences) {
            TextComponent componentLexeme = lexemeParser.parse(element);
            componentParagraph.add(componentLexeme);
        }
        return componentParagraph;
    }
}
