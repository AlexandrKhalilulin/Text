package ak.logic;

import ak.model.*;
import org.slf4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class TextLogic {
    static Logger logger = org.slf4j.LoggerFactory.getLogger(TextLogic.class);

    //1.find the maximum number of sentences that have the same words.

    //2. Bring all offers of the specified text in ascending order of the number of words in each of them.
    public static void sortTextOrderWords(Text text) {
        TreeMap<Integer, Set<Sentence>> treeMap = new TreeMap<>();

        for (Sentence list : text.getSentences()) {
            Set set = new HashSet<>();
            set.add(list);
            treeMap.put(list.getWords().size(), set);
            logger.info("treemap --- {}", treeMap);
        }

    }

    //3. Find such a word in the first sentence, which is not in any of the other proposals.
    public static void findUniqueWord(Text text) {
        Paragraph paragraph = text.get(0);
        Sentence sentence = paragraph.get(0);
        Boolean flag = null;
        List<Word> wordsAll = text.getWords();
        flag = true;
        Sentence uniqueWords = new Sentence();

        for (Word sentenceWord : sentence.getWords()) {
            Word word = new Word();
            for (int i = sentence.getWords().size(); i < text.getWords().size(); i++)
                if (sentenceWord.toSourceString().equals(wordsAll.get(i).toSourceString())) {
                    flag = false;
                    break;
                }
            if (flag == true) uniqueWords.add(sentenceWord);
            logger.info(sentenceWord.toSourceString());
        }
        for (Word word : uniqueWords.getWords()) {
            logger.info("Unique word is - {}", word.toSourceString());
        }
        if (uniqueWords.getWords().size() == 0) logger.info("No unique words.");
    }

    //4. All interrogative sentences of the text to find and print without repetition of words of a given length.

    //5. In each sentence to swap the first word to the last without changing the length of the sentence.
    public static void swapWords(Text text) {
        Text swapWordText = new Text();
        for (Paragraph paragraph : text.getElements()) {
            Paragraph swapParagraph = new Paragraph();
            for (Sentence sentence : paragraph.getElements()) {
                Word firstWord = new Word();
                Word lastWord = new Word();
                for (SentencePart part : sentence.getElements()) {
                    if (part.getClass() == Word.class) {
                        firstWord = (Word) part;
                        break;
                    }
                }
                for (int i = sentence.getElements().size() - 1; i > -1; i--) {
                    if (sentence.get(i).getClass() == Word.class) {
                        lastWord = (Word) sentence.get(i);
                        sentence.getElements().remove(i);
                        sentence.getElements().add(i, firstWord);
                        break;
                    }
                }
                sentence.getElements().remove(0);
                sentence.getElements().add(0, lastWord);
                swapParagraph.add(sentence);
            }
            swapWordText.add(swapParagraph);
        }
        logger.info(swapWordText.toSourceString());
    }

}
