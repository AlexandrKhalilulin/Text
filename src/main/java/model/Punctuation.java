package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Александр on 15.06.2015.
 */
public class Punctuation implements Leaf {
    private Character punctuation;

    Logger logger = LoggerFactory.getLogger(Punctuation.class);

    public Punctuation(StringBuilder group) {
        logger.info(String.valueOf(group));
        for (int i = 0; i < group.length(); i++) {

            this.punctuation = group.charAt(i);
        }

    }

}
