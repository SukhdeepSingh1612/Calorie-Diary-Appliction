package model;

import exceptions.DataNotFilled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDiary {
    private Diary diaryTest;
    private Diary diary;

    @BeforeEach
    void setup() {
        diaryTest = new Diary("Sukhdeep", 1.72, 77.4, 20);
        diary = new Diary();
    }

    @Test
    public void TestDiaryConstructor() {
        assertEquals("Sukhdeep", diaryTest.getName());
        assertEquals(1.72, diaryTest.getHeight());
        assertEquals(77.4, diaryTest.getWeight());
        assertEquals(20, diaryTest.getAge());
    }

    @Test
    public void TestBMI() {
        try {
            assertEquals("26.16", diaryTest.bodyMassIndex());
        } catch (DataNotFilled dataNotFilled) {
            fail();
        }
        try {
            assertEquals("26.16", diary.bodyMassIndex());
            fail();
        } catch (DataNotFilled dataNotFilled) {
            //pass
        }

    }

    @Test
    public void TestBMIWithException() {

        try {
            diary.getBodyMassIndex();
            fail();
        } catch (DataNotFilled dataNotFilled) {
            System.out.println("exception caught");
        }
        diary = new Diary("Sukhdeep", 1.72, 77.4, 20);
        try {
            diary.getBodyMassIndex();

        } catch (DataNotFilled dataNotFilled) {
            fail();
        }
    }

    @Test
    public void TestMaintenanceCaloriesWithException() {
        try {
            diary.getMaintenanceCalories();
            fail();
        } catch (DataNotFilled dataNotFilled) {
            System.out.println("exception caught");
        }
        diary = new Diary("Sukhdeep", 1.72, 77.4, 20);
        try {
            diary.getMaintenanceCalories();

        } catch (DataNotFilled dataNotFilled) {
            fail();
        }

    }

    @Test
    public void TestMaintenanceCalories() {
        try {
            assertEquals("2104.80", diaryTest.maintenanceCalories2());
        } catch (DataNotFilled dataNotFilled) {
            fail();
        }
        try {
            assertEquals("2104.80", diary.maintenanceCalories2());
            fail();
        } catch (DataNotFilled dataNotFilled) {
            //pass
        }


    }

    @Test
    public void TestMaintenanceCaloriesTwo() {
        try {
            assertEquals(2104.7999999999997, diaryTest.getMaintenanceCalories());
        } catch (DataNotFilled dataNotFilled) {
            fail();
        }
        try {
            assertEquals(2104.7999999999997, diary.getMaintenanceCalories());
            fail();
        } catch (DataNotFilled dataNotFilled) {
            //pass
        }

    }

    @Test
    public void TestAddFood() {

        double cal = 500;
        double s = 0;
        try {
            s = (diaryTest.getMaintenanceCalories(
            )) - cal;
        } catch (DataNotFilled dataNotFilled) {
            fail();
        }

        diaryTest.addFood("Pizza", cal, s);

        assertEquals(1, diaryTest.food.size());

    }

    @Test
    public void TestAddMultipleFoods() {

        double cal = 500;
        double cal2 = 600;
        double s = 0;
        try {
            s = (diaryTest.getMaintenanceCalories(
            )) - cal;
        } catch (DataNotFilled dataNotFilled) {
            fail();
        }
        double d = 0;
        try {
            d = (diaryTest.getMaintenanceCalories(
            )) - cal2;
        } catch (DataNotFilled dataNotFilled) {
            fail();
        }

        diaryTest.addFood("Pizza", cal, s);
        diaryTest.addFood("Pasta", cal2, d);

        assertEquals(2, diaryTest.food.size());

    }

    @Test
    public void TestAddWorkout() {

        double calBurnt = 500;
        double s = 0;
        try {
            s = (diaryTest.getMaintenanceCalories(
            )) + calBurnt;
        } catch (DataNotFilled dataNotFilled) {
            fail();
        }

        diaryTest.addWorkout("Cycling", calBurnt, s);

        assertEquals(1, diaryTest.workout.size());

    }

    @Test
    public void TestAddMultipleWorkouts() {

        double calBurnt = 500;
        double calBurnt2 = 600;
        double s = 0;
        try {
            s = (diaryTest.getMaintenanceCalories(
            )) + calBurnt;
        } catch (DataNotFilled dataNotFilled) {
            fail();
        }
        double d = 0;
        try {
            d = (diaryTest.getMaintenanceCalories(
            )) + calBurnt2;
        } catch (DataNotFilled dataNotFilled) {
            fail();
        }

        diaryTest.addWorkout("Treadmill", calBurnt, s);
        diaryTest.addWorkout("Strength", calBurnt2, d);

        assertEquals(2, diaryTest.workout.size());

    }

    @Test
    public void TestGetFood() {
        String food = "Pizza";

        double cal = 500;
        double s = 0;
        try {
            s = (diaryTest.getMaintenanceCalories()) - cal;
        } catch (DataNotFilled dataNotFilled) {
            fail();
        }
        diaryTest.addFood(food, cal, s);
        String x = "" + " You had " + food + " and it contained "
                + cal + " Calories." + "\n";
        assertEquals(x, diaryTest.getFood());

    }

    @Test
    public void TestGetWorkout() {
        String workout = "Treadmill";

        double calBurnt = 500;
        double s = 0;
        try {
            s = (diaryTest.getMaintenanceCalories()) + calBurnt;
        } catch (DataNotFilled dataNotFilled) {
            fail();
        }
        diaryTest.addWorkout(workout, calBurnt, s);
        String x = "" + " You exercised by means of " + workout + ", "
                + " you burned " + calBurnt + " calories." + "\n";

        assertEquals(x, diaryTest.getWorkout());

    }

    @Test
    public void TestSetters() {
        diaryTest.setHeight(1.8);
        diaryTest.setWeight(75);
        diaryTest.setAge(25);
        diaryTest.setName("Jack");
        assertEquals("Jack", diaryTest.getName());
        assertEquals(75, diaryTest.getWeight());
        assertEquals(75, diaryTest.getWeight());
        assertEquals(1.8, diaryTest.getHeight());

    }

    @Test
    public void TestSendFood() {
        diaryTest.addFood("Pizza", 200, diaryTest.calorieLeft);
        diaryTest.addFood("Pizza2", 500, diaryTest.calorieLeft);
        diaryTest.addFood("Pizza3", 400, diaryTest.calorieLeft);
        assertEquals(3, diaryTest.sendFood().size());

    }

    @Test
    public void TestSendWorkout() {
        diaryTest.addWorkout("jog", 200, diaryTest.calorieLeft);
        diaryTest.addWorkout("jog2", 500, diaryTest.calorieLeft);
        diaryTest.addWorkout("jog3", 400, diaryTest.calorieLeft);
        diaryTest.addWorkout("jog4", 400, diaryTest.calorieLeft);
        assertEquals(4, diaryTest.sendWorkout().size());

    }


}