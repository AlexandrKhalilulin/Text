package ak.logic;

import ak.model.*;
import ak.util.PropertyManager;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Logger logger = org.slf4j.LoggerFactory.getLogger(Parser.class);
    String regexComponent;

    //   public AbstractComposite parseAbstractComposite (String text, Composite composite)
    //  {
    //    AbstractComposite compositeTT = (AbstractComposite) composite; //new AbstractComposite();
    //      Pattern patternComponent = Pattern.compile(regexComponent);
    //      Matcher matcherComponent = patternComponent.matcher(text);
    //       while (matcherComponent.find()) {

    //          compositeTT.add(new Component(parseAbstractComposite(matcherComponent.group()), );
    //      }
    //      return compositeTT;
    //  }

    public Text parseText(String inputText) {
        Text text = new Text();
        String[] split = inputText.split("\\n");
        for (String part : split) {
            logger.info("Paragraph is - {}", part);
            Paragraph paragraph = parseParagraph(part);
            text.add(paragraph);
        }
        return text;
    }

    public Paragraph parseParagraph(String paragraphInput) {
        Paragraph paragraph = new Paragraph();
        String[] split = paragraphInput.split("(?<=[.?!] )");
        for (String part : split) {
            logger.info("Sentense is - {}", part);
            Sentence sentence = parseSentence(part);
            paragraph.add(sentence);
        }
        return paragraph;
    }

    private Sentence parseSentence(String textString) {
        Sentence sentence = new Sentence();
        String regexWord = ("\\w+");
        String regexPunctuationMark = ("\\,|\\.|\\!|\\?|\\(|\\)|\\-|\\/|\\++|\\+|\\;|\\:|\\--");
        Pattern patternWord = Pattern.compile(regexWord);
        Pattern patternPunctuation = Pattern.compile(regexPunctuationMark);
        Matcher matcherWord = patternWord.matcher(textString);
        Matcher matcherPunctuation = patternPunctuation.matcher(textString);
        while (matcherWord.find()) {
            logger.info("Word is - {}", matcherWord.group());
            Word word = parseWord(matcherWord.group());
            sentence.add(word);
        }
        //while (matcherPunctuation.find()) {
        //   logger.info("Punctuation is - {}", matcherPunctuation.group());
        //   char ch = (char) matcherPunctuation.group();
        //   Symbol symbol = matcherPunctuation.group();
        //   sentence.add(symbol);
        //}
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

    public void configure(String regex) {
        regexComponent = regex;
    }

    public Text parseUni(String s, Class<AbstractComposite> Class) {
        Class compos = new Class<? ??>();
        return null;
    }
}
