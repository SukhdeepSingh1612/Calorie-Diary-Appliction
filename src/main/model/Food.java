package model;

// Food class to create and store food items eaten by the users containing their calorific values and names
// Creates a toString method to display the food intake in a list

import org.json.JSONObject;
import persistence.Writable;

public class Food implements Writable {


    String name;                            // Name of the food
    double calories;                        // Calorific value of the food
    double caloriesleft;                    // the number of calories left with the user in the daily calorie quota

    /*
     * REQUIRES: name of the food with non zero length,calories should be positive
     * MODIFIES: this
     * EFFECTS: Assigns name, calorie input by the user and caloriesleft to food object
     */
    public Food(String name, double calories, double caloriesleft) {
        this.name = name;
        this.calories = calories;
        this.caloriesleft = caloriesleft;
    }
    /*
     * REQUIRES: name of the food with non zero length,calories should be positive
     * EFFECTS: Returns a String to display the food intake of the user in a concise statement
     * with all the relevant information.
     */

    @Override
    public String toString() {
        return " You had " + name + " and it contained "
                + calories + " Calories.";
    }

    /*
     * MODIFIES: this
     * EFFECTS: Creates and initialises json object. loads food components to jsonObject and returns it
     */
    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("calories", calories);
        jsonObject.put("caloriesleft", caloriesleft);
        return jsonObject;
    }
}
