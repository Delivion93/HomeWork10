package Task3;

import java.util.Comparator;

public class Word {
    private String value;
    private int counter;

    public Word(String value, int counter) {
        this.value = value;
        this.counter = counter;
    }

    public String getValue() {
        return value;
    }

    public int getCounter() {
        return counter;
    }
}
