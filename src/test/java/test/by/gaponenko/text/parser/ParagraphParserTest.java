package test.by.gaponenko.text.parser;

import by.gaponenko.text.exception.TextCompositeException;

import by.gaponenko.text.parser.impl.ParagraphParser;
import by.gaponenko.text.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParagraphParserTest {
    String filePath;
    DataReader dataReader;
    String text;
    ParagraphParser paragraphParser;

    @BeforeClass
    void setUp() throws TextCompositeException {
        dataReader = new DataReader();
        filePath = "src/main/resources/data/test.txt";
        text = dataReader.readData(filePath);
        paragraphParser = new ParagraphParser();
    }

    @Test
    void parsePositiveTest() {
        int actual = paragraphParser.parse(text).getComponents().size();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    void parseNegativeTest() {
        int actual = paragraphParser.parse(text).getComponents().size();
        int expected = 2;
        Assert.assertNotEquals(actual, expected);
    }

    @AfterClass
    void tearDown() {
        filePath = null;
        dataReader = null;
        text = null;
        paragraphParser = null;
    }
}
