package rpg_lab;

import java.util.ArrayList;
import java.util.List;

public class Dummy implements Target {
    private int health;
    private int experience;

    private List<Weapon> lootWeapons = new ArrayList<>();

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    @Override
    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public void addWeapons(List<Weapon> weapons) {
        this.lootWeapons = weapons;
    }

    @Override
    public List<Weapon> getLootWeapons() {
        return this.lootWeapons;
    }

}
