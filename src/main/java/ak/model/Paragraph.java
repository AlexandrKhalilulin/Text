package ak.model;

import java.util.List;

public class Paragraph extends AbstractComposite<Sentence> implements Composite<Sentence> {

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
}
