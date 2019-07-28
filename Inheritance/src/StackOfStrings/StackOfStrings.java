package StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        if (this.data.isEmpty()) {
            throw new IllegalArgumentException("The stack is empty!");
        }

        int index = this.data.size() - 1;
        String lastString = this.data.get(index);
        this.data.remove(index);
        return lastString;
    }

    public String peek() {
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
