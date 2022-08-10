package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar {


    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, 5000);
    }

    @Override
    public boolean isHorsePoweInRange() {
        if (getHorsePower() >= 400 && getHorsePower() <= 600) {
            return true;
        }

        return false;
    }
}



