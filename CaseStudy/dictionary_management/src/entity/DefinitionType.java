package entity;

public enum DefinitionType {
    NOUN("Danh từ (noun)"),
    VERB("Động từ (verb)"),
    ADJECTIVE("Tính từ (adjective)"),
    ADVERB("Trạng từ (adverb)");

    private final String displayName;

    DefinitionType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}