package ak.model;

public class Symbol implements Component, SentencePart {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public String toSourceString() {
        return null;
    }
}
