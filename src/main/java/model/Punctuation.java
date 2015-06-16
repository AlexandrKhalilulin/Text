package model;

public class Punctuation extends Part implements Component {
    private StringBuilder punctuation;

    public Punctuation(StringBuilder punctuation) {
        this.punctuation = punctuation;
    }

}
