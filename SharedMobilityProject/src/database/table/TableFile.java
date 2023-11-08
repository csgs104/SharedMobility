package database.table;


import entity.Entity;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class TableFile<T extends Entity> extends TableDao<T> {

    public TableFile(Map<UUID, T> table, Path path) {
        super(table, path);
        tableRead();
    }

    @Override
    public T get(UUID id) {
        return getTable().get(id);
    }

    @Override
    public List<T> get() {
        return new ArrayList<>(getTable().values());
    }

    @Override
    public T insert(T entity) {
        getTable().put(entity.getId(), entity);
        tableWrite();
        return get(entity.getId());
    }

    @Override
    public void insert(List<T> entities) {
        for (T entity : entities) {
            insert(entity);
        }
    }

    @Override
    public T update(T entity) {
        getTable().put(entity.getId(), entity);
        tableWrite();
        return get(entity.getId());
    }

    @Override
    public void update(List<T> entities) {
        for (T entity : entities) {
            update(entity);
        }
    }

    @Override
    public void delete(UUID id) {
        tableWrite();
        getTable().remove(id);
    }

    @Override
    public void delete(T entity) {
        delete(entity.getId());
    }

    @Override
    public void delete(List<T> entities) {
        for (T entity : entities) {
            delete(entity.getId());
        }
    }

}