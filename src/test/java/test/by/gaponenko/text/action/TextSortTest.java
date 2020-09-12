package test.by.gaponenko.text.action;

import by.gaponenko.text.action.TextSort;
import by.gaponenko.text.composite.TextComponent;
import by.gaponenko.text.exception.TextCompositeException;
import by.gaponenko.text.parser.impl.ParagraphParser;
import by.gaponenko.text.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextSortTest {
    String filePath;
    DataReader dataReader;
    ParagraphParser paragraphParser;
    String text;
    TextSort sort;

    @BeforeClass
    void setUp() throws TextCompositeException {
        filePath = "src/main/resources/data/test_sort.txt";
        dataReader = new DataReader();
        text = dataReader.readData(filePath);
        paragraphParser = new ParagraphParser();
        sort = new TextSort();
    }

    @Test
    void sortParagraphsByQuantitySentencesPositiveTest() {
        TextComponent composite = paragraphParser.parse(text);
        String actual = sort.sortParagraphsByQuantitySentences(composite).toString();
        String expected = "[\tBye. , \tThe point of using. A reader will be of a page. , " +
                "\tIt has survived - not only (five) centuries. It is a long established fact. Ipsum is that it has. ]";
        Assert.assertEquals(actual, expected);
    }

    @Test
    void sortParagraphsByQuantitySentencesNegativeTest() {
        TextComponent composite = paragraphParser.parse(text);
        String actual = sort.sortParagraphsByQuantitySentences(composite).toString();
        String expected = "[\tThe point of using. A reader will be of a page. , \tBye. , " +
                "\tIt has survived - not only (five) centuries. It is a long established fact. Ipsum is that it has. ]";
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    void sortSentencesByLengthLexemePositiveTest() {
        TextComponent composite = paragraphParser.parse(text);
        String actual = sort.sortSentencesByLengthLexeme(composite).toString();
        String expected = "[	Ipsum is that it has. It is a long established fact. " +
                "It has survived - not only (five) centuries. , 	" +
                "The point of using. A reader will be of a page. , 	Bye. ]";
        Assert.assertEquals(actual, expected);
    }

    @Test
    void sortSentencesByLengthLexemeNegativeTest() {
        TextComponent composite = paragraphParser.parse(text);
        String actual = sort.sortSentencesByLengthLexeme(composite).toString();
        String expected = "[	It is a long established fact. Ipsum is that it has. Ipsum is that it has. " +
                "It has survived - not only (five) centuries. , 	" +
                "The point of using. A reader will be of a page. , 	Bye. ]";
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    void sortSentencesByLengthWordPositiveTest() {
        TextComponent composite = paragraphParser.parse(text);
        String actual = sort.sortSentencesByLengthLexeme(composite).toString();
        String expected = "[	Ipsum is that it has. It is a long established fact. " +
                "It has survived - not only (five) centuries. , 	" +
                "The point of using. A reader will be of a page. , 	Bye. ]";
        Assert.assertEquals(actual, expected);
    }

    @Test
    void sortSentencesByLengthWordNegativeTest() {
        TextComponent composite = paragraphParser.parse(text);
        String actual = sort.sortSentencesByLengthLexeme(composite).toString();
        String expected = "[	It is a long established fact. Ipsum is that it has. Ipsum is that it has. " +
                "It has survived - not only (five) centuries. , 	" +
                "The point of using. A reader will be of a page. , 	Bye. ]";
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    void sortLexemesBySymbolEntryPositiveTest() {
        TextComponent composite = paragraphParser.parse(text);
        char symbol = 'f';
        String actual = sort.sortLexemesBySymbolEntry(composite, symbol).toString();
        String expected = "[\t- It centuries. has not only survived (five) It a established is long fact. " +
                "Ipsum has. is it that , \tThe point using. of A a be page. reader will of , \tBye. ]";
        Assert.assertEquals(actual, expected);
    }

    @Test
    void sortLexemesBySymbolEntryNegativeTest() {
        TextComponent composite = paragraphParser.parse(text);
        char symbol = 'f';
        String actual = sort.sortLexemesBySymbolEntry(composite, symbol).toString();
        String expected = "[\t- It centuries. survived not only has (five) It a established is long fact. " +
                "Ipsum has. is it that , \tThe point using. of A a be page. reader will of , \tBye. ]";
        Assert.assertNotEquals(actual, expected);
    }

    @AfterClass
    void tearDown() {
        filePath = null;
        dataReader = null;
        paragraphParser = null;
        text = null;
        sort = null;
    }
}
