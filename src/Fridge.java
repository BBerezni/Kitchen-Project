import java.awt.*;
import java.util.*;
import java.util.List;

public class Fridge {

    private ArrayList<WeightedIngredient> ingredients;

    public Fridge() {
        this.ingredients = new ArrayList<>();
    }

    public ArrayList<WeightedIngredient> getIngredients() {
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

    public void removeIngredients(String ingredientName) {
        for (int i = 0; i < this.ingredients.size(); i++) {
            if (this.ingredients.get(i).getNameOfIngredint().equals(ingredientName.toLowerCase())) {
                ingredients.remove(ingredients.get(i));
                break;
            }
        }
    }

    public boolean recipeCheck(Recipe recipe, ArrayList<WeightedIngredient> ingredientinFridge) {
        for (WeightedIngredient checkRecipe : recipe.getWeightedIngredient()) {
            for (WeightedIngredient checkFridge : ingredientinFridge) {
                if (checkFridge.getNameOfIngredint().equalsIgnoreCase(checkRecipe.getNameOfIngredint()) && checkFridge.getWeight() > checkRecipe.getWeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int checkIngredient(Recipe recipe) {
        int counter = 0;
        if (recipe != null) {
            for (WeightedIngredient ingredient : recipe.getWeightedIngredient()) {
                for (WeightedIngredient ingredient1 : this.ingredients)
                    if (ingredient.getNameOfIngredint().equalsIgnoreCase(ingredient1.getNameOfIngredint()) && ingredient.getWeight() <= ingredient1.getWeight()) {
                        counter++;
                    }
            }
        }
        return counter;
    }

    public void takeOutIngredients(ArrayList<WeightedIngredient> ingredientinFridge, double ingredientWeight, String nameOfIngredient) {
        for (WeightedIngredient ingredients : ingredientinFridge) {
            String ingredientInFridgeName = ingredients.getNameOfIngredint();
            double ingredientInFridgeWeight = ingredients.getWeight();
            if (ingredientInFridgeName.equals(nameOfIngredient) && ingredientInFridgeWeight > ingredientWeight) {
                ingredients.removeWeight(ingredientWeight, ingredientInFridgeWeight);
            } else {
                System.out.println("You don't have enough of: " + ingredients.getNameOfIngredint());
            }
        }
    }

    public void takingIngredientsForRecipe(List<WeightedIngredient> ingredientsRecipe, List<WeightedIngredient> ingredientsFridge) {
        for (WeightedIngredient ingredientsFridges1 : ingredientsFridge) {
            String nameOfngredientFridge = ingredientsFridges1.getNameOfIngredint();
            double ingredientWeightFrigde = ingredientsFridges1.getWeight();

            for (WeightedIngredient ingredientsRecipes : ingredientsRecipe) {
                String nameOfngredientRecipe = ingredientsRecipes.getNameOfIngredint();
                if (nameOfngredientRecipe.equals(nameOfngredientFridge)) {
                    double ingredientWeightRecipe = ingredientsRecipes.getWeight();
                    if (ingredientWeightRecipe <= ingredientWeightFrigde) {
                        ingredientsFridges1.removeWeight(ingredientWeightRecipe, ingredientWeightFrigde);
                        System.out.println("Good Job, keep on making food!");
                    } else {
                        try{
                            ingredientsFridge.remove(ingredientsFridges1);
                        } catch (Exception exception){
                            System.out.println("Sorry you don't have enough ingredients :(");
                        }
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
