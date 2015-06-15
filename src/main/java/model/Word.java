package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Word implements Composite {
    private List<Character> letterOrNumbers;
    Logger logger = LoggerFactory.getLogger(Word.class);

    public Word(StringBuilder stringBuilder) {
        List<Character> charachters = new ArrayList<Character>();
        logger.info(String.valueOf(stringBuilder));
        for (int i = 0; i < stringBuilder.length(); i++) {
            charachters.add(stringBuilder.charAt(i));
        }
    }


}
