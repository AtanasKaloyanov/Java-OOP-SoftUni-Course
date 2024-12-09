package T12DesignPatterns.Exercise.P01Singleton;

public class Main {
    public static void main(String[] args) {
        Hashcode hashcode1 = Hashcode.getInstance();
        Hashcode hashcode2 = Hashcode.getInstance();
        Hashcode hashcode3 = Hashcode.getInstance();

        System.out.println(hashcode1.equals(hashcode2));
        System.out.println(hashcode1.equals(hashcode3));
        System.out.println(hashcode2.equals(hashcode3));
    }
}
