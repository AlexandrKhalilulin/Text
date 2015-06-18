package ak.model;

public interface Composite<E extends Component> extends Component {
    void add(E e);
    // E get(int index);
    //E remove(int index);
    // E remove(E e);
    //boolean contains(E e);
    //boolean deepContains(E e);
}
