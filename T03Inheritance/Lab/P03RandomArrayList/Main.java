package T03Inheritance.Lab.P03RandomArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Creating an instance of class RandomArrayList
        RandomArrayList<String> words = new RandomArrayList<>();
        words.add("A");
        words.add("B");

        // 2. Using the method getRandomElement() and printing:
        String removedWord = words.getRandomElement();
        System.out.println(removedWord);
        System.out.println(words);
    }
}
