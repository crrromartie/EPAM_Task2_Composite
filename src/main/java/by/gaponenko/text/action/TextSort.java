package by.gaponenko.text.action;

import by.gaponenko.text.comparator.LexemeLengthComparator;
import by.gaponenko.text.comparator.ParagraphComparatorBySentence;
import by.gaponenko.text.comparator.SymbolEntriesLexemeComparator;
import by.gaponenko.text.comparator.WordLengthComparator;
import by.gaponenko.text.composite.TextComponent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TextSort {
    static Logger logger = LogManager.getLogger();

    public List<TextComponent> sortParagraphsByQuantitySentences(TextComponent composite) {
        List<TextComponent> sortedComposite = composite.getComponents();
        sortedComposite.sort(new ParagraphComparatorBySentence());
        logger.log(Level.INFO, "The composite  successfully sorted by the number of sentences in a paragraph!");
        return sortedComposite;
    }

    public List<TextComponent> sortSentencesByLengthLexeme(TextComponent composite) {
        List<TextComponent> sortedComposite = composite.getComponents();
        for (TextComponent paragraph : sortedComposite) {
            List<TextComponent> sentences = paragraph.getComponents();
            sentences.sort(new LexemeLengthComparator());
        }
        logger.log(Level.INFO, "The composite successfully sorted by lexeme length!");
        return sortedComposite;
    }

    public List<TextComponent> sortSentencesByLengthWord(TextComponent composite) {
        List<TextComponent> sortedComposite = composite.getComponents();
        for (TextComponent paragraph : sortedComposite) {
            List<TextComponent> sentences = paragraph.getComponents();
            sentences.sort(new WordLengthComparator());
        }
        logger.log(Level.INFO, "The composite successfully sorted by word length!");
        return sortedComposite;
    }

    public List<TextComponent> sortLexemesBySymbolEntry(TextComponent composite, char symbol) {
        List<TextComponent> sortedComposite = composite.getComponents();
        for (TextComponent paragraph : sortedComposite) {
            List<TextComponent> listSentences = paragraph.getComponents();
            for (TextComponent sentence : listSentences) {
                List<TextComponent> lexemes = sentence.getComponents();
                lexemes.sort(new SymbolEntriesLexemeComparator(symbol));
            }
        }
        logger.log(Level.INFO, "The composite successfully sorted by symbol entry!");
        return sortedComposite;
    }
}
