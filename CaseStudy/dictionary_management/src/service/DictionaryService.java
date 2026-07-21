package service;

import entity.Word;
import repository.DictionaryRepository;

public class DictionaryService {
    private static DictionaryService instance;

    private final DictionaryRepository repository;

    private DictionaryService() {
        repository = new DictionaryRepository();
    }

    public static DictionaryService getInstance() {
        if (instance == null) {
            instance = new DictionaryService();
        }

        return instance;
    }

    public Word lookup(String keyword) {
        return repository.find(keyword);
    }

    public void define(Word word) {
        repository.add(word);
    }

    public boolean drop(String keyword) {
        return repository.remove(keyword);
    }

    public void export() {
        for (Word word : repository.findAll()) {
            System.out.println(word);
        }
    }

    // Doc du lieu file
    public void load() {

    }

    // Ghi du lieu file
    public void save() {

    }
}
