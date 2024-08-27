package rpg_lab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hero implements HeroInventory {
    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> possibleLoot = new ArrayList<>();

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.possibleLoot.addAll(target.getLootWeapons());
        }
    }

    public List<Weapon> getLootWeapons() {
        return this.possibleLoot;
    }

    public class WeaponIterator implements Iterator<Weapon> {
        private int counter;

        @Override
        public boolean hasNext() {
            return this.counter < getLootWeapons().size();
        }

        @Override
        public Weapon next() {
            Weapon weapon = getLootWeapons().get(this.counter);
            this.counter++;
            return weapon;
        }
    }

    @Override
    public Iterable<Weapon> getInventory() {
        return WeaponIterator::new;
    }
}
