package T02Encapsulation.Exercise.P04PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    // 1. White or 2. Wholegrain
    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    // 1. Crispy, 2. Chewy, or 3. Homemade
    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy")
                && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }


    // 1.White - 1.5;
    // 2.Wholegrain - 1.0;

    private double flourCoef() {
        double flourCoef = 0;
        switch (this.flourType) {
            case "White":
                flourCoef = 1.5;
                break;
            case "Wholegrain":
                flourCoef = 1.0;
                break;
        }
        return flourCoef;
    }

    // 1. Crispy - 0.9;
    // 2. Chewy - 1.1;
    // 3. Homemade - 1.0;
    private double bakTechCoef() {
        double bakingTechCoeff = 0;
        switch (this.bakingTechnique) {
            case "Crispy":
                bakingTechCoeff = 0.9;
                break;
            case "Chewy":
                bakingTechCoeff = 1.1;
                break;
            case "Homemade":
                bakingTechCoeff = 1;
                break;
        }
        return bakingTechCoeff;
    }

    public double calculateCalories() {
        return 2 * this.weight * flourCoef() * bakTechCoef();
    }
}
