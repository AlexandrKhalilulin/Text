package ak.model;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends AbstractComposite<Sentence> {

    public Paragraph() {
        super();
    }

    @Override
    public String toSourceString() {
        return super.toSourceString();
    }

    @Override
    public void add(Sentence sentence) {
        super.add(sentence);
    }

    @Override
    public List<Word> getWords() {
        List<Word> words = new ArrayList<Word>();
        for (Sentence list : getElements()) {
            words.addAll(list.getWords());
        }
        return words;
    }

}
