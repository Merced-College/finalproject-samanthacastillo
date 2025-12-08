// Samantha Castillo, Final Programming Project, CPCS-39, 12-04-2025
// *citations at the bottom of code*
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; //mycode

public class RecipeApp { //Main class, runs program
    public static void main(String[] args) { 
        RecipeManager manager = new RecipeManager();
        Scanner scanner = new Scanner(System.in); //mycode

        //add recipe
        List<String> ingredients1 = Arrays.asList("1 1/2 cups: flour", "3 1/2 tsp: baking powder", 
        "1 tbsp: white sugar", "1/4 tsp: salt", "1 1/4 cup: milk", "3 tbsp: melted butter", "1: large egg"); //an array list using strings to list ingredients
        String category1 = "Breakfast"; //my code
        Recipe pancakeRecipe = new Recipe("Pancake", ingredients1, category1,
        20); //creates new recipe object by calling Recipe class and stores data in object
        pancakeRecipe.addDirection("Melt Butter"); //adds directions to a recipes list (my code lines 18-20)
        pancakeRecipe.addDirection("mix dry and wet ingredients");
        pancakeRecipe.addDirection("butter pan to cook, flipping until golden");

        List<String> ingredients2 = Arrays.asList("1 lb: spaghetti noodles", "1/2 lb: ground beef", 
        "24 oz: marinara");
        String category2 = "Dinner"; //mycode
        Recipe spaghettiRecipe = new Recipe("Spaghetti", ingredients2, category2, 
        30);
        spaghettiRecipe.addDirection("cook noodles"); //mycode lines 27-30
        spaghettiRecipe.addDirection("cook ground beef");
        spaghettiRecipe.addDirection("drain noodles, add sauce and beef");
        spaghettiRecipe.addDirection("mix");

        List<String> ingredients3 = Arrays.asList ("4 slices: brioche bread", "1: large egg", 
        "1 tsp: vanilla extract", "1/4 cup: milk", "1/2 tsp: cinnamon");
        String category3 = "Breakfast"; //mycode
        Recipe frenchtoastRecipe = new Recipe ("French Toast", ingredients3, category3,
         20);
        frenchtoastRecipe.addDirection("mix wet ingredients"); //mycode(lines 37-39)
        frenchtoastRecipe.addDirection("dip slice of bread in wet ingredients");
        frenchtoastRecipe.addDirection("butter pan to cook, flipping until golden");

        //stores in RecipieManager's recipe object
        manager.addRecipe(pancakeRecipe);
        manager.addRecipe(spaghettiRecipe);
        manager.addRecipe(frenchtoastRecipe);

        //print method for recipes and dirctions
        System.out.println(""); //space to make it easier to read in terminal - my code
        manager.printRecipe(pancakeRecipe); //print recipe and its details by calling it
        System.out.println("Directions: "); //mycode
        manager.loadDirections(pancakeRecipe); //loads directions into queue my code (lines 50-53)
        manager.printNextDirection(); //prints directions from queue in order
        manager.printNextDirection();
        manager.printNextDirection();

        System.out.println(""); //mycode
        manager.printRecipe(spaghettiRecipe);
        System.out.println("Directions: "); //mycode
        manager.loadDirections(spaghettiRecipe); //my code (lines 58-62)
        manager.printNextDirection();
        manager.printNextDirection();
        manager.printNextDirection();
        manager.printNextDirection();

        System.out.println(""); //mycode
        manager.printRecipe(frenchtoastRecipe);
        System.out.println("Directions: "); //mycode
        manager.loadDirections(frenchtoastRecipe); //my code (lines 67-70)
        manager.printNextDirection();
        manager.printNextDirection();
        manager.printNextDirection();

        //recursion output for total number of recipes - my code (lines 73-75)
        System.out.println("");
        System.out.println("You have " + manager.recipeCounter() + 
        " recipes. "); //calls reciperCounter from RecipeManager

        //search by category - my code (lines 78-93)
        System.out.println("\nSearching for category..");
        String searchByCategory = "Breakfast"; //looking for breakfast
        boolean found = false;

        for (Recipe r : manager.getRecipes()) { //iterartes through each recipe w/ temp variable until categroy found
            if (r.getCategory().equalsIgnoreCase(searchByCategory)) { //ignores case so "breakfast" = "Breakfast"
                found = true;
                break; //if found breaks, stops searching
            }
        }

        if (found) { //if statement for boolean to indicate if found or not
            System.out.println(searchByCategory + " found.");
        } else {
            System.out.println(searchByCategory + "not found");
        }

        //user input for recipe deletion - my code (lines 96-106)
        System.out.println(""); //space to read easy on terminal
        System.out.println("Would you like to delete a recipe?");
        String answer = scanner.nextLine(); //user input for yes or no

        if (answer.equalsIgnoreCase("yes")) { //if statment to determine deletion
            System.out.println("What recipe do you want to delete?");
            String deleteName = scanner.nextLine();
            manager.deleteRecipe (deleteName); //deletes recipe by name
        }
        else { 
            System.out.println("no recipe will be deleted"); //any answer thats not "yes" outputs this
        }
    }
}
/*
///////////// CITATIONS /////////////
- Author name: Open AI (Chat Gpt)
- Date: 12-01-2025
- Title: Chat GPT-5mini
- Source: https://chatgpt.com/
-
- Author name: Code Grindz
- Date: 4-07-2023
- Title of program/source code : JAVA IN MINUTES - How to code a Recipe App in *4 MINUTES*
- Web address or publisher: https://youtu.be/rVyLERMknoE?si=uNR5IOHy0uUrGWnC
-
- Author name: Alex Lee
- Date: 8-01-2019
- title of program: BBQ - Queue in Java Tutorial #66
- web address: https://www.youtube.com/watch?v=91CMnJeHJVc
-
- Author name: Bro Code
- Date: 04-12-2025
- title of program: Learn Queue data structures in 10 minutes
- web address: https://www.youtube.com/watch?v=nqXaPZi99JI
-
- Author name: vlogize
- Date: 07-22-2025
- title of program: Counting the Occurrences of yo in a String Using Recursion in Java
- web address: https://www.youtube.com/watch?v=X6fi6izm9UA
 */