package service;

import java.util.List;

import entity.Word;
import repository.DictionaryRepository;
import storage.DictionaryStorage;
import entity.Definition;
import entity.DefinitionType;
import entity.Sentence;

public class DictionaryService {
    private static DictionaryService instance;
    private final DictionaryRepository repository;
    private final DictionaryStorage storage = new DictionaryStorage();

    private DictionaryService() {
        repository = new DictionaryRepository();

        load();

        if (repository.findAll().isEmpty()) {

            initData();

            save();
        }
    }

    private void initData() {

        Word positive = new Word("positive", "ˈpɒzətɪv");

        // Definition 1
        Definition adjective = new Definition(
                "tích cực",
                DefinitionType.ADJECTIVE);

        adjective.addSentence(new Sentence(
                "She has a positive attitude.",
                "Cô ấy có thái độ tích cực."));

        adjective.addSentence(new Sentence(
                "Positive thinking helps you succeed.",
                "Suy nghĩ tích cực giúp bạn thành công."));

        positive.addDefinition(adjective);

        // Definition 2
        Definition noun = new Definition(
                "điều tích cực",
                DefinitionType.NOUN);

        noun.addSentence(new Sentence(
                "Let's focus on the positives.",
                "Hãy tập trung vào những điều tích cực."));

        positive.addDefinition(noun);

        repository.add(positive);
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

    public boolean define(Word word) {
        if (word == null) {
            return false;
        }

        if (repository.find(word.getWord()) != null) {
            return false;
        }

        repository.add(word);

        save();
        return true;
    }

    public boolean drop(String keyword) {
        boolean result = repository.remove(keyword);

        if (result) {
            save();
        }

        return result;
    }

    public List<Word> findAll() {
        return repository.findAll();
    }

    public void load() {
        List<Word> words = storage.load();

        for (Word word : words) {
            repository.add(word);
        }
    }

    public void save() {
        storage.save(repository.findAll());
    }

    public void export() {
        storage.export(repository.findAll());
    }
}
