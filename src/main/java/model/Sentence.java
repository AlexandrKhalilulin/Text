package model;

import java.util.List;

public class Sentence implements Composite {
    private List<Part> sentenceParts;

    public Sentence(List<Part> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    public List addChild() {
        return null;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentenceParts=" + sentenceParts +
                '}';
    }
}
