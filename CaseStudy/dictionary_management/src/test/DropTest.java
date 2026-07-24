package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.Definition;
import entity.DefinitionType;
import entity.Word;
import service.DictionaryService;

public class DropTest {

    private final DictionaryService service = DictionaryService.getInstance();

    @Test
    @DisplayName("Xóa từ đã tồn tại")
    void dropExistingWord() {

        // Chuẩn bị dữ liệu
        Word word = new Word("apple", "ˈæpl");
        word.addDefinition(new Definition("quả táo", DefinitionType.NOUN));

        service.define(word);

        // Thực hiện xóa
        boolean result = service.drop("apple");

        // Kiểm tra
        assertTrue(result);
        assertNull(service.lookup("apple"));
    }

    @Test
    @DisplayName("Xóa từ không tồn tại")
    void dropWordNotFound() {

        boolean result = service.drop("abcdefgh");

        assertFalse(result);
    }
}