package T07ReflectionAndAnnotation.Exercise.P05BarracksWarsReturnOfTheDependencies.barracksWars.models.units;

// P03 Horseman class adding:
public class Horseman extends AbstractUnit {
    private static final int HORSEMAN_HEALTH = 50;
    private static final int HORSEMAN_DAMAGE = 10;

    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}
