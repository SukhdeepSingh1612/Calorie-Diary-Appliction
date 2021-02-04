

import model.Diary;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJson {
    Diary diary;

    protected void Diary(String name, double height, double weight, int age) {
        assertEquals(name, diary.getName());
        assertEquals(height, diary.getHeight());
        assertEquals(weight, diary.getWeight());
        assertEquals(age, diary.getAge());
    }
}
