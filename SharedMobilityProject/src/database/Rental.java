package database;

import entity.User;
import entity.Vehicle;

import java.time.LocalDateTime;

public class Rental {

    private static int ID = 0;
    private final int id;
    private final int idUser;
    private final int idVehicle;
    private LocalDateTime start = null;
    private LocalDateTime end = null;
    private User user = null;
    private Vehicle vehicle = null;

    public Rental(int idUser, int idVehicle) {
        id = ID++;
        this.idUser = idUser;
        this.idVehicle = idVehicle;
    }

    public Rental(int idUser, int idVehicle, User user, Vehicle vehicle) {
        id = ID++;
        this.idUser = idUser;
        this.idVehicle = idVehicle;
        this.user = user;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return idUser;
    }

    public int getVehicleId() {
        return idVehicle;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idVehicle=" + idVehicle +
                ", start=" + start +
                ", end=" + end +
                ", UserName=" + user.getName() + " " + user.getSurname() +
                ", VehicleName=" + vehicle.getClass().getName().split("\\.")[2] +
                '}';
    }

    public static boolean checkAll(User user, Vehicle vehicle) {
        return true;
    }

}
