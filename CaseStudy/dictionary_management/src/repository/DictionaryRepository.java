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
        dictionary.put(word.getWord(), word);
        words.add(word);
    }

    public boolean remove(String keyword) {
        Word removed = dictionary.remove(keyword);

        if (removed != null) {
            words.remove(removed);
            return true;
        }

        return false;
    }

    public Word find(String keyword) {
        return dictionary.get(keyword);
    }

    public List<Word> findAll() {
        return words;
    }
}