package model;

import java.util.ArrayList;
import java.util.List;

public class Word extends Part implements Composite {
    private List<Character> letterOrNumbers;

    public Word(StringBuilder stringBuilder) {
        List<Character> charachters = new ArrayList<Character>();

        for (int i = 0; i < stringBuilder.length(); i++) {
            charachters.add(stringBuilder.charAt(i));
        }
    }

    public Word(List<Character> letterOrNumbers) {
        this.letterOrNumbers = letterOrNumbers;
    }

    public List<Character> addChild() {

        return null;
    }

    @Override
    public String toString() {
        return "Word{" +
                "letterOrNumbers=" + letterOrNumbers +
                '}';
    }
}
