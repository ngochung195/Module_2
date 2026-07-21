package factory;

import entity.Definition;
import entity.Request;
import entity.Sentence;
import entity.Word;

public interface EntityFactory {
    Word createWord();

    Definition createDefinition();

    Sentence createSentence();

    Request createRequest();
}