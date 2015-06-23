package ak.model;

import java.util.ArrayList;
import java.util.List;

public class AbstractComposite<E extends Component> implements Composite<E> {
    private List<E> elements = new ArrayList<E>();

    public AbstractComposite(List<E> elements) {
        this.elements = elements;
    }

    public AbstractComposite() {

    }

    public String toSourceString() {
        StringBuilder sb = new StringBuilder();
        for (E element : elements) {
            sb.append(element.toSourceString());
        }
        return sb.toString();
    }

    public void add(E e) {
        elements.add(e);
    }

    public E get(int index) {
        return elements.get(index);
    }

    public List getWords() {
        return null;
    }

    public List getSentences() {
        return null;
    }

    public boolean contains(E e) {
        if (elements.contains(e)) return true;
        else return false;
    }

    public List<E> getElements() {
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractComposite)) return false;

        AbstractComposite<?> that = (AbstractComposite<?>) o;

        return !(elements != null ? !elements.equals(that.elements) : that.elements != null);

    }

    @Override
    public int hashCode() {
        return elements != null ? elements.hashCode() : 0;
    }
}
