package test.by.gaponenko.text.parser;

import by.gaponenko.text.exception.TextCompositeException;
import by.gaponenko.text.parser.impl.LexemeParser;
import by.gaponenko.text.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LexemeParserTest {
    String filePath;
    String text;
    DataReader dataReader;
    LexemeParser lexemeParser;

    @BeforeClass
    void setUp() throws TextCompositeException {
        lexemeParser = new LexemeParser();
        dataReader = new DataReader();
        filePath = "src/main/resources/data/test.txt";
        text = dataReader.readData(filePath);
    }

    @Test
    void parsePositiveTest() {
        int actual = lexemeParser.parse(text).getComponents().size();
        int expected = 16;
        Assert.assertEquals(actual, expected);
    }

    @Test
    void parseNegativeTest() {
        int actual = lexemeParser.parse(text).getComponents().size();
        int expected = 10;
        Assert.assertNotEquals(actual, expected);
    }

    @AfterClass
    void tearDown() {
        filePath = null;
        text = null;
        dataReader = null;
        lexemeParser = null;
    }
}
