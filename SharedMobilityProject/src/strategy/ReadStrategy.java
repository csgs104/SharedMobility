package strategy;

import entity.Entity;

@FunctionalInterface
public interface ReadStrategy<T extends Entity> {

    T fromText(String string);

}
