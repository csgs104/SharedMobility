package strategy;

import entity.Entity;

import java.util.List;
import java.util.UUID;

public interface DaoStrategy<T extends Entity> {

    T get(UUID id);
    List<T> get();
    T insert(T entity);
    void insert(List<T> entities);
    T update(T entity);
    void update(List<T> entities);
    void delete(UUID id);
    void delete(T entity);
    void delete(List<T> entities);

}