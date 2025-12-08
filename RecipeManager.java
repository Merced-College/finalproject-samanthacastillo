// Samantha Castillo, Final Programming Project, CPCS-39, 12-04-2025
// *citations at the bottom of code*
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap; //mycode
import java.util.Map; //mycode

public class RecipeManager { //back that manages recipes. Provides methods to add/delete, view, and count total recipes.
    //declarations
    private List<Recipe> recipes;
    private Queue<String> directionsQueue; //all items in queue are a string
    private Map<String, Recipe> recipeMap; //all items in map are a string in Recipe

    //constructors
    public RecipeManager() {
        this.recipes = new ArrayList <> ();
        this.recipeMap = new HashMap <>(); 
        this.directionsQueue = new LinkedList <>();
    }

    //search by filtering method
    public List<Recipe> searchByCategory(String category) { //search by recipes category
        List<Recipe> results = recipes.stream() //lists recipes to search categories
        .filter(recipe -> recipe.getCategory().equalsIgnoreCase(category)) //filters by selecting matching ones ignoring charecters 
        .collect(Collectors.toList());
        return results; //returns results after filtering and collecting
    }
    public List<Recipe> searchByName(String name) {  //search by recipe name
        List<Recipe> results = recipes.stream() 
        .filter(recipe -> recipe.getCategory().equalsIgnoreCase(name))
        .collect(Collectors.toList());
        return results;
    }

    public List <Recipe> getRecipes(){ //allows you to access everything in Recipe class in recipe manager
        return recipes;
    }

    //add recipe
    public void addRecipe(Recipe recipe) { 
        recipes.add(recipe); //stores recipe
        recipeMap.put(recipe.getName().toLowerCase(), recipe); //searches by name
    }

    //delete recipe
    public void deleteRecipe (Recipe recipe) { 
        recipes.remove(recipe); //removes recipe
    }
    public void deleteRecipe(String name) {
        Recipe recipe = recipeMap.get(name.toLowerCase()); //finds recipe by name ignoring charecters
        if (recipe != null) {
            recipes.remove(recipe); //removes recipe object from recipe manager               
            recipeMap.remove(name.toLowerCase()); //removes recipe by name
            System.out.println("Recipe '" + name + "' has been deleted.");
        } else {
            System.out.println("Recipe '" + name + "' does not exist.");
        }
    }

    //output recipe
    public void printRecipe (Recipe recipe) { //calls Recipe object and prints data
        System.out.println("Name: " + recipe.getName()); //prints out data stored in Recipe object for name
        System.out.println("Ingredients: " + recipe.getIngredients());
        System.out.println("Category: " + recipe.getCategory());
        System.out.println("Time: " + recipe.getTime() + " minutes");
    }

   //recursion to count all recipes
   public int recipeCounter () { //method for recursion starting at 0
    return recipeCounterCheck (0);
   }
   private int recipeCounterCheck (int i){ //goes through each recipe and adds 1 for each recipe
    if (i == recipes.size()) { 
        return 0; //returns number of recipes
    }
    return 1 + recipeCounterCheck(i + 1); //adds 1 and calls itself again
   }

   //directions for queue
   public void loadDirections (Recipe recipe) { //loads directions from a recipe into a queue
    directionsQueue.addAll(recipe.getDirections()); //adds all directions from list into queue
   }
   public void printNextDirection() { //method to print directions
      if (directionsQueue.isEmpty()) {
        System.out.println("No directions."); //for if there is no directions
      } else {
        System.out.println("• " + directionsQueue.poll()); //prints out directions in order
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