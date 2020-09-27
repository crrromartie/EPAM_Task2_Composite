package by.gaponenko.text.comparator;

import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.util.TextComponentCalculator;

import java.util.Comparator;

public class WordLengthComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return TextComponentCalculator.calculateWordsLength(o1) - TextComponentCalculator.calculateLexemesLength(o2);
    }
}
