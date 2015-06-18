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
    }
}
