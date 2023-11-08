package database.table;

import entity.Entity;
import strategy.DaoStrategy;
import strategy.ReadStrategy;
import strategy.WriteStrategy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class TableDao<T extends Entity> implements DaoStrategy<T>, ReadStrategy<T>, WriteStrategy<T> {

    private final Map<UUID, T> table;
    private final Path path;

    public TableDao(Map<UUID, T> table, Path path) {
        this.table = table;
        this.path = path;
    }

    public Map<UUID, T> getTable() {
        return table;
    }

    public Path getPath() {
        return path;
    }

    public void tableRead() {
        for (T entity : read()) {
            table.put(entity.getId(), entity);
        }
    }

    public void tableWrite() {
        write(new ArrayList<>(table.values()));
    }

    private List<T> read() {
        List<T> entities = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                entities.add(fromText(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    private void write(List<T> entities) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            T entity;
            while ((entity = entities.iterator().next()) != null) {
                bw.write(toText(entity)); bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}