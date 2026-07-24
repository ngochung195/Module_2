package storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import entity.Definition;
import entity.DefinitionType;
import entity.Sentence;
import entity.Word;

public class DictionaryStorage {
    private static final String FILE_NAME = "dictionary.txt";
    private static final String EXPORT_FILE = "dictionary_export.txt";

    public void save(List<Word> words) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Word word : words) {
                writer.write("TỪ|" + word.getWord() + "|" + word.getPronunciation());
                writer.newLine();

                for (Definition definition : word.getDefinitions()) {
                    writer.write("NGHĨA|" + definition.getType() + "|" + definition.getMeaning());
                    writer.newLine();

                    for (Sentence sentence : definition.getSentences()) {
                        writer.write("VÍ_DỤ|" + sentence.getEnglish() + "|" + sentence.getVietnamese());
                        writer.newLine();
                    }
                }
                writer.write("----------------------------------------");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Word> load() {
        List<Word> words = new ArrayList<>();

        Word currentWord = null;
        Definition currentDefinition = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank() || line.startsWith("-")) {
                    continue;
                }

                String[] data = line.split("\\|");

                switch (data[0]) {
                    case "TỪ":
                        currentWord = new Word(data[1], data[2]);
                        words.add(currentWord);
                        break;
                    case "NGHĨA":
                        currentDefinition = new Definition();

                        currentDefinition.setType(parseType(data[1]));
                        currentDefinition.setMeaning(data[2]);

                        currentWord.addDefinition(currentDefinition);
                        break;
                    case "VÍ_DỤ":
                        Sentence sentence = new Sentence(data[1], data[2]);

                        currentDefinition.addSentence(sentence);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    private DefinitionType parseType(String type) {

        switch (type) {

            case "Danh từ (noun)":
                return DefinitionType.NOUN;

            case "Động từ (verb)":
                return DefinitionType.VERB;

            case "Tính từ (adjective)":
                return DefinitionType.ADJECTIVE;

            case "Trạng từ (adverb)":
                return DefinitionType.ADVERB;

            default:
                throw new IllegalArgumentException("Loại từ không hợp lệ: " + type);

        }

    }

    public void export(List<Word> words) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EXPORT_FILE))) {
            for (Word word : words) {
                writer.write("TỪ: " + word.getWord());
                writer.newLine();

                writer.write("PHIÊN ÂM: " + word.getPronunciation());
                writer.newLine();
                writer.newLine();

                for (Definition definition : word.getDefinitions()) {
                    writer.write("LOẠI TỪ: " + definition.getType());
                    writer.newLine();

                    writer.write("NGHĨA: " + definition.getMeaning());
                    writer.newLine();

                    if (!definition.getSentences().isEmpty()) {
                        writer.write("VÍ DỤ: ");
                        writer.newLine();

                        for (Sentence sentence : definition.getSentences()) {
                            writer.write("• " + sentence.getEnglish());
                            writer.newLine();

                            writer.write("  " + sentence.getVietnamese());
                            writer.newLine();
                            writer.newLine();
                        }
                    }
                }
                writer.write("==================================================");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}