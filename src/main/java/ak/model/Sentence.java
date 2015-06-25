package ak.model;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends AbstractComposite<SentencePart> implements Component {

    public Sentence() {
    }

    @Override
    public String toSourceString() {
        return super.toSourceString();
    }

    @Override
    public void add(SentencePart sentencePart) {
        super.add(sentencePart);
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<Word>();
        for (SentencePart list : getElements()) {
            if (list.getClass() == Word.class) words.add((Word) list);
        }
        return words;
    }
}
