package rpg_lab;

import java.util.List;

public interface Target {
    int getHealth();
    void takeAttack(int attackPoints);
    int giveExperience();
    boolean isDead();
    List<Weapon> getLootWeapons();
    void addWeapons(List<Weapon> weapons);
}
