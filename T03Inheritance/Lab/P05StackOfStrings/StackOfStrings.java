package T03Inheritance.Lab.P05StackOfStrings;

import java.util.ArrayList;
import java.util.Collections;

public class StackOfStrings {
    private ArrayList<String> data;

    public void push(String item) {
        Collections.reverse(this.data);
        this.data.add(item);
        Collections.reverse(this.data);
    }

    public String pop() {
        return this.data.remove(0);
    }

    public String peek() {
        return this.data.get(0);
    }
}
