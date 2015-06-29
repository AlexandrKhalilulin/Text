package ak.logic;

import ak.model.*;
import ak.util.PropertyManager;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StandartParser {
    Logger logger = org.slf4j.LoggerFactory.getLogger(StandartParser.class);
    private Map<String, String> regexes;

    public StandartParser() {
    }

    public Text parseText(String string) {
        Text text = new Text();
        String[] split = string.split(regexes.get("paragraphBorder"));
        for (String part : split) {
            Paragraph paragraph = parseParagraph(part);
            text.add(paragraph);
        }
        return text;
    }

    public Paragraph parseParagraph(String string) {
        Paragraph paragraph = new Paragraph();
        String[] split = string.split(regexes.get("sentenceBorder"));
        for (String part : split) {
            Sentence sentence = parseSentence(part);
            paragraph.add(sentence);
        }
        return paragraph;
    }

    private Sentence parseSentence(String string) {
        Sentence sentence = new Sentence();
        Pattern patternSentencePart = Pattern.compile(regexes.get("sentencePart"));
        Matcher matcherSentencePart = patternSentencePart.matcher(string);
        while (matcherSentencePart.find()) {
            if (matcherSentencePart.group().matches(regexes.get("word"))) {
                Word word = parseWord(matcherSentencePart.group());
                sentence.add(word);
            }
            if (matcherSentencePart.group().matches(regexes.get("punctuation"))) {
                sentence.add(Symbol.of(matcherSentencePart.group().charAt(0)));
            }
        }
        return sentence;
    }

    private Word parseWord(String string) {
        Word word = new Word();
        for (int i = 0; i < string.length(); i++) {
            word.add(Symbol.of(string.charAt(i)));
        }
        return word;
    }

    public void configure(PropertyManager pm) {
        regexes = new HashMap<>();
        regexes.put("paragraphBorder", pm.getProperty("paragraphBorder.regex"));
        regexes.put("sentenceBorder", pm.getProperty("sentenceBorder.regex"));
        regexes.put("word", pm.getProperty("word.regex"));
        regexes.put("punctuation", pm.getProperty("punctuation.regex"));
        regexes.put("sentencePart", pm.getProperty("sentencePart.regex"));
    }
}

