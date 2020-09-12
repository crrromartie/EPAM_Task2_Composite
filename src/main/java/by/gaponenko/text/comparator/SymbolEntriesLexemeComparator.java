package by.gaponenko.text.comparator;

import by.gaponenko.text.composite.TextComponent;

import java.util.Comparator;
import java.util.List;

public class SymbolEntriesLexemeComparator implements Comparator<TextComponent> {
    private final char symbol;

    public SymbolEntriesLexemeComparator(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int differenceOccurrences = calculateEntriesSymbolInLexeme(o1, symbol)
                - calculateEntriesSymbolInLexeme(o2, symbol);
        if (differenceOccurrences == 0) {
            return new AlphabetComparator().compare(o1, o2);
        }
        return differenceOccurrences;
    }

    private int calculateEntriesSymbolInLexeme(TextComponent lexeme, char symbol) {
        List<TextComponent> symbols = lexeme.getComponents();
        int counter = 0;
        for (TextComponent item : symbols) {
            if (Character.toString(symbol).equals(item.toString())) {
                counter++;
            }
        }
        return counter;
    }
}
