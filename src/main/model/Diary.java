package model;


import exceptions.DataNotFilled;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;
// Class represents a Diary containing, user name, weight, height and age.
// Diary consists of two lists( food and workout) to log users food intake and workout regime

public class Diary implements Writable {
    public List<Food> food;                       //Food log list for the user
    public List<Workout> workout;                 //Workout log list for the user
    private Food f1;
    private Workout w1;
    private boolean dataFilled = false;

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private double height = 0;                           //height of the user
    private double weight = 0;                          //weight of the user
    private double bodyMassIndex;                   // BMI of the user
    private String name = null;                            //name of the user
    private int age = 0;                                //age of the user
    private double maintenanceCalories2;            // maintenance calories of the user
    public double calorieLeft;                      //Calories left for the user to consume


    /*
     * REQUIRES: Height is in metres and has a positive value,Name has a non zero length,
     *  weight is in Kgs and is positive value,Age is in years and is positive value.
     * MODIFIES: this
     * EFFECTS: Assigns name,weight,height and age input by the user to create a diary for the user
     */
    public Diary(String name, double height, double weight, int age) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.food = new ArrayList<Food>();
        this.workout = new ArrayList<Workout>();
        this.bodyMassIndex = weight / (height * height);
        this.maintenanceCalories2 = (((10 * weight) + (6.25 * height * 100) - (5 * age) + 5) * 1.2);
        this.calorieLeft = maintenanceCalories2;
        this.dataFilled = true;
    }

    /*
     * MODIFIES: this
     * EFFECTS: Assigns empty values to create a diary for the user
     */
    public Diary() {
        this.name = "";
        this.height = 0;
        this.weight = 0;
        this.age = 0;
        this.food = new ArrayList<Food>();
        this.workout = new ArrayList<Workout>();
        this.dataFilled = false;
    }

    /*
     * REQUIRES: Food list should be of non zero length
     * MODIFIES:this
     * EFFECTS: Copies given food to the food list
     */
    public void copyFood(List<Food> food) {
        this.food = food;
    }

    /*
     * EFFECTS: returns food list
     */
    public List<Food> sendFood() {

        return this.food;
    }

    /*
     * REQUIRES: workout list should be of non zero length
     * MODIFIES:this
     * EFFECTS: Copies given workout to the workout list
     */
    public void copyWorkout(List<Workout> workout) {
        this.workout = workout;
    }
    /*
     * EFFECTS: returns workout list
     */

    public List<Workout> sendWorkout() {

        return this.workout;
    }

    /*
     * REQUIRES: Height is in metres and has a positive value,
     *  weight is in Kgs and is positive value
     * MODIFIES: bodyMassIndex
     * EFFECTS: Calculates the BMI based on the weight,height input by the user
     * returns a String with BMI formatted up to 2 decimal places
     */

    public String bodyMassIndex() throws DataNotFilled {
        if (!dataFilled) {
            throw new DataNotFilled();
        }
        this.bodyMassIndex = weight / (height * height);
        return String.format("%.2f", bodyMassIndex);
    }
    /*
     * REQUIRES: Height is in metres and has a positive value,
     *  weight is in Kgs and is positive value
     * EFFECTS: Calculates the BMI based on the weight,height input by the user
     * returns BMI in an un-formatted double value
     */

    public double getBodyMassIndex() throws DataNotFilled {
        if (!dataFilled) {
            throw new DataNotFilled();
        }
        this.bodyMassIndex = weight / (height * height);
        return bodyMassIndex;
    }
    /*
     * REQUIRES: Height is in metres and has a positive value,
     *  weight is in Kgs and is positive value,Age is in years with a positive value
     * EFFECTS: Calculates the maintenance calories based on the weight,height and age input by the user
     * returns maintenance calories in an un-formatted double value
     */

    public double getMaintenanceCalories() throws DataNotFilled {
        if (!dataFilled) {
            throw new DataNotFilled();
        }
        this.maintenanceCalories2 = (((10 * weight) + (6.25 * height * 100) - (5 * age) + 5) * 1.2);
        return maintenanceCalories2;
    }
    /*
     * REQUIRES: Height is in metres and has a positive value,
     *  weight is in Kgs and is positive value,Age is in years with a positive value
     * MODIFIES: maintenanceCalories2
     * EFFECTS: Calculates the maintenance Calories of the user based on the weight,height and age input
     *  by the user. Returns a String with maintenance Calories formatted up to 2 decimal places
     */

    public String maintenanceCalories2() throws DataNotFilled {
        if (!dataFilled) {
            throw new DataNotFilled();
        }
        this.maintenanceCalories2 = (((10 * weight) + (6.25 * height * 100) - (5 * age) + 5) * 1.2);
        return String.format("%.2f", maintenanceCalories2);
    }

    //EFFECTS: Return height of the user
    public double getHeight() {
        return height;
    }

    //EFFECTS: Return Weight of the user
    public double getWeight() {
        return weight;
    }

    //EFFECTS: Return Name of the user
    public String getName() {
        return name;
    }

    //EFFECTS: Return age of the user
    public int getAge() {
        return age;
    }
    /*
     * REQUIRES: name of the food with non zero length,cal should be positive
     * MODIFIES: f1 (object of Food)
     * EFFECTS: Creates and initialises f1 object. adds f1 to food list
     */

    public void addFood(String f, double cal, double calleft) {
        f1 = new Food(f, cal, calleft);
        food.add(f1);
    }
    /*
     * REQUIRES: name of the workout with non zero length,cal should be positive
     * MODIFIES: w1 (object of Workout)
     * EFFECTS: Creates and initialises w1 object. adds w1 to workout list
     */

    public void addWorkout(String w, double cal, double calleft) {
        w1 = new Workout(w, cal, calleft);
        workout.add(w1);
    }
    /*
     * MODIFIES: this
     * EFFECTS: return String statement which adds previous log entry to new entries to create a Food Log list
     */

    public String getFood() {
        String x = "";
        for (Food value : food) {
            x += value.toString() + "\n";
        }
        return x;
    }

    /*
     * MODIFIES: this
     * EFFECTS: return String statement which adds previous log entry to new entries to create a Workout Log list
     */

    public String getWorkout() {
        String y = "";
        for (Workout value : workout) {
            y += value.toString() + "\n";
        }
        return y;
    }

    /*
     * MODIFIES: this
     * EFFECTS: Creates and initialises json object. loads diary components to jsonObject and returns it
     */

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray1 = new JSONArray();
        JSONArray jsonArray2 = new JSONArray();
        for (Workout w : workout) {
            jsonArray2.put(w.toJson());
        }
        jsonObject.put("workout", jsonArray2);
        for (Food f : food) {
            jsonArray1.put(f.toJson());
        }
        jsonObject.put("food", jsonArray1);
        jsonObject.put("workout", jsonArray2);
        jsonObject.put("name", name);
        jsonObject.put("height", height);
        jsonObject.put("weight", weight);
        jsonObject.put("age", age);
        jsonObject.put("calorieleft", calorieLeft);
        return jsonObject;
    }
}
