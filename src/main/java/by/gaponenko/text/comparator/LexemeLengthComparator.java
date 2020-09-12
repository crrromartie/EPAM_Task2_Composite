package by.gaponenko.text.comparator;

import by.gaponenko.text.composite.TextComponent;

import java.util.Comparator;
import java.util.List;

public class LexemeLengthComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return calculateLexemesLength(o1) - calculateLexemesLength(o2);
    }

    private int calculateLexemesLength(TextComponent sentence) {
        int sum = 0;
        List<TextComponent> lexemes = sentence.getComponents();
        for (TextComponent lexeme : lexemes) {
            sum += lexeme.toString().length();
        }
        return sum;
    }
}
