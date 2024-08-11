package T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.models.units;

// P03 Gunner class adding:
public class Gunner extends AbstractUnit {
    private static final int GUNNER_HEALTH = 20;
    private static final int GUNNER_DAMAGE = 20;

    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
