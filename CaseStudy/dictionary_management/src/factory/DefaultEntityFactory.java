package factory;

import entity.Definition;
import entity.Request;
import entity.Sentence;
import entity.Word;

public class DefaultEntityFactory implements EntityFactory {
    @Override
    public Word createWord() {
        return new Word();
    }

    @Override
    public Definition createDefinition() {
        return new Definition();
    }

    @Override
    public Sentence createSentence() {
        return new Sentence();
    }

    @Override
    public Request createRequest() {
        return new Request();
    }
}
