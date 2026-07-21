package entity;

public class Definition {
    private String meaning;
    private DefinitionType type;

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

    @Override
    public String toString() {
        return type + ": " + meaning;
    }
}
