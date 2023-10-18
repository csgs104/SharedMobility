package entity;

public class User {

    private static int ID = 0;
    private final int id;

    public User() {
        id = ID++;
    }

    public int getId() {
        return id;
    }

}