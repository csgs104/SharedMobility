package entity.data;

import entity.Entity;

import java.time.LocalDate;
import java.util.UUID;

public class License extends Entity {

    private int level = 0;
    private LocalDate release = null;
    private LocalDate expiration = null;

    public License(int level) {
        super();
        this.level = level;
    }

    public License(UUID id, int level) {
        super(id);
        this.level = level;
    }

    public License(int level, LocalDate release, LocalDate expiration) {
        super();
        this.level = level;
        this.release = release;
        this.expiration = expiration;
    }

    public License(UUID id, int level, LocalDate release, LocalDate expiration) {
        super(id);
        this.level = level;
        this.release = release;
        this.expiration = expiration;
    }

    public int getLevel() {
        return level;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    @Override
    public String toString() {
        return "Patente{" +
                "id=" + getId() +
                ", level=" + level +
                ", release=" + release +
                ", expiration=" + expiration +
                '}';
    }

    public static License fromCsv(String line){
        String[] lines = line.split(",");
        return new License(UUID.fromString(lines[0]), Integer.parseInt(lines[1]), LocalDate.parse(lines[2]), LocalDate.parse(lines[3]));
    }

    public static String toCsv(License license){
        return  license.getId() + "," +
                license.getLevel() + "," +
                license.getRelease() + "," +
                license.getExpiration();
    }

}