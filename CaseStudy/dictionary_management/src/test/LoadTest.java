package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.Word;
import service.DictionaryService;

public class LoadTest {

    private final DictionaryService service = DictionaryService.getInstance();

    @Test
    @DisplayName("Đọc dữ liệu từ file thành công")
    void loadSuccess() {

        service.load();

        Word word = service.lookup("positive");

        assertNotNull(word);
    }

    @Test
    @DisplayName("Sau khi đọc file có dữ liệu")
    void loadHasData() {

        service.load();

        assertFalse(service.findAll().isEmpty());
    }
}