package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar {

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, 3000);
    }

    @Override
    public boolean isHorsePoweInRange() {
        if (getHorsePower() >= 250 && getHorsePower() <= 450) {
            return true;
        }

        return false;
    }
}
