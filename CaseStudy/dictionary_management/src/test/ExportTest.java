package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import service.DictionaryService;

public class ExportTest {

    private final DictionaryService service = DictionaryService.getInstance();

    @Test
    @DisplayName("Xuất dữ liệu thành công")
    void exportSuccess() {

        service.export();

        File file = new File("dictionary.txt");

        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }

    @Test
    @DisplayName("File xuất tồn tại")
    void exportFileExists() {

        service.export();

        File file = new File("dictionary.txt");

        assertTrue(file.exists());
    }
}