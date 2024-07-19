package T03Inheritance.Exercise.P03PlayersAndMonsters.hero;

public class Main {
    public static void main(String[] args) {
        // 1. Instantiation of 8 classes:
        Elf elf = new Elf("E", 1);
        MuseElf museElf = new MuseElf("E2", 2);

        Wizard wizard = new Wizard("W", 3);
        DarkWizard darkWizard = new DarkWizard("D", 4);
        SoulMaster soulMaster = new SoulMaster("S", 5);

        Knight knight = new Knight("K", 6);
        DarkKnight darkKnight = new DarkKnight("DN", 7);
        BladeKnight bladeKnight = new BladeKnight("BK", 8);

        // 2. Printing every instance:
        System.out.println(elf);
        System.out.println(museElf);

        System.out.println(wizard);
        System.out.println(darkWizard);
        System.out.println(soulMaster);

        System.out.println(knight);
        System.out.println(darkKnight);
        System.out.println(bladeKnight);
    }
}
