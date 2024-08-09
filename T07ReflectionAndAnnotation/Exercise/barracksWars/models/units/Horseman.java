package barracksWars.models.units;

// P03 new unit
public class Horseman extends AbstractUnit {

    private static final int HORSEMAN_HEALTH = 30;
    private static final int HORSEMAN_DAMAGE = 15;
    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}
