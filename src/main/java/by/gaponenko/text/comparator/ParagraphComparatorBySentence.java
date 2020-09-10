package by.gaponenko.text.comparator;

import by.gaponenko.text.composite.TextComponent;

import java.util.Comparator;

public class ParagraphComparatorBySentence implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        if (o1.getComponents().size() > o2.getComponents().size()) {
            return 1;
        } else if (o1.getComponents().size() < o2.getComponents().size()) {
            return -1;
        } else {
            return 0;
        }
    }
}
