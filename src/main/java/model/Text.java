package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text implements Component{
    private List<Paragraph> paragraphs;
    Logger logger = LoggerFactory.getLogger(Text.class);

    public Text(StringBuilder text) {
        logger.info(String.valueOf(text));
        List<Paragraph>paragraphs = new ArrayList<Paragraph>();
        String regexParagraph = ("\\S+.+?(\\.|\\!|\\?)\\n");
        Pattern patternParagraph = Pattern.compile(regexParagraph);
        Matcher matcherParagraph = patternParagraph.matcher(text);
        while (matcherParagraph.find()) {
            StringBuilder stringBuilder = new StringBuilder(matcherParagraph.group());
            paragraphs.add(new Paragraph(stringBuilder));

        }


    }

     public List<Paragraph> getParagraphs() {
        return paragraphs;
    }
}

