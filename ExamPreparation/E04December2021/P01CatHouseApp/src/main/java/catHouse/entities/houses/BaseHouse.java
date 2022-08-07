package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(element -> element.getSoftness()).sum();
    }

    @Override
    public void addCat(Cat cat) {
             if (this.capacity <= cats.size()) {
                 throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
             }

             cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
         cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
         cats.forEach(cat -> cat.eating());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s:", name, BaseHouse.super.getClass().getSimpleName()));
        sb.append("\n");

        if (cats.isEmpty()) {
            sb.append("none").append("\n");
        } else {
            sb.append(String.format("Cats: %s", cats.toString().replaceAll("[\\[\\]],", "")));
            sb.append("/n");
        }

        sb.append(String.format("Toys: %d ", toys.size()));
        sb.append(String.format("Softness: %s", sumSoftness()));

        return sb.toString();
    }
}
