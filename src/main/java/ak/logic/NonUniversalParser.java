package ak.logic;

import ak.model.*;
import ak.util.PropertyManager;
import org.slf4j.Logger;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NonUniversalParser {
    Logger logger = org.slf4j.LoggerFactory.getLogger(NonUniversalParser.class);
    private String punctuationRegex;
    private String wordRegex;
    //Map<? extends Composite, Set<Class<? extends Component>>> composite = new HashMap<Composite, Set<Class<? extends Component>>>();
    private Map<String, String> regexes = new HashMap<>();

    public NonUniversalParser() {
    }

    public void autoconfigure(PropertyManager pm) {
        regexes.put(Paragraph.class.getName().toString(), pm.getProperty(Paragraph.class.getName()));
        regexes.put(Sentence.class.getName().toString(), pm.getProperty(Sentence.class.getName()));
        regexes.put(SentencePart.class.getName().toString(), pm.getProperty(SentencePart.class.getName()));
        regexes.put(Word.class.getName().toString(), pm.getProperty(Word.class.getName()));
        punctuationRegex = pm.getProperty("punctuation.regex");
        wordRegex = pm.getProperty("word.regex");

    }

    public <T extends Composite> T parse(String textString, Class<T> CompositeClass) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        T outT = (T) CompositeClass.newInstance();
        ParameterizedType type = (ParameterizedType) CompositeClass.getGenericSuperclass();
        Class ComponentClass = (Class) type.getActualTypeArguments()[0];
        if (!CompositeClass.getName().equals(Sentence.class.getName())) {
            String[] part = textString.split(regexes.get(ComponentClass.getName()));
            for (String list : part) {
                T tmp = (T) ComponentClass.newInstance();
                logger.info(list);
                tmp = (T) parse(list, ComponentClass);
                outT.add(tmp);
                logger.info(outT.toSourceString());
            }
        }

        if (CompositeClass.getName().equals(Sentence.class.getName())) {
            Sentence sentence = new Sentence();
            Pattern patternSentencePart = Pattern.compile(regexes.get(ComponentClass.getName()));
            logger.info(regexes.get(ComponentClass.getName()));
            Matcher matcherSentencePart = patternSentencePart.matcher(textString);
            while (matcherSentencePart.find()) {
                if (matcherSentencePart.group().matches(wordRegex)) {
                    Word word = new Word();
                    for (int i = 0; i < textString.length(); i++) {
                        Symbol symbol = new Symbol(textString.charAt(i));
                        word.add(symbol);
                        sentence.add(word);
                    }
                }
                if (matcherSentencePart.group().matches(punctuationRegex)) {
                    char ch = matcherSentencePart.group().charAt(0);
                    Symbol symbol = new Symbol(ch);
                    sentence.add(symbol);
                }
                logger.info(sentence.toSourceString());
                outT.add(sentence);
            }

        }

        logger.info(outT.toSourceString());
        return outT;
    }
}



