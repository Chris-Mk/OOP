package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") &&
                !bakingTechnique.equals("Chewy") &&
                !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double totalCalories = 2 * this.weight;
        switch (this.flourType) {
            case "White" -> totalCalories *= 1.5;
            case "Wholegrain" -> totalCalories *= 1.0;
        }

        switch (this.bakingTechnique) {
            case "Crispy" -> totalCalories *= 0.9;
            case "Chewy" -> totalCalories *= 1.1;
            case "Homemade" -> totalCalories *= 1.0;
        }
        return totalCalories;
    }
}
