package repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import entity.Word;

public class DictionaryRepository {
    private Map<String, Word> dictionary;
    private LinkedList<Word> words;

    public DictionaryRepository() {
        dictionary = new HashMap<>();
        words = new LinkedList<>();
    }

    public void add(Word word) {
        if (word == null) {
            return;
        }

        String key = word.getWord().toLowerCase();

        dictionary.put(key, word);
        words.add(word);
    }

    public boolean remove(String keyword) {
        String key = keyword.toLowerCase();

        Word removed = dictionary.remove(key);

        if (removed != null) {
            words.remove(removed);
            return true;
        }

        return false;
    }

    public Word find(String keyword) {
        return dictionary.get(keyword.toLowerCase());
    }

    public List<Word> findAll() {
        return new LinkedList<>(words);
    }
}