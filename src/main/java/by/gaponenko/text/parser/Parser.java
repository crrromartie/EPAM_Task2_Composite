package by.gaponenko.text.parser;

import by.gaponenko.text.composite.TextComponent;

public interface Parser {
    TextComponent parse(String text);
}
