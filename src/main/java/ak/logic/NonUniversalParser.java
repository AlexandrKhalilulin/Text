package ak.logic;

import ak.model.*;
import ak.util.PropertyManager;
import org.slf4j.Logger;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public class NonUniversalParser {
    Logger logger = org.slf4j.LoggerFactory.getLogger(NonUniversalParser.class);
    private String punctuationRegex;
    //Map<? extends Composite, Set<Class<? extends Component>>> composite = new HashMap<Composite, Set<Class<? extends Component>>>();
    private Map<String, String> regexes = new HashMap<String, String>();

    public NonUniversalParser() {
    }

    public <T extends Composite> T parse(String s, Class<T> compositeClass) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        T composite = compositeClass.newInstance();
        ParameterizedType type = (ParameterizedType) compositeClass.getGenericSuperclass();
        Class componentClass = (Class) type.getActualTypeArguments()[0];

        //if (componentClass.getName().equals(SentencePart.class))

        //logger.info(regexes.get(componentClass.getName()));
        String[] part = s.split(regexes.get(componentClass.getName()));
        // logger.info(regexes.get(componentClass.getName()));
        for (String list : part) {
            // logger.info(list.toString());
        }
        return composite;
    }

    public void autoconfigure(PropertyManager pm) {
        regexes.put(Paragraph.class.getName().toString(), pm.getProperty(Paragraph.class.getName()));
        regexes.put(Sentence.class.getName().toString(), pm.getProperty(Sentence.class.getName()));
        regexes.put(SentencePart.class.getName().toString(), pm.getProperty(SentencePart.class.getName()));
        ;
        regexes.put(Word.class.getName().toString(), pm.getProperty(Word.class.getName()));
        punctuationRegex = pm.getProperty("punctuation.regex");
    }
}
