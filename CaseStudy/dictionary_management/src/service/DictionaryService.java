package service;

import java.util.List;

import entity.Word;
import repository.DictionaryRepository;
import entity.Definition;
import entity.DefinitionType;
import entity.Sentence;

public class DictionaryService {
    private static DictionaryService instance;

    private final DictionaryRepository repository;

    private DictionaryService() {
        repository = new DictionaryRepository();

        initData();
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

    public void define(Word word) {
        if (word == null) {
            return;
        }
        repository.add(word);
    }

    public boolean drop(String keyword) {
        return repository.remove(keyword);
    }

    public List<Word> findAll() {
        return repository.findAll();
    }

    // Doc du lieu file
    public void load() {

    }

    // Ghi du lieu file
    public void save() {

    }
}
