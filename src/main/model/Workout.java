package model;


import org.json.JSONObject;
import persistence.Writable;

// Workout class to create and store workouts done by the users containing workout name and calories the user burnt.
// Creates a toString method to display the workout in a list
public class Workout implements Writable {

    String name;                            // Name of the Workout
    double calories;                        // Number of calories burned
    double caloriesleft;                    // the number of calories left with the user in the daily calorie quota

    /*
     * REQUIRES: name of the workout with non zero length,cal should be positive
     * MODIFIES: this
     * EFFECTS: Assigns name, calorie input by the user and caloriesleft to workout object
     */
    public Workout(String name, double calories, double caloriesleft) {
        this.name = name;
        this.calories = calories;
        this.caloriesleft = caloriesleft;
    }
    /*
     * REQUIRES: name of the workout with non zero length,cal should be positive
     * EFFECTS: Returns a String to display the workout done by the user in a concise statement
     * with all the relevant information
     */

    @Override
    public String toString() {
        return " You exercised by means of " + name + ", "
                + " you burned " + calories + " calories.";
    }

    /*
     * MODIFIES: this
     * EFFECTS: Creates and initialises json object. loads workout components to jsonObject and returns it
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
