package ak.model;

import java.util.List;

public interface Composite<E extends Component> extends Component {
    void add(E e);

    E get(int index);

    List getWords();

    List getSentences();
    //E remove(int index);
    // E remove(E e);
    boolean contains(E e);

}
