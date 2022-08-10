package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    public Biologist(String name) {
        super(name, 70);
    }

    @Override
    public void breath() {
        double newOxygen = getOxygen() - 5;
        if (newOxygen > 0) {
            setOxygen(newOxygen);
        } else {
            setOxygen(0);
        }
    }
}
