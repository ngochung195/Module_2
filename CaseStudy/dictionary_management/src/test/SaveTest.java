package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import service.DictionaryService;

public class SaveTest {

    private final DictionaryService service = DictionaryService.getInstance();

    @Test
    @DisplayName("Lưu dữ liệu thành công")
    void saveSuccess() {

        service.save();

        File file = new File("dictionary.txt");

        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }

    @Test
    @DisplayName("Lưu dữ liệu nhiều lần")
    void saveMultipleTimes() {

        service.save();
        service.save();

        File file = new File("dictionary.txt");

        assertTrue(file.exists());
    }
}