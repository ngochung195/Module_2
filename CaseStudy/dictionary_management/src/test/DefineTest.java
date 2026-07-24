package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.Definition;
import entity.DefinitionType;
import entity.Word;
import service.DictionaryService;

public class DefineTest {

    private final DictionaryService service = DictionaryService.getInstance();

    @Test
    @DisplayName("Thêm từ mới thành công")
    void defineNewWord() {

        Word word = new Word("computer", "kəmˈpjuːtə");

        Definition definition = new Definition("máy tính", DefinitionType.NOUN);

        word.addDefinition(definition);

        service.define(word);

        assertNotNull(service.lookup("computer"));
    }

    @Test
    @DisplayName("Thêm từ bị trùng")
    void defineDuplicateWord() {

        Word word = new Word("positive", "");

        Definition definition = new Definition("trùng", DefinitionType.ADJECTIVE);

        word.addDefinition(definition);

        service.define(word);

        Word result = service.lookup("positive");

        assertEquals("positive", result.getWord());
    }

}