package ak.logic;

import ak.model.*;
import ak.util.PropertyManager;
import org.slf4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Logger logger = org.slf4j.LoggerFactory.getLogger(Parser.class);
    private String paragraphBorderRegex;
    private String sentenseBorderRegex;
    private String wordRegex;
    private String punctuationRegex;
    private String sentencePartRegex;

    public Parser() {
    }

    public void configure(PropertyManager pm) {
        paragraphBorderRegex = pm.getProperty("paragraphBorder.regex");
        sentenseBorderRegex = pm.getProperty("sentenceBorder.regex");
        wordRegex = pm.getProperty("word.regex");
        punctuationRegex = pm.getProperty("punctuation.regex");
        sentencePartRegex = pm.getProperty("partSentence.regex");
    }

    public Text parseText(String string) {
        Text text = new Text();
        String[] split = string.split(paragraphBorderRegex);
        for (String part : split) {
            logger.info("Paragraph is - {}", part);
            Paragraph paragraph = parseParagraph(part);
            text.add(paragraph);
        }
        return text;
    }

    public Paragraph parseParagraph(String string) {
        Paragraph paragraph = new Paragraph();
        String[] split = string.split(sentenseBorderRegex);
        for (String part : split) {
            logger.info("Sentense is - {}", part);
            Sentence sentence = parseSentence(part);
            paragraph.add(sentence);
        }
        return paragraph;
    }

    private Sentence parseSentence(String string) {
        Sentence sentence = new Sentence();
        Pattern patternSentencePart = Pattern.compile(sentencePartRegex);
        Matcher matcherSentencePart = patternSentencePart.matcher(string);
        while (matcherSentencePart.find()) {
            if (matcherSentencePart.group().matches(wordRegex)) {
                logger.info("Word is - {}", matcherSentencePart.group());
                Word word = parseWord(matcherSentencePart.group());
                sentence.add(word);
            }
            if (matcherSentencePart.group().matches(punctuationRegex)) {
                logger.info("Punctuation is - {}", matcherSentencePart.group());
                char ch = matcherSentencePart.group().charAt(0);
                Symbol symbol = new Symbol(ch);
                sentence.add(symbol);
            }
        }
        return sentence;
    }

    private Word parseWord(String string) {
        Word word = new Word();
        for (int i = 0; i < string.length(); i++) {
            Symbol symbol = new Symbol(string.charAt(i));
            word.add(symbol);
        }
        return word;
    }

    public List<Sentence> parseSample(String s) {
        PropertyManager pr = new PropertyManager("parser.properties");
        String s1 = pr.getProperty("partSentence.regex");
        Pattern patternSample = Pattern.compile(s1);
        Matcher matcherSample = patternSample.matcher(s);
        while (matcherSample.find()) {
            logger.info("Part is - {}", matcherSample.group());

        }
        String[] split = s.split(s1);
        for (int i = 0; i < split.length; i++) {
            logger.info(split[i]);
        }
        return null;
    }
}

