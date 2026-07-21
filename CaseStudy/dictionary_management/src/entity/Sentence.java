package entity;

public class Sentence {
    private String english;
    private String vietnamese;

    public Sentence() {

    }

    public Sentence(String english, String vietnamese) {
        this.english = english;
        this.vietnamese = vietnamese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getVietnamese() {
        return vietnamese;
    }

    public void setVietnamese(String vietnamese) {
        this.vietnamese = vietnamese;
    }

    @Override
    public String toString() {
        return english + " - " + vietnamese;
    }
}