package T05Polymorphism.Lab.P03Animals;

public class Cat extends Animal{

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("I am %s and my favourite food is %s", super.getName(), super.getFavouriteFood()));
        sb.append("\n");
        sb.append(String.format("MEEOW"));
        return sb.toString();
    }
}
