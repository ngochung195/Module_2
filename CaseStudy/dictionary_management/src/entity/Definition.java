package entity;

import java.util.ArrayList;
import java.util.List;

public class Definition {
    private String meaning;
    private DefinitionType type;
    private List<Sentence> sentences = new ArrayList<>();

    public Definition() {

    }

    public Definition(String meaning, DefinitionType type) {
        this.meaning = meaning;
        this.type = type;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public DefinitionType getType() {
        return type;
    }

    public void setType(DefinitionType type) {
        this.type = type;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public String toString() {
        return type + ": " + meaning;
    }
}
