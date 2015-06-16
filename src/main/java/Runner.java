import logic.Parser;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Runner {
    public static void main(String[] args) throws IOException {
        Logger logger = org.slf4j.LoggerFactory.getLogger(Runner.class);
        logger.info(System.getProperty("user.dir"));
        InputStream loader = ClassLoader.getSystemResourceAsStream("sample.txt");
        InputStreamReader is = new InputStreamReader(loader, "UTF-8");
        BufferedReader reader = new BufferedReader(is);
        StringBuilder sb = new StringBuilder();
        while (reader.readLine() != null) {
            sb.append(reader.readLine()).append("\n");
        }
        reader.close();
        sb.trimToSize();
        Parser parser = new Parser();
        model.Text text = parser.parse(sb);
        logger.info("Text is - {}", text.toString());

    }
}
