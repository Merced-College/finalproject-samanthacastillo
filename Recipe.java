// Samantha Castillo, Final Programming Project, CPCS-39, 12-04-2025
// *citations at the bottom of code*
import java.util.List;
import java.util.ArrayList; //mycode

public class Recipe { //backend class used to store data
    //declarations
    private String name;
    private String category; //mycode
    private List<String> ingredients; //all items in list are a string
    private List<String> directions;
    private int time;

    //constructors
    public Recipe(String name, List<String> ingredients, String category, int time) { 
        this.name = name;
        this.category = category; //mycode
        this.ingredients = ingredients;
        this.directions = new ArrayList <>(); //mycode
        this.time = time;
    }

    //getters
    public String getName () {
        return name;
    }
    public String getCategory () { //mycode lines 27-28
        return category;
    }
    public List<String> getIngredients () {
        return ingredients;
    }
    public List<String> getDirections () {
        return directions;
    }
    public int getTime () {
        return time;
    }

    public void addDirection(String step) { //adds cooking directions in a list in order
        directions.add(step); //allows you to call to add a step - my code (lines 40-41)
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