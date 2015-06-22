package ak.logic;

import ak.model.Component;
import ak.model.Composite;
import ak.util.PropertyManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UniversalParser {
    Map<? extends Composite, Set<Class<? extends Component>>> composite = new HashMap<Composite, Set<Class<? extends Component>>>();
    private Map<? extends Composite, String> regexes = new HashMap<Composite, String>();

    public UniversalParser() {
    }

    public <T extends Composite> T parseAllWhatYouWant(String s, Class<T> clazz) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();

        String regex = regexes.get(clazz);
        String[] part = s.split(regex);
        for (String list : part) {
            //        parseAllWhatYouWant(list, )
        }
        return t;
    }

    public void autoconfigure(PropertyManager propertyManager) {

        //regexes.put(, propertyManager.getProperty("ak.model.Paragraph"));
        //regexes.put(ak.model.Sentence, "ak.model.Sentence");

    }
}
