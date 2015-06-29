package ak.model;

import java.util.HashMap;
import java.util.Map;

public class Symbol implements Leaf, SentencePart {
    private static Map<Character, Symbol> symbolMap = new HashMap<>();
    private Character value;

    public Symbol() {
    }

    public Symbol(Character symbol) {
        this.value = symbol;
    }

    public static Symbol of(Character ch) {
        Symbol symbol = symbolMap.get(ch);
        if (symbol == null) {
            symbol = new Symbol(ch);
            symbolMap.put(ch, symbol);
            return symbol;
        }
        return symbol;
    }

    @Override
    public String toSourceString() {
        return value.toString();
    }
}
