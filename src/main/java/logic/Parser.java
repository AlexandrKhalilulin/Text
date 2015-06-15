package logic;

import org.slf4j.Logger;

import javax.xml.soap.Text;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Logger logger = org.slf4j.LoggerFactory.getLogger(Parser.class);
    public model.Text parse(StringBuilder sb) {
//            for (int i = 0; i < sb.length(); i++) {
//            char ch;
//            ch = sb.charAt(i);
//            logger.info("Correct {} {}",i, sb.charAt(i));
//
//
//        }

        model.Text text = new model.Text(sb);

        return text;
    }


}
