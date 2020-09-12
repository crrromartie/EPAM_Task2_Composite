package test.by.gaponenko.text.reader;

import by.gaponenko.text.exception.TextCompositeException;
import by.gaponenko.text.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataReaderTest {
    DataReader dataReader;

    @BeforeClass
    void setUp() {
        dataReader = new DataReader();
    }

    @Test
    void readDataPositiveTest() throws TextCompositeException {
        String actual = dataReader.readData("src/main/resources/data/test.txt");
        String expected = "It has survived - not only (five) centuries, but also the leap into 18 electronic typesetting.";
        Assert.assertEquals(actual, expected);
    }

    @Test
    void readDataNegativeTest() throws TextCompositeException {
        String actual = dataReader.readData("src/main/resources/data/test.txt");
        String expected = "It has survived.";
        Assert.assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = TextCompositeException.class)
    void readData() throws TextCompositeException {
        dataReader.readData("src/main/resources/dat/text.txt");
    }

    @AfterClass
    void tearDown() {
        dataReader = null;
    }
}
