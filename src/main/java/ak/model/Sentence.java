package ak.model;

import java.util.List;

public class Sentence extends AbstractComposite<SentencePart> implements Composite<SentencePart> {

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
}
