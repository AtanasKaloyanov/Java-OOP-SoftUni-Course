package zoo.core;

import com.sun.source.tree.LiteralTree;
import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.BaseAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.BaseArea;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.BaseFood;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        foodRepository = new FoodRepositoryImpl();
        areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        BaseArea area;

        switch (areaType) {
            case "WaterArea":
                area = new WaterArea(areaName);
                break;

            case "LandArea":
                area = new LandArea(areaName);
                break;

            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }

        areas.add(area);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        BaseFood food;
        switch (foodType) {
            case "Meat":
                food = new Meat();
                break;

            case "Vegetable":
                food = new Vegetable();
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }

        foodRepository.add(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }

        Area currentArea = areas.stream()
                .filter(a -> a.getName().equals(areaName))
                .findFirst()
                .orElse(null);

        currentArea.addFood(food);
        foodRepository.remove(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;

        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;

            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }
        Area currentArea = areas.stream()
                .filter(a -> a.getName().equals(areaName))
                .findFirst()
                .orElse(null);

        if (currentArea.getCapacity() == currentArea.getAnimals().size()) {
            return ExceptionMessages.NOT_ENOUGH_CAPACITY;
        }

        if ((currentArea instanceof WaterArea && animal instanceof TerrestrialAnimal) ||
                (currentArea instanceof LandArea && animal instanceof AquaticAnimal)) {
            return ConstantMessages.AREA_NOT_SUITABLE;
        }
        
        currentArea.addAnimal(animal);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        Area currentArea = areas.stream()
                .filter(a -> a.getName().equals(areaName))
                .findFirst()
                .orElse(null);

        for (Animal currentAnimal : currentArea.getAnimals()) {
            currentAnimal.eat();
        }

        return String.format(ConstantMessages.ANIMALS_FED, currentArea.getAnimals().size())
                ;
    }

    @Override
    public String calculateKg(String areaName) {
        double sum = 0;

        Area currentArea = areas.stream()
                .filter(a -> a.getName().equals(areaName))
                .findFirst()
                .orElse(null);

        for (Animal currentAnimal : currentArea.getAnimals()) {
            sum += currentAnimal.getKg();
        }

        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Area area : areas) {
            sb.append(area.getInfo());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
