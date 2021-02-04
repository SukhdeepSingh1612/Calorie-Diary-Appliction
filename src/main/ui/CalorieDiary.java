package ui;

import exceptions.DataNotFilled;
import model.Diary;
import persistence.Reader;
import persistence.Writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
// Calorie Diary Application

public class CalorieDiary {
    public Diary diary;            //Creates object for the diary
    Scanner sc = new Scanner(System.in);             // Creates scanner object
    Writer writer = new Writer("./data/Diary.json");        //Writer Object
    Reader reader = new Reader("./data/Diary.json");           //Reader Object
    boolean dataLoaded = false;                                      // Boolean to check if data is loaded

    // starts the calorie diary application
    // loads diary if previous session is available
    public CalorieDiary() throws Exception {
        loadDiary();
        starter();
    }

    boolean quit = false;
    //MODIFIES: this
    //EFFECTS: checks input and selects what happens in the menu
    // if data not loaded then runs initial() otherwise runs menu

    public void starter() throws Exception {
        if (!dataLoaded) {
            initial();
        }


        while (!(quit)) {
            menu();
            int input = sc.nextInt();
            switchCase(input);
        }


    }
    //REQUIRES: input should be a valid integer corresponding to menu
    //MODIFIES: this
    //EFFECTS: Processes and runs appropriate method based on the input by the user

    private void switchCase(int input) throws Exception {
        switch (input) {
            case 1: {
                bmiCheck();

            }
            break;
            case 2: {
                maintenanceCal();
            }
            break;
            case 3: {
                logs();

            }
            break;
            case 4:
                System.out.println("Your daily quota left is :" + diary.calorieLeft);
                break;

            case 5:
                quitMessage();

                break;
            default:
                System.out.println("Invalid Input. Please try again\n");

        }
    }
    //EFFECTS: Runs BMI method and tells the user abou their BMI

    private void bmiCheck() throws Exception {
        bmi();
        if (diary.getBodyMassIndex() < 18.5) {
            System.out.println("You are underweight! You need to gain weight.\n");
        }
        if (diary.getBodyMassIndex() > 18.5
                && diary.getBodyMassIndex() < 24.9) {
            System.out.println("You are healthy weight! Good Job!\n");
        }
        if (diary.getBodyMassIndex() >= 24.9
                && diary.getBodyMassIndex() < 29.9) {
            System.out.println("You are overweight! You need to loose weight.\n");
        }
        if (diary.getBodyMassIndex() >= 29.9) {
            System.out.println("You are obese! You need to loose a lot of weight.\n");
        }
    }
    //EFFECTS: ask the user what they want to do with logs

    private void logs() {
        System.out.println("Do you want to add to your logs or review them");
        System.out.println("select 1 : to add a new Log");
        System.out.println("select 2 : to review existing Log");
        int in = sc.nextInt();
        switch (in) {

            case 1: {
                addToLogs();
            }
            break;
            case 2: {
                reviewLogs();
            }
            break;
            default:
                System.out.println("Invalid Input. Please try again\n");
        }
    }
    //EFFECTS: Display quit message and ends the program and prompts the user to save their data

    private void quitMessage() {
        System.out.println("Thank you for using this application! Would you like to save your data? ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int input2 = sc.nextInt();
        switch (input2) {
            case 1: {
                saveDiary();
                System.out.println("Your data has been saved. Thank you for using Calorie Diary");
            }
            break;
            case 2:
                System.out.println("Thank you for using Calorie Diary. Good Bye!");
                break;
        }
        quit = true;
    }
    //EFFECTS: ask the user which log they want to review

    private void reviewLogs() {
        System.out.println("Please select which Log you want to review ");
        System.out.println("select 1 : for Food Log");
        System.out.println("select 2 : for Workout Log");
        int in = sc.nextInt();
        switch (in) {

            case 1: {
                System.out.println(diary.getFood());
            }
            break;
            case 2: {
                System.out.println(diary.getWorkout());
            }
            break;
            default:
                System.out.println("Invalid Input. Please try again\n");
        }
    }
    //EFFECTS: ask the user which log they want to add to

    private void addToLogs() {
        System.out.println("Please select which Log you want to add to ");
        System.out.println("select 1 : for Food Log");
        System.out.println("select 2 : for Workout Log");
        int in = sc.nextInt();
        sc.nextLine();
        switch (in) {

            case 1: {
                foodLog();
            }
            break;
            case 2: {
                workoutLog();
            }
            break;
            default:
                System.out.println("Invalid Input. Please try again\n");
        }
    }
    // MODIFIES: this,calorieleft
    //EFFECTS: Take input from the user and creates a log entry for workout, prints log entry

    private void workoutLog() {
        System.out.println("Please enter how did you exercise");
        String c = sc.nextLine();

        System.out.println("Please enter how many calories you burnt ");
        double v = sc.nextDouble();
        diary.calorieLeft += v;
        System.out.println(" You entry of " + c + " with " + v + " calories burned has been added to the logs");
        diary.addWorkout(c, v, diary.calorieLeft);
    }
    // MODIFIES: this
    //EFFECTS: Take input from the user and creates a log entry for workout

    private void foodLog() {
        System.out.println("Please enter what you ate");
        String a = sc.nextLine();
        System.out.println("Please enter how many calories it contained ");
        double z = sc.nextDouble();
        diary.calorieLeft -= z;
        System.out.println(" You entry of " + a + " with " + z + " calories has been added to the logs");
        diary.addFood(a, z, diary.calorieLeft);
    }
    // MODIFIES: this
    //EFFECTS: Prints suggested maintenance calories

    private void maintenanceCal() throws DataNotFilled {
        System.out.println(" Your suggested daily maintenance calories are "
                + (diary.maintenanceCalories2())
                + " cals/day\n");
    }
    // MODIFIES: this
    //EFFECTS: Prints BMI based on users inputs

    private void bmi() {
        try {
            System.out.println(" Your BMI is : "
                    + (diary.bodyMassIndex()) + "\n");
        } catch (DataNotFilled dataNotFilled) {
            System.out.println("Enter data properly");
        }
    }
    // MODIFIES: this
    // EFFECTS: Takes all the required inputs from the user and initialise diary object

    public void initial() throws DataNotFilled {


        System.out.println("Welcome to Calorie Diary");
        System.out.println("Please enter your name");
        String name = sc.nextLine();
        System.out.println("Please enter your weight in kgs");
        double weight = sc.nextDouble();
        System.out.println("Please enter your height in metres");
        double height = sc.nextDouble();
        System.out.println("Please enter your age");
        int age = sc.nextInt();

        diary = new Diary(name, height, weight, age);
        diary.calorieLeft = diary.getMaintenanceCalories();


    }

    // EFFECTS: Display menu options to the user

    public void menu() {
        System.out.println(" Please select one of the following option");
        System.out.println("1 : Get to know your BMI");
        System.out.println("2 : Get to know your suggested maintenance calories");
        System.out.println("3 : Add/Review your logs");
        System.out.println("4 : Check how much of your daily quota is left");
        System.out.println("5 : To quit the Calorie Diary");
    }
    // EFFECTS: fetches the previous session and throws exception if session is not found
    // catches the exception to give error message

    private void loadDiary() {
        try {
            diary = (Diary) reader.read();
            System.out.println("Previous session successfully loaded");
            dataLoaded = true;
        } catch (IOException e) {
            System.out.println("Error in loading previous session");
        }
    }
    // EFFECTS: Saves the current session and throws exception if the log file is not found
    // catches the exception to give error message

    private void saveDiary() {
        try {
            writer.open();
            writer.write(diary);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }

    }
}
