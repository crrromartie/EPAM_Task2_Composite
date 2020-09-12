package by.gaponenko.text.composite.impl;

import by.gaponenko.text.composite.SymbolType;
import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.composite.TextComponentType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SymbolLeaf implements TextComponent {
    static Logger logger = LogManager.getLogger();
    private SymbolType symbolType;
    private char value;

    public SymbolLeaf(SymbolType symbol, char value) {
        this.symbolType = symbol;
        this.value = value;
    }

    public SymbolLeaf(SymbolType symbol) {
        this.symbolType = symbol;
    }

    @Override
    public void add(TextComponent component) {
        logger.log(Level.FATAL, "Method is not supported!");
        throw new UnsupportedOperationException("Method is not supported!");
    }

    @Override
    public void remove(TextComponent component) {
        logger.log(Level.FATAL, "Method is not supported!");
        throw new UnsupportedOperationException("Method is not supported!");
    }

    @Override
    public TextComponent getChild(int index) {
        logger.log(Level.FATAL, "Method is not supported!");
        throw new UnsupportedOperationException("Method is not supported!");
    }

    @Override
    public TextComponentType getComponentType() {
        return TextComponentType.SYMBOL;
    }

    @Override
    public List<TextComponent> getComponents() {
        logger.log(Level.FATAL, "Method is not supported!");
        throw new UnsupportedOperationException("Method is not supported!");
    }

    public SymbolType getSymbolType() {
        return symbolType;
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
