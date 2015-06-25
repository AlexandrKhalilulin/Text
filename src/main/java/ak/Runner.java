package ak;

import ak.logic.EasyParser;
import ak.logic.NonUniversalParser;
import ak.model.Text;
import ak.util.PropertyManager;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Runner {
    public static void main(String[] args) throws IOException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Logger logger = org.slf4j.LoggerFactory.getLogger(Runner.class);
        InputStream loader = ClassLoader.getSystemResourceAsStream("sample.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(loader, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (reader.readLine() != null) {
            sb.append(reader.readLine()).append("\n");
        }
        reader.close();
        sb.trimToSize();

        PropertyManager propertyManager = new PropertyManager("parser.properties");
        EasyParser easyParser = new EasyParser();
        easyParser.configure(propertyManager);
        Text text = easyParser.parseText(sb.toString());
        logger.info(text.toSourceString());

        //TextLogic.findUniqueWord(text);
        //TextLogic.bringAllSentencesAscendingOrderWords(text);
        //TextLogic.swapWords(text);

        NonUniversalParser nonUniversalParser = new NonUniversalParser();
        nonUniversalParser.autoconfigure(propertyManager);
        nonUniversalParser.parse(sb.toString(), Text.class);



    }
}
