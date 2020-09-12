package test.by.gaponenko.text.parser;

import by.gaponenko.text.exception.TextCompositeException;
import by.gaponenko.text.parser.impl.SentenceParser;
import by.gaponenko.text.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SentenceParserTest {
    String filePath;
    String text;
    DataReader dataReader;
    SentenceParser sentenceParser;

    @BeforeClass
    void setUp() throws TextCompositeException {
        sentenceParser = new SentenceParser();
        dataReader = new DataReader();
        filePath = "src/main/resources/data/test.txt";
        text = dataReader.readData(filePath);
    }

    @Test
    void parsePositiveTest() {
        int actual = sentenceParser.parse(text).getComponents().size();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    void parseNegativeTest() {
        int actual = sentenceParser.parse(text).getComponents().size();
        int expected = 2;
        Assert.assertNotEquals(actual, expected);
    }

    @AfterClass
    void tearDown() {
        filePath = null;
        text = null;
        dataReader = null;
        sentenceParser = null;
    }
}
