import javax.xml.crypto.Data;
import java.util.*;

import static java.lang.Double.MAX_VALUE;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<WeightedIngredient> ingredientsFridge = new ArrayList<>();
        Fridge fridge = new Fridge();
        Recipe recipe = new Recipe();
        DatabaseRecipes databaseRecipes = new DatabaseRecipes();
        DatabaseIngredient databaseIngredient = new DatabaseIngredient();
        List<Recipe> recipeList = databaseRecipes.getRecipe();
        List<Recipe> recipeListFavorites = new ArrayList<>();

        WeightedIngredient majonez = new WeightedIngredient(20, "majonez", 0.3, 89);
        WeightedIngredient sir = new WeightedIngredient(15, "sir", 0.2, 537);
        WeightedIngredient sunka = new WeightedIngredient(17, "sunka", 0.3, 672);
        WeightedIngredient kackavalj = new WeightedIngredient(16, "kackavalj", 0.05, 679);
        fridge.addIngredients(majonez, 10);
        fridge.addIngredients(sir, 100);
        fridge.addIngredients(sunka, 100);
        fridge.addIngredients(kackavalj, 100);
        ingredientsFridge.add(majonez);
        ingredientsFridge.add(sir);
        ingredientsFridge.add(sunka);
        ingredientsFridge.add(kackavalj);


        boolean run = true;

        kitchenLabel:
        while (run) {
            System.out.println("    Welcome to our kitchen!   ");
            System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");
            System.out.println("Please choose from a menu");
            System.out.println("1. If you like to add ingredients to a fridge");
            System.out.println("2. If you like to take out ingredients from a fridge");
            System.out.println("3. To check what food you can make with available ingredients");
            System.out.println("4. To check if you can make scaled recipes");
            System.out.println("5. If you like to make some food from a recipe list");  // work in progress
            System.out.println("6. To check what food you can make for your money");
            System.out.println("7. To check recipes by difficulty");
            System.out.println("8. To check recipes by your money and difficulty");
            System.out.println("9. To sort all recipes by difficulty");
            System.out.println("10. To sort all recipes by price");
            System.out.println("11. Favourite recipes"); // work in progress
            System.out.println("12. To check all ingredients in fridge");
            System.out.println("0. To exit kitchen");
            System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>");
            int input = sc.nextInt();

            switch (input) {

                case 0:
                    System.out.println("Thanks for using our app.");
                    run = false;
                    break;

                case 1:
                    boolean case1 = true;
                    while (case1) {
                        System.out.println(databaseIngredient.AllIngredients());
                        System.out.println("Please enter ingredient name: ");
                        String ingredientName = sc.next().toLowerCase();
                        System.out.println("Please enter ingredient weight: ");
                        double ingredientWeight = sc.nextDouble();
                        WeightedIngredient newIngredient = new WeightedIngredient(ingredientName, ingredientWeight);
                        fridge.addIngredients(newIngredient, ingredientWeight);
                        ingredientsFridge.add(newIngredient);

                        System.out.print("Do you want to add another ingredient? Y/N ");
                        String str = sc.next().toUpperCase();
                        switch (str) {
                            case "Y":
                                break;
                            case "N":
                                case1 = false;
                        }
                    }
                    continue kitchenLabel;
                case 2:
                    boolean case2 = true;
                    while (case2) {
                        System.out.print("Type 1. to reduce ingredient or type 2 to remove ingredient: ");
                        input = sc.nextInt();
                        switch (input) {
                            case 1:
                                System.out.print("Please enter ingredient name: ");
                                String ingredientName = sc.next().toLowerCase();
                                System.out.print("Please enter ingredient weight: ");
                                double ingredientWeight = sc.nextDouble();
                                databaseIngredient.AllIngredients();
                                if (fridge.ingredientCheck(ingredientName, ingredientsFridge)) {
                                    fridge.takeOutIngredients(ingredientsFridge, ingredientWeight, ingredientName);
                                }
                                break;
                            case 2:
                                System.out.print("Please enter ingredient name: ");
                                ingredientName = sc.next().toLowerCase();
                                if (fridge.ingredientCheck(ingredientName, ingredientsFridge)) {
                                    fridge.removeIngredients(ingredientsFridge, ingredientName);
                                }
                                break;
                        }
                        System.out.print("Do you want to take out another ingredient? Y/N ");
                        String str = sc.next().toUpperCase();
                        switch (str) {
                            case "Y":
                                break;
                            case "N":
                                case2 = false;
                        }
                    }
                    continue kitchenLabel;

                case 3:
                    System.out.println("From available ingredients you can make: ");
                    for (var recipe1 : databaseRecipes.getRecipe()) {
                        fridge.recipeCheck(recipe1);
                    }
                    break;

                case 4:
                    boolean case4 = true;
                    while (case4) {
                        System.out.println("Enter for how much you want to scale recipes: ");
                        double scale = sc.nextDouble();
                        for (var recipe2 : databaseRecipes.getRecipe()) {
                            recipe2.getScaledRecipe(scale);
                        }
                        for (var recipe1 : databaseRecipes.getRecipe()) {
                            fridge.recipeCheck(recipe1);
                        }
                        System.out.print("Do you want to try another scale? Y/N ");
                        String str = sc.next().toUpperCase();
                        switch (str) {
                            case "Y":
                                break;
                            case "N":
                                case4 = false;
                        }
                    }
                    continue kitchenLabel;

                case 5:
                    boolean case5 = true;
                    while (case5) {
                        System.out.println("Please look at out list of recipes. ");
                        int x = 0;
                        for (Recipe recipe1 : databaseRecipes.getRecipe())
                            System.out.println((x++) + ". " + recipe1.getNameOfRecipe());
                        System.out.println("Enter number of a recipe you would like to make: ");
                        x = sc.nextInt();

                        fridge.takingIngredientsForRecipe(databaseRecipes.getRecipe().get(x).getWeightedIngredient(), fridge.getIngredients());
                        System.out.print("Do you want to make another recipe? Y/N ");
                        String str = sc.next().toUpperCase();
                        switch (str) {
                            case "Y":
                                break;
                            case "N":
                                case5 = false;
                        }
                    }
                    continue kitchenLabel;

                case 6:
                    boolean case6 = true;
                    while (case6) {
                        System.out.println("For how much money do you want to make food?");
                        double money = sc.nextDouble();
                        for (Recipe recipe1 : databaseRecipes.getRecipe()) {
                            if (recipe1.getPrice() < money) {
                                System.out.println("You can make: " + recipe1.getNameOfRecipe());
                            }
                        }
                        System.out.print("Do you want to try with more money? Y/N ");
                        String str = sc.next().toUpperCase();
                        switch (str) {
                            case "Y":
                                break;
                            case "N":
                                case6 = false;
                        }
                    }
                    continue kitchenLabel;

                case 7:
                    boolean case7 = true;
                    while (case7) {
                        System.out.println("Difficulty of recipes: ");
                        int counter = 1;
                        for (RecipesByDifficulty level : RecipesByDifficulty.values()) {
                            System.out.println(counter + " : " + level);
                            counter++;
                        }
                        System.out.println("Enter for what difficulty you want recipes: ");
                        input = sc.nextInt();
                        RecipesByDifficulty recipesByDifficulty = null;
                        switch (input) {
                            case 1:
                                recipesByDifficulty = RecipesByDifficulty.BEGINNER;
                                break;
                            case 2:
                                recipesByDifficulty = RecipesByDifficulty.EASY;
                                break;
                            case 3:
                                recipesByDifficulty = RecipesByDifficulty.MEDIUM;
                                break;
                            case 4:
                                recipesByDifficulty = RecipesByDifficulty.HARD;
                                break;
                            case 5:
                                recipesByDifficulty = RecipesByDifficulty.PRO;
                                break;
                        }
                        for (Recipe recipes : databaseRecipes.getRecipe()) {
                            if (recipes.recipesByDifficulty == recipesByDifficulty) {
                                System.out.println(">> " + recipes.getNameOfRecipe());
                            }
                        }
                        System.out.print("Do you want to see another difficulty? Y/N ");
                        String str = sc.next().toUpperCase();
                        switch (str) {
                            case "Y":
                                break;
                            case "N":
                                case7 = false;
                        }
                    }
                    continue kitchenLabel;

                case 8:
                    boolean case8 = true;
                    while (case8) {
                        System.out.println("For how much money do you want to make food?");
                        double money = sc.nextDouble();
                        int counter = 1;
                        for (RecipesByDifficulty level : RecipesByDifficulty.values()) {
                            System.out.println(counter + " : " + level);
                            counter++;
                        }
                        System.out.println("Enter for what difficulty you want recipes: ");
                        input = sc.nextInt();
                        RecipesByDifficulty recipesByDifficulty = null;
                        switch (input) {
                            case 1:
                                recipesByDifficulty = RecipesByDifficulty.BEGINNER;
                                break;
                            case 2:
                                recipesByDifficulty = RecipesByDifficulty.EASY;
                                break;
                            case 3:
                                recipesByDifficulty = RecipesByDifficulty.MEDIUM;
                                break;
                            case 4:
                                recipesByDifficulty = RecipesByDifficulty.HARD;
                                break;
                            case 5:
                                recipesByDifficulty = RecipesByDifficulty.PRO;
                                break;
                        }
                        for (Recipe recipes : databaseRecipes.getRecipe()) {
                            if (recipes.getPrice() <= money && recipes.recipesByDifficulty == recipesByDifficulty) {
                                System.out.println(">> " + recipes.getNameOfRecipe());
                            }
                        }
                        System.out.print("Do you want to try another amount or difficulty? Y/N ");
                        String str = sc.next().toUpperCase();
                        switch (str) {
                            case "Y":
                                break;
                            case "N":
                                case8 = false;
                        }
                    }
                    continue kitchenLabel;

                case 9:
                    System.out.println("Sorted recipes: ");
                    System.out.println(">>> BEGINNER <<<");
                    for (var recipes : databaseRecipes.getRecipe()) {
                        if (recipes.recipesByDifficulty == RecipesByDifficulty.BEGINNER) {
                            System.out.println(recipes.getNameOfRecipe());
                        }
                    }
                    System.out.println(">>> EASY <<<");
                    for (var recipes : databaseRecipes.getRecipe()) {
                        if (recipes.recipesByDifficulty == RecipesByDifficulty.EASY) {
                            System.out.println(recipes.getNameOfRecipe());
                        }
                    }
                    System.out.println(">>> MEDIUM <<<");
                    for (var recipes : databaseRecipes.getRecipe()) {
                        if (recipes.recipesByDifficulty == RecipesByDifficulty.MEDIUM) {
                            System.out.println(recipes.getNameOfRecipe());
                        }
                    }
                    System.out.println(">>> HARD <<<");
                    for (var recipes : databaseRecipes.getRecipe()) {
                        if (recipes.recipesByDifficulty == RecipesByDifficulty.HARD) {
                            System.out.println(recipes.getNameOfRecipe());
                        }
                    }
                    System.out.println(">>> PRO <<<");
                    for (var recipes : databaseRecipes.getRecipe()) {
                        if (recipes.recipesByDifficulty == RecipesByDifficulty.PRO) {
                            System.out.println(recipes.getNameOfRecipe());
                        }
                    }
                    System.out.print("Do you want to go back to kitchen? Y/N ");
                    String str = sc.next().toUpperCase();
                    switch (str) {
                        case "Y":
                            continue kitchenLabel;
                        case "N":
                            run = false;
                            System.out.println("Thanks for using our app.");
                    }
                    break;

                case 10:
                    List<Double> prices = new ArrayList<>();

                    for (Recipe recipe1 : databaseRecipes.getRecipe()) {
                        prices.add(recipe1.getPrice());
                    }
                    Collections.sort(prices);
                    for (double price : prices) {
                        for (Recipe recipe1 : databaseRecipes.getRecipe()) {
                            if (price == recipe1.getPrice()) {
                                System.out.println("Recipe: " + recipe1.getNameOfRecipe() + ", Price: " + price);
                            }
                        }
                    }
                    System.out.print("Do you want to go back to kitchen? Y/N ");
                    str = sc.next().toUpperCase();
                    switch (str) {
                        case "Y":
                            continue kitchenLabel;
                        case "N":
                            run = false;
                            System.out.println("Thanks for using our app.");
                    }
                    break;

                case 11:
                    System.out.println("Available recipes are: ");
                    int x = 1;
                    for (Recipe rec : databaseRecipes.getRecipe()) {
                        System.out.println((x++) + ". " + rec.getNameOfRecipe());
                    }
                    break;

                case 12:
                    System.out.println(ingredientsFridge);
                    System.out.print("Do you want to go back to kitchen? Y/N ");
                    str = sc.next().toUpperCase();
                    switch (str) {
                        case "Y":
                            break;
                        case "N":
                            run = false;
                            System.out.println("Thanks for using our app.");
                    }
                    break;
                case 13:
                    System.out.println(fridge.getIngredients());
                    System.out.println();
                case 14:

            }


        }


    }
}
