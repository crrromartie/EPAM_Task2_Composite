package by.gaponenko.text.util;

import by.gaponenko.text.composite.SymbolType;
import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.impl.SymbolLeaf;

import java.util.List;

public class TextComponentCalculator {
    private TextComponentCalculator() {
    }

    public static int calculateLexemesLength(TextComponent sentence) {
        int sum = 0;
        List<TextComponent> lexemes = sentence.getComponents();
        for (TextComponent lexeme : lexemes) {
            sum += lexeme.toString().length();
        }
        return sum;
    }

    public static int calculateWordsLength(TextComponent sentence) {
        int sum = 0;
        List<TextComponent> lexemes = sentence.getComponents();
        for (TextComponent lexeme : lexemes) {
            List<TextComponent> symbols = lexeme.getComponents();
            for (TextComponent symbol : symbols) {
                if (((SymbolLeaf) symbol).getSymbolType().equals(SymbolType.LETTER)
                        || symbol.getComponentType().equals(SymbolType.NUMBER)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static int calculateEntriesSymbolInLexeme(TextComponent lexeme, char symbol) {
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
