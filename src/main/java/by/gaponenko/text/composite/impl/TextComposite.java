package by.gaponenko.text.composite.impl;

import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;

import java.util.LinkedList;
import java.util.List;

public class TextComposite implements TextComponent {
    private static final String LEXEME_DELIMITER = " ";
    private TextComponentType type;
    private List<TextComponent> components;

    public TextComposite(TextComponentType type) {
        this.type = type;
        this.components = new LinkedList<>();
    }

    public void add(TextComponent component) {
        components.add(component);
    }

    public void remove(TextComponent component) {
        components.remove(component);
    }

    public TextComponent getChild(int index) {
        return components.get(index);
    }

    public TextComponentType getComponentType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (type != that.type) return false;
        return components.equals(that.components);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + components.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : components) {
            stringBuilder.append(component.toString());
            if (TextComponentType.LEXEME.equals(component.getComponentType())) {
                stringBuilder.append(LEXEME_DELIMITER);
            }
        }
        return stringBuilder.toString();
    }
}
