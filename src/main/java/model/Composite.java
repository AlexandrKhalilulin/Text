package model;

import java.util.List;

public interface Composite<T> extends Component {
    List<T> addChild();
}
