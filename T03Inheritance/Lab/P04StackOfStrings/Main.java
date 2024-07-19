package T03Inheritance.Lab.P04StackOfStrings;

public class Main {
    public static void main(String[] args) {
        // 1. Creating an object of the class Stack Of Strings
        // amd checking its methods:
        StackOfStrings sos = new StackOfStrings();
        sos.push("one");
        sos.push("two");
        sos.push("three");

        System.out.println(sos.isEmpty());
        System.out.println(sos.peek());

        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }
}
