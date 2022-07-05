package T01WorkingWithAbstraction.Lab.PExampleOfEnum;

public enum Season {

    WINTER("Winter", 2.0, "medium"),
    SUMMER("Summer",20.5,"low");


    private String name;
    private double temperature;
    private String chanceForRain;

    Season(String name, double temperature, String chanceForRain) {
        this.name = name;
        this.temperature = temperature;
        this.chanceForRain = chanceForRain;
    }
}
