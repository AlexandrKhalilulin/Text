package logic;

import model.*;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Logger logger = org.slf4j.LoggerFactory.getLogger(Parser.class);

    public Text parse(StringBuilder inputText) {
        return new Text(parseParagraps(inputText));
    }

    public List<Paragraph> parseParagraps(StringBuilder text) {
        List<Paragraph> paragraphs = new ArrayList<Paragraph>();
        String regexParagraph = ("\\S+.+?(\\.|\\!|\\?)\\n");
        Pattern patternParagraph = Pattern.compile(regexParagraph);
        Matcher matcherParagraph = patternParagraph.matcher(text);
        while (matcherParagraph.find()) {
            StringBuilder paragraph = new StringBuilder(matcherParagraph.group());
            logger.info("Paragraph is - {}", paragraph);
            paragraphs.add(new Paragraph(parseSentences(paragraph)));
        }
        return paragraphs;
    }

    public List<Sentence> parseSentences(StringBuilder paragraph) {
        List<Sentence> sentences = new ArrayList<Sentence>();
        String regexSentence = ("\\S.+?(\\.|\\!|\\?)");
        Pattern patternSentence = Pattern.compile(regexSentence);
        Matcher matcherSentence = patternSentence.matcher(paragraph);
        while (matcherSentence.find()) {
            StringBuilder sentence = new StringBuilder(matcherSentence.group());
            logger.info("Sentense is - {}", sentence);
            sentences.add(new Sentence(parseSentenceParts(sentence)));
        }
        return sentences;
    }

    private List<Part> parseSentenceParts(StringBuilder sentence) {
        List<Part> sentenceParts = new ArrayList<Part>();

        String regexWord = ("\\w+");
        String regexPunctuationMark = ("\\,|\\.|\\!|\\?|\\(|\\)|\\-|\\/|\\++|\\+|\\;|\\:|\\--");
        Pattern patternWord = Pattern.compile(regexWord);
        Pattern patternPunctuation = Pattern.compile(regexPunctuationMark);
        Matcher matcherWord = patternWord.matcher(sentence);
        Matcher matcherPunctuation = patternPunctuation.matcher(sentence);
        while (matcherWord.find()) {
            StringBuilder word = new StringBuilder(matcherWord.group());
            logger.info("Word is - {}", word);
            sentenceParts.add(new Word(parseLettersOrNumbers(word)));
        }
        while (matcherPunctuation.find()) {
            StringBuilder punctuation = new StringBuilder(matcherPunctuation.group());
            logger.info("Punctuation is - {}", punctuation);
            sentenceParts.add(new Punctuation(punctuation));
        }

        return sentenceParts;
    }

    private List<Character> parseLettersOrNumbers(StringBuilder word) {
        List<Character> wordParts = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++) {
            wordParts.add(word.charAt(i));
        }
        return wordParts;
    }

}
