package by.gaponenko.text.comparator;

import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.util.TextComponentCalculator;

import java.util.Comparator;

public class SymbolEntriesLexemeComparator implements Comparator<TextComponent> {
    private final char symbol;

    public SymbolEntriesLexemeComparator(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int differenceOccurrences = TextComponentCalculator.calculateEntriesSymbolInLexeme(o1, symbol)
                - TextComponentCalculator.calculateEntriesSymbolInLexeme(o2, symbol);
        if (differenceOccurrences == 0) {
            return new AlphabetComparator().compare(o1, o2);
        }
        return differenceOccurrences;
    }
}
