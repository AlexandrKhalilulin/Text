package model;

import ak.Servlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Paragraph implements Composite {
    private List<Sentence> sentences;
    Logger logger = LoggerFactory.getLogger(Paragraph.class);

    public Paragraph(StringBuilder paragraph) {
        logger.info(String.valueOf(paragraph));
        List<Sentence> sentences = new ArrayList<Sentence>();

        String regexSentence = ("\\S.+?(\\.|\\!|\\?)");
        Pattern patternSentence = Pattern.compile(regexSentence);
        Matcher matcherSentence = patternSentence.matcher(paragraph);
        while (matcherSentence.find()) {
           StringBuilder stringBuilder = new StringBuilder(matcherSentence.group());
           sentences.add(new Sentence(stringBuilder));
        }

    }

}
