package model;

/**
 * Created by Александр on 14.06.2015.
 */
public class LetterOrNumber implements Leaf {
    private char letterOrNumber;

    public LetterOrNumber(char letterOrNumber) {
        this.letterOrNumber = letterOrNumber;
    }
}
