package by.gaponenko.text.composite.impl;

import by.gaponenko.text.composite.SymbolType;
import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;

import java.util.List;

public class SymbolLeaf implements TextComponent {
    private SymbolType symbolType;
    private char value;

    public SymbolLeaf(SymbolType symbol, char value) {
        this.symbolType = symbol;
        this.value = value;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException("Method is not supported!");
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException("Method is not supported!");
    }

    @Override
    public TextComponent getChild(int index) {
        throw new UnsupportedOperationException("Method is not supported!");
    }

    @Override
    public TextComponentType getComponentType() {
        return TextComponentType.SYMBOL;
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException("Method is not supported!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SymbolLeaf that = (SymbolLeaf) o;

        if (value != that.value) return false;
        return symbolType == that.symbolType;
    }

    @Override
    public int hashCode() {
        int result = symbolType.hashCode();
        result = 31 * result + (int) value;
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
