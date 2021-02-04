import model.Diary;
import org.junit.jupiter.api.Test;
import persistence.Reader;
import persistence.Writer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestWriter {
    private Diary diaryTest;


    @Test
    void testWriterInvalidFile() {
        try {
            diaryTest = new Diary("Sukhdeep", 1.72, 77.4, 20);
            Writer writer = new Writer("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyDiary() {
        try {
            diaryTest = new Diary();
            Writer writer = new Writer("./data/testWriterEmptyDiary.json");
            writer.open();
            writer.write(diaryTest);
            writer.close();

            Reader reader = new Reader("./data/testWriterEmptyDiary.json");
            diaryTest = reader.read();
            assertEquals("", diaryTest.getName());
            assertEquals(0, diaryTest.getHeight());
            assertEquals(0, diaryTest.getWeight());
            assertEquals(0, diaryTest.getAge());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralDiary() {
        try {
            diaryTest = new Diary("Sukhdeep", 1.72, 77.4, 20);
            diaryTest.addFood("Pizza", 300, diaryTest.calorieLeft);
            diaryTest.addWorkout("Treadmill", 200, diaryTest.calorieLeft);
            Writer writer = new Writer("./data/testWriterGeneralDiary.json");
            writer.open();
            writer.write(diaryTest);
            writer.close();

            Reader reader = new Reader("./data/testWriterGeneralDiary.json");
            diaryTest = reader.read();
            assertEquals("Sukhdeep", diaryTest.getName());
            assertEquals(1.72, diaryTest.getHeight());
            assertEquals(77.4, diaryTest.getWeight());
            assertEquals(20, diaryTest.getAge());
            assertEquals(1, diaryTest.food.size());
            assertEquals(1, diaryTest.workout.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


}
