package barracksWars.models.units;

// P03 new unit
public class Gunner extends AbstractUnit {
    private static final int GUNNER_HEALTH = 30;
    private static final int GUNNER_DAMAGE = 15;
    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
