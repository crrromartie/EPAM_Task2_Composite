package by.gaponenko.text.comparator;

import by.gaponenko.text.composite.SymbolType;
import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.impl.SymbolLeaf;

import java.util.Comparator;
import java.util.List;

public class WordLengthComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return calculateWordsLength(o1) - calculateWordsLength(o2);
    }

    private int calculateWordsLength(TextComponent sentence) {
        int sum = 0;
        List<TextComponent> lexemes = sentence.getComponents();
        for (TextComponent lexeme : lexemes) {
            SymbolLeaf leaf = (SymbolLeaf) (lexeme.getChild(lexeme.toString().strip().length() - 1));
            if (leaf.getSymbolType().equals(SymbolType.PUNCTUATION)) {
                sum += (lexeme.toString().length() - 1);
            } else {
                sum += lexeme.toString().length();
            }
        }
        return sum;
    }
}
