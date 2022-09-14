import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recipe implements Priceable {

    private String nameOfRecipe;

    private List<WeightedIngredient> weightedIngredient;

    private DatabaseIngredient databaseIngredient;
    public RecipesByDifficulty recipesByDifficulty;

    public Recipe(String nameOfRecipe, List<WeightedIngredient> weightedIngredients) {
        this.nameOfRecipe = nameOfRecipe;
        this.weightedIngredient = new ArrayList<>();
    }

    public Recipe() {
    }

    public String getNameOfRecipe() {
        return nameOfRecipe;
    }

    public List<WeightedIngredient> getWeightedIngredient() {
        return weightedIngredient;
    }

    public void setWeightedIngredient(List<WeightedIngredient> weightedIngredient) {
        this.weightedIngredient = weightedIngredient;
    }

    public void addWeightedIngredient(WeightedIngredient weightedIngredient) {
        this.weightedIngredient.add(weightedIngredient);
    }

    public void removeWeightedIngredient(WeightedIngredient weightedIngredient) {
        for (int i = 0; i < this.weightedIngredient.size(); i++) {
            this.weightedIngredient.remove(weightedIngredient);
        }
    }

    public void getScaledRecipe(double scale) {
        Recipe scaledRecipe = new Recipe(nameOfRecipe, weightedIngredient);
        for (WeightedIngredient ingredient : this.weightedIngredient) {
            scaledRecipe.weightedIngredient.add(new WeightedIngredient(1, ingredient.getNameOfIngredint(), (ingredient.getWeight()*scale)/100, ingredient.getPricePerUnit()));
        }
    }

    public double getNumberOfIngredients() {
        double numberOfIngredients = 0.0;
        for (WeightedIngredient sastojak : weightedIngredient) {
            numberOfIngredients = weightedIngredient.size();
        }
        return numberOfIngredients;
    }

    public void recipeDifficulty(WeightedIngredient ingredient) {
        weightedIngredient.add(ingredient);
        if (weightedIngredient.size() <= 4) {
            recipesByDifficulty = RecipesByDifficulty.BEGINNER;
        } else if (weightedIngredient.size() <= 5) {
            recipesByDifficulty = RecipesByDifficulty.EASY;
        } else if (weightedIngredient.size() <= 6) {
            recipesByDifficulty = RecipesByDifficulty.MEDIUM;
        } else if (weightedIngredient.size() <= 8) {
            recipesByDifficulty = RecipesByDifficulty.HARD;
        } else if (weightedIngredient.size() <= 9) {
            recipesByDifficulty = RecipesByDifficulty.PRO;
        }
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (WeightedIngredient ingredint : weightedIngredient) {
            price += ingredint.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        return "Recipe: " + nameOfRecipe + '\'' + "Ingredients: " + weightedIngredient;
    }

}
