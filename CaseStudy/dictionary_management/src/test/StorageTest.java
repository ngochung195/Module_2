package test;

import java.util.List;

import entity.Definition;
import entity.Sentence;
import entity.Word;
import storage.DictionaryStorage;

public class StorageTest {

    public static void main(String[] args) {

        DictionaryStorage storage = new DictionaryStorage();

        storage.export(storage.load());

        List<Word> words = storage.load();

        for (Word word : words) {

            System.out.println("================================");
            System.out.println("Từ: " + word.getWord());
            System.out.println("Phiên âm: " + word.getPronunciation());

            for (Definition definition : word.getDefinitions()) {

                System.out.println("Loại từ: " + definition.getType());
                System.out.println("Nghĩa: " + definition.getMeaning());

                for (Sentence sentence : definition.getSentences()) {

                    System.out.println("Ví dụ EN: " + sentence.getEnglish());
                    System.out.println("Ví dụ VI: " + sentence.getVietnamese());

                }

            }

        }

    }

}