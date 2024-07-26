package T05Polymorphism.Lab.P03Animals;

public class Dog extends Animal {
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return "I am " +
                super.getName() +
                " and my favourite food is " +
                super.getFavouriteFood() +
                "\n" + "DJAAF";
    }
}
