import javax.xml.crypto.Data;
import java.util.*;

import static java.lang.Double.MAX_VALUE;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<WeightedIngredient> ingredientsFridge = new ArrayList<>();
        Fridge fridge = new Fridge();
        DatabaseRecipes databaseRecipes = new DatabaseRecipes();
        List<Recipe> recipeListFavorites = new ArrayList<>();

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
            System.out.println("5. If you like to make some food from a recipe list");
            System.out.println("6. To check what food you can make for your money");
            System.out.println("7. To check recipes by difficulty");
            System.out.println("8. To check recipes by your money and difficulty");
            System.out.println("9. To sort all recipes by difficulty");
            System.out.println("10. To sort all recipes by price");
            System.out.println("11. Favourite recipes");
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
                                if (fridge.ingredientCheck(ingredientName, fridge.getIngredients())) {
                                    fridge.takeOutIngredients(fridge.getIngredients(), ingredientWeight, ingredientName);
                                }
                                break;
                            case 2:
                                System.out.print("Please enter ingredient name: ");
                                ingredientName = sc.next().toLowerCase();
                                if (fridge.ingredientCheck(ingredientName, fridge.getIngredients())) {
                                    fridge.removeIngredients(ingredientName);
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
                        if (fridge.recipeCheck(recipe1, fridge.getIngredients())) {
                            System.out.println(recipe1.getNameOfRecipe());
                        }
                    }
                    break;

                case 4:
                    boolean case4 = true;
                    while (case4) {
                        System.out.println("Enter for how much you want to scale recipes: ");
                        double scale = sc.nextDouble();
                        for (var recipe1 : databaseRecipes.getRecipe()) {
                            recipe1.getScaledRecipe(scale);
                            if (fridge.recipeCheck(recipe1, fridge.getIngredients())) {
                                System.out.println(recipe1.getNameOfRecipe());
                            }
                        }
                        System.out.println();
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
                    boolean case11 = true;
                    case11:
                    while (case11) {
                        System.out.println("""
                                Type 1. to see favourite recipes,\s
                                Type 2. to add or remove favourite recipes,\s
                                Type 3. to see scaled favoutire recipes.""");
                        input = sc.nextInt();
                        switch (input) {
                            case 1:
                                int x = 0;
                                for (Recipe rec : recipeListFavorites) {
                                    System.out.println((x++) + ". " + rec.getNameOfRecipe());
                                }
                                break;

                            case 2:
                                System.out.println("Type 1. to add favourite recipe, \nType 2. to remove favourite recipe.");
                                input = sc.nextInt();
                                switch (input) {
                                    case 1:
                                        System.out.println("Available recipes are: ");
                                        x = 0;
                                        for (Recipe rec : databaseRecipes.getRecipe()) {
                                            System.out.println((x++) + ". " + rec.getNameOfRecipe());
                                        }
                                        System.out.println("Enter number of recipe you want to add to favorites: ");
                                        input = sc.nextInt();
                                        recipeListFavorites.add(databaseRecipes.getRecipe().get(input));
                                        continue case11;

                                    case 2:
                                        System.out.println("Your favourite recipes are: ");
                                        x = 0;
                                        for (Recipe rec : recipeListFavorites) {
                                            System.out.println((x++) + ". " + rec.getNameOfRecipe());
                                        }
                                        System.out.println("Enter number of recipe you want to remove from favorites: ");
                                        input = sc.nextInt();
                                        recipeListFavorites.remove(recipeListFavorites.get(input));
                                        continue case11;
                                }
                            case 3:
                                boolean case3 = true;
                                while (case3) {
                                    System.out.println("For how much money do you want to make favourite recipes?");
                                    double money = sc.nextDouble();
                                    for (Recipe recipe1 : recipeListFavorites) {
                                        if (recipe1.getPrice() < money) {
                                            System.out.println("You can make: " + recipe1.getNameOfRecipe());
                                        }
                                    }
                                    System.out.print("Do you want to try with more money? Y/N ");
                                    str = sc.next().toUpperCase();
                                    switch (str) {
                                        case "Y":
                                            break;
                                        case "N":
                                            case3 = false;
                                    }
                                }

                                System.out.print("Do you want to see favourite options again? Y/N ");
                                str = sc.next().toUpperCase();
                                switch (str) {
                                    case "Y":
                                        continue case11;
                                    case "N":
                                        case11 = false;
                                }
                        }
                        continue kitchenLabel;
                    }

                case 12:
                    System.out.println(fridge.getIngredients());
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
            }
        }
    }
}
