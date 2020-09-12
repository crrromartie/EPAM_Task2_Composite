package test.by.gaponenko.text.parser;

import by.gaponenko.text.exception.TextCompositeException;
import by.gaponenko.text.parser.impl.SymbolParser;
import by.gaponenko.text.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SymbolParserTest {
    String filePath;
    String text;
    DataReader dataReader;
    SymbolParser symbolParser;

    @BeforeClass
    void setUp() throws TextCompositeException {
        symbolParser = new SymbolParser();
        dataReader = new DataReader();
        filePath = "src/main/resources/data/test.txt";
        text = dataReader.readData(filePath);
    }

    @Test
    void parsePositiveTest() {
        int actual = symbolParser.parse(text).getComponents().size();
        int expected = 79;
        Assert.assertEquals(actual, expected);
    }

    @Test
    void parseNegativeTest() {
        int actual = symbolParser.parse(text).getComponents().size();
        int expected = 71;
        Assert.assertNotEquals(actual, expected);
    }

    @AfterClass
    void tearDown() {
        filePath = null;
        text = null;
        dataReader = null;
        symbolParser = null;
    }
}
