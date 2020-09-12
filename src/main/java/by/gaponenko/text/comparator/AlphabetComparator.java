package by.gaponenko.text.comparator;

import by.gaponenko.text.composite.TextComponent;

import java.util.Comparator;

public class AlphabetComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
