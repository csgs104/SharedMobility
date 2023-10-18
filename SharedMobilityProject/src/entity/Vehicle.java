package entity;

public class Vehicle {

    private static int ID = 0;
    private final int id;

    public Vehicle() {
        id = ID++;
    }

    public int getId() {
        return id;
    }

}