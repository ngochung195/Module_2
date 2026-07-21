package entity;

public class Word {
    private String word;
    private String pronunciation;

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

    @Override
    public String toString() {
        return word + " [" + pronunciation + "]";
    }
}
