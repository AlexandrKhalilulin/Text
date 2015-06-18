package ak;

import ak.logic.Parser;
import ak.model.AbstractComposite;
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
        // logger.info(System.getProperty("user.dir"));
        InputStream loader = ClassLoader.getSystemResourceAsStream("sample.txt");
        InputStreamReader is = new InputStreamReader(loader, "UTF-8");
        BufferedReader reader = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        while (reader.readLine() != null) {
            sb.append(reader.readLine()).append("\n");
        }
        reader.close();
        sb.trimToSize();
        PropertyManager propertyManager = new PropertyManager("parser.properties");
        String property = propertyManager.getProperty("paragraph.regex");
        Parser parser = new Parser();
        parser.configure(property);
        Text text = parser.parseText(sb.toString());
        Class text1 = parser.parse(sb.toString(), Text.class);
        //ak.model.Text text = parser.parseText(sb.toString());
    }
}
