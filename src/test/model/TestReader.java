package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Reader;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestReader {
    private Diary diaryTest;

    @BeforeEach
    void setup() {
        diaryTest = new Diary("Sukhdeep", 1.72, 77.4, 20);
    }

    @Test
    void testReaderNonExistentFile() {
        Reader reader = new Reader("./data/noSuchFile.json");
        try {
            diaryTest = (Diary) reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyDiary() {
        Reader reader = new Reader("./data/testReaderEmptyDiary.json");
        try {
            diaryTest = (Diary) reader.read();
            assertEquals("null", diaryTest.getName());
            // assertEquals(0, diaryTest.numThingies());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralDiary() {
        Reader reader = new Reader("./data/testReaderGeneralDiary.json");
        try {
            diaryTest = (Diary) reader.read();
            assertEquals("Peter", diaryTest.getName());
            assertEquals(1.81, diaryTest.getHeight());
            assertEquals(89, diaryTest.getWeight());
            assertEquals(24, diaryTest.getAge());
            assertEquals(2, diaryTest.food.size());
            assertEquals(1, diaryTest.workout.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


}
