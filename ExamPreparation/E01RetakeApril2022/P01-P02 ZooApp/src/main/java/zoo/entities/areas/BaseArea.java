package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public int sumCalories() {
        int sum = 0;

        for (Food food : foods) {
            sum += food.getCalories();
        }

        return sum;
    }

    @Override
    public void addAnimal(Animal animal) {
        if (capacity <= animals.size()) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        this.animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal currentAnimal : animals) {
            currentAnimal.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        //"{areaName} ({areaType}):
        //Animals: {animalName1} {animalName2} {animalName3} (…) / Animals: none
        //Foods: {foodsCount}
        //Calories: {sumCalories}"
        sb.append(String.format("%s (%s):", getName(), getClass().getSimpleName()));
        sb.append(System.lineSeparator());

        if (this.animals.size() == 0) {
            sb.append("Animals: none");
        } else {
            sb.append(String.format("Animals: %s", this.animals.toString().replaceAll("[\\[\\],]", "")));
        }

        sb.append(System.lineSeparator());

        sb.append(String.format("Foods: %d", this.foods.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Calories: %d", sumCalories()));

        return sb.toString().trim();
    }


}


