package by.gaponenko.text.composite;

import java.util.List;

public interface TextComponent {
    void add(TextComponent component);

    void remove(TextComponent component);

    TextComponent getChild(int index);

    TextComponentType getComponentType();

    List<TextComponent> getComponents();
}
