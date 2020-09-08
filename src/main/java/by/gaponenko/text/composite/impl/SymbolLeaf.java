package by.gaponenko.text.composite.impl;

import by.gaponenko.text.composite.SymbolType;
import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;

public class SymbolLeaf implements TextComponent {
    private SymbolType symbolType;
    private String value;

    public SymbolLeaf(SymbolType symbol, String value) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SymbolLeaf symbol1 = (SymbolLeaf) o;

        if (symbolType != symbol1.symbolType) return false;
        return value.equals(symbol1.value);
    }

    @Override
    public int hashCode() {
        int result = symbolType.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return value;
    }
}
