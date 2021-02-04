// code cited from https://github.com/e-newton/CPSC210-Project-Demo

package persistence;


import model.Diary;
import model.Food;
import model.Workout;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Reader {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public Reader(String source) {
        this.source = source;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: reads a Diary JSON file, and return the containing item
    public Diary read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseDiary(jsonObject);
    }

    // EFFECTS: returns a Diary from a read JSONObject
    private Diary parseDiary(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double height = jsonObject.getDouble("height");
        double weight = jsonObject.getDouble("weight");
        int age = jsonObject.getInt("age");
        double calorieleft = jsonObject.getDouble("calorieleft");
        Diary d = new Diary(name, height, weight, age);
        List<Food> food = readFood(jsonObject);
        List<Workout> workout = readWorkout(jsonObject);
        d.copyFood(food);
        d.copyWorkout(workout);
        d.calorieLeft = calorieleft;


        return d;
    }

    // EFFECTS: Parses a Diary JSONObject and returns a list of the containing food
    private List<Food> readFood(JSONObject jsonObject) {
        JSONArray foodArray = jsonObject.getJSONArray("food");
        List<Food> food = new ArrayList<>();
        for (Object f : foodArray) {
            JSONObject foodObject = (JSONObject) f;
            String name = foodObject.getString("name");
            double calories = foodObject.getDouble("calories");
            double caloriesleft = foodObject.getDouble("caloriesleft");
            food.add(new Food(name, calories, caloriesleft));
        }
        return food;

    }
    // EFFECTS: Parses a Diary JSONObject and returns a list of the containing workouts

    private List<Workout> readWorkout(JSONObject jsonObject) {
        JSONArray workoutArray = jsonObject.getJSONArray("workout");
        List<Workout> workout = new ArrayList<>();
        for (Object w : workoutArray) {
            JSONObject workoutObject = (JSONObject) w;
            String name = workoutObject.getString("name");
            double calories = workoutObject.getDouble("calories");
            double caloriesleft = workoutObject.getDouble("caloriesleft");
            workout.add(new Workout(name, calories, caloriesleft));
        }
        return workout;

    }


}
