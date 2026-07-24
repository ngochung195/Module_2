package entity;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private String word;
    private String pronunciation;
    private List<Definition> definitions = new ArrayList<>();

    public Word() {

    }

    public Word(String word, String pronunciation) {
        this.word = word;
        this.pronunciation = pronunciation;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public void addDefinition(Definition definition) {

        definitions.add(definition);

    }

    @Override
    public String toString() {
        return word + " [" + pronunciation + "]";
    }
}
