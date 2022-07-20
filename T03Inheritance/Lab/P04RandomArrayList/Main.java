package T03Inheritance.Lab.P04RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add("cat");
        randomArrayList.add("dog");
        randomArrayList.add("rabbit");

        System.out.println(randomArrayList.getRandomElement());
    }
}
