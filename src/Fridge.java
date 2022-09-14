import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Fridge {

    private List<WeightedIngredient> ingredients;

    public Fridge() {
        this.ingredients = new ArrayList<>();
    }


    public List<WeightedIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredient(ArrayList<WeightedIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean ingredientCheck(String nameOfIngredient, ArrayList<WeightedIngredient> ingredientsFridge) {
        for (WeightedIngredient ingredient : ingredientsFridge) {
            if (nameOfIngredient.equals(ingredient.getNameOfIngredint())) {
                return true;
            }
        }
        return false;
    }

    public void addIngredients(WeightedIngredient ingredient, double ingredientWeight) {
        if (ingredients.contains(ingredient)) {
            ingredient.addWeight(ingredient.getWeight(), ingredientWeight);
        } else {
            ingredients.add(ingredient);
        }
    }

    public void removeIngredients(List<WeightedIngredient> ingredients, String ingredientName) {
        for (WeightedIngredient ingredientFridge : ingredients) {
            if (ingredientName.equals(ingredientFridge.getNameOfIngredint())) {
                ingredients.remove(ingredientFridge.getNameOfIngredint());
                System.out.println("You have taken out: " + ingredientFridge.getNameOfIngredint());
            } else {
                System.out.println("Sorry you are all out of: " + ingredientFridge.getNameOfIngredint());
            }
        }
    }

    public void recipeCheck(Recipe recept) {
        if (checkIngredient(recept) == recept.getWeightedIngredient().size()) {
            System.out.println(recept.getNameOfRecipe());
        }
    }

    public int checkIngredient(Recipe recipe) {
        int counter = 0;
        if (recipe != null) {
            for (var ingredient : recipe.getWeightedIngredient()) {
                for (var ingredient1 : this.ingredients)
                    if (ingredient.getNameOfIngredint().equalsIgnoreCase(ingredient1.getNameOfIngredint()) && ingredient.getWeight() <= ingredient1.getWeight()) {
                        counter++;
                    }
            }
        }
        return counter;
    }

    public void takeOutIngredients(List<WeightedIngredient> ingredientinFridge, double ingredientWeight, String nameOfIngredient) {
        for (WeightedIngredient ingredients : ingredientinFridge) {
            String ingredientInFridgeName = ingredients.getNameOfIngredint();
            double ingredientInFridgeWeight = ingredients.getWeight();
            if (ingredientInFridgeName.equals(ingredients.getNameOfIngredint()) && ingredientInFridgeWeight > ingredientWeight) {
                ingredients.removeWeight(ingredientInFridgeWeight, ingredientWeight);
            } else {
                System.out.println("You don't have enough of: " + ingredients.getNameOfIngredint());
            }
        }
    }

    public void takingIngredientsForRecipe(List<WeightedIngredient> ingredientsRecipe, List<WeightedIngredient> ingredientsFridge) {
        for (WeightedIngredient ingredientsFridges : ingredientsFridge) {
            String nameOfngredientFridge = ingredientsFridges.getNameOfIngredint();
            double ingredientWeightFrigde = ingredientsFridges.getWeight();

            for (WeightedIngredient ingredientsRecipes : ingredientsRecipe) {
                String nameOfngredientRecipe = ingredientsRecipes.getNameOfIngredint();
                if (nameOfngredientRecipe.equals(nameOfngredientFridge)) {
                    double ingredientWeightRecipe = ingredientsRecipes.getWeight();
                    nameOfngredientRecipe = ingredientsRecipes.getNameOfIngredint();
                    if (nameOfngredientFridge.equals(nameOfngredientRecipe)) {
                        ingredientsFridges.removeWeight(ingredientWeightFrigde, ingredientWeightRecipe);
                        System.out.println("Good Job, keep on making food!");
                    } else {
                        System.out.println("Sorry you don't have enough ingredients :(");
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Ingredients in fridge: " + ingredients;
    }
}
