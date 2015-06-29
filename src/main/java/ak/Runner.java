package ak;

import ak.logic.NonUniversalParser;
import ak.logic.StandartParser;
import ak.model.Text;
import ak.util.Files;
import ak.util.PropertyManager;
import org.slf4j.Logger;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Logger logger = org.slf4j.LoggerFactory.getLogger(Runner.class);

        PropertyManager propertyManager = new PropertyManager("parser.properties");

        //1. works with Standart parser
        StandartParser standartParser = new StandartParser();
        standartParser.configure(propertyManager);
        Text text = standartParser.parseText(Files.getText());
        logger.info(text.toSourceString());

        //TextLogic.findUniqueWord(text);
        //TextLogic.bringAllSentencesAscendingOrderWords(text);
        //TextLogic.swapWords(text);

        //2. works with Non-Universal parser
        NonUniversalParser nonUniversalParser = new NonUniversalParser();
        nonUniversalParser.autoconfigure(propertyManager);
        //nonUniversalParser.parse(Files.getText(), Text.class);

    }
}
