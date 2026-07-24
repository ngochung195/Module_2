package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.Word;
import service.DictionaryService;

public class LookupTest {

    private final DictionaryService service = DictionaryService.getInstance();

    @Test
    @DisplayName("Tra cứu từ đã tồn tại")
    void lookupExistingWord() {

        Word word = service.lookup("positive");

        assertNotNull(word);
        assertEquals("positive", word.getWord());
    }

    @Test
    @DisplayName("Tra cứu từ không tồn tại")
    void lookupWordNotFound() {

        Word word = service.lookup("abcdefxyz");

        assertNull(word);
    }
}