package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence implements Composite {
    private List<Word> words;
    private List<Punctuation> punctuations;
    Logger logger = LoggerFactory.getLogger(Sentence.class);


    public Sentence(StringBuilder paragraph) {
        logger.info(String.valueOf(paragraph));
        List<Word> words = new ArrayList<Word>();
        List<Punctuation> punctuations = new ArrayList<Punctuation>();
        String regexWord = ("\\w+");
        String regexPunctuationMark = ("\\,|\\.|\\!|\\?|\\(|\\)|\\-|\\/|\\++|\\+|\\;|\\:|\\--");
        Pattern patternWord = Pattern.compile(regexWord);
        Pattern patternPunctuation = Pattern.compile(regexPunctuationMark);
        Matcher matcherWord = patternWord.matcher(paragraph);
        Matcher matcherPunctuation = patternPunctuation.matcher(paragraph);
        while (matcherWord.find()){
            StringBuilder stringBuilder = new StringBuilder(matcherWord.group());
            words.add(new Word(stringBuilder));

        }
        while (matcherPunctuation.find())
        {
            StringBuilder stringBuilder = new StringBuilder(matcherPunctuation.group());
            punctuations.add(new Punctuation(stringBuilder));
        }
    }
}
