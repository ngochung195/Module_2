package controller;

import java.util.List;

import entity.Word;
import service.DictionaryService;

public class DictionaryController {
    private final DictionaryService service;

    public DictionaryController() {
        service = DictionaryService.getInstance();
    }

    public Word lookup(String keyword) {
        return service.lookup(keyword);
    }

    public void define(Word word) {
        service.define(word);
    }

    public boolean drop(String keyword) {
        return service.drop(keyword);
    }

    public List<Word> findAll() {
        return service.findAll();
    }

    public void load() {
        service.load();
    }

    public void save() {
        service.save();
    }
}
