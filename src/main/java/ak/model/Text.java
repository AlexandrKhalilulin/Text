package ak.model;

import java.util.ArrayList;
import java.util.List;

public class Text extends AbstractComposite<Paragraph> implements Composite<Paragraph> {

    public Text() {
    }

    @Override
    public String toSourceString() {
        return super.toSourceString();
    }

    @Override
    public void add(Paragraph paragraph) {
        super.add(paragraph);
    }

    @Override
    public List<Word> getWords() {
        List<Word> words = new ArrayList<Word>();
        for (Paragraph list : getElements()) {
            words.addAll(list.getWords());
        }
        return words;
    }

    @Override
    public List<Sentence> getSentences() {
        List<Sentence> sentences = new ArrayList<Sentence>();
        for (Paragraph list : getElements()) {
            sentences.addAll(list.getElements());
        }
        return sentences;
    }

}

