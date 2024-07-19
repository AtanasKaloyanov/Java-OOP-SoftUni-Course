package T03Inheritance.Lab.P04StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data = new ArrayList<>();

    public void push(String element) {
        this.data.add(element);
    }

    public String peek() {
        int lastIndex = this.data.size() - 1;
        return this.data.get(lastIndex);
    }

    public String pop() {
        if (this.data.isEmpty()) {
            throw new NullPointerException("The list is empty.");
        }

        int lastIndex = this.data.size() - 1;
        return this.data.remove(lastIndex);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
