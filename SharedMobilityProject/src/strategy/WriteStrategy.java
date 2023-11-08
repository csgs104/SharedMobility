package strategy;

import entity.Entity;

@FunctionalInterface
public interface WriteStrategy<T extends Entity> {

    String toText(T entity);

}