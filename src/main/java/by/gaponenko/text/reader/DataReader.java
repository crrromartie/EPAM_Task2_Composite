package by.gaponenko.text.reader;

import by.gaponenko.text.exception.TextCompositeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class DataReader {
    static Logger logger = LogManager.getLogger();

    public String readData(String filePath) throws TextCompositeException {
        String text;
        try {
            text = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            logger.log(Level.ERROR, "File reading error!", e);
            throw new TextCompositeException("File reading error: " + filePath, e);
        }
        logger.log(Level.INFO, "File read successfully!");
        return text;
    }
}
