package database;

import entity.User;
import entity.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<Integer, User> userTable = new HashMap<>();
    private Map<Integer, Vehicle> vehicleTable = new HashMap<>();

    public void addUser(User user) {
        userTable.put(user.getId(), user);
    }

    public User getUser(Integer userId) {
        return userTable.get(userId);
    }

    public void deleteUser(Integer userId) {
        userTable.remove(userId);
    }

    public boolean containsUser(Integer userId) {
        return userTable.containsKey(userId);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleTable.put(vehicle.getId(), vehicle);
    }

    public Vehicle getVehicle(Integer vehicleId) {
        return vehicleTable.get(vehicleId);
    }

    public void deleteVehicle(Integer vehicleId) {
        vehicleTable.remove(vehicleId);
    }

    public boolean containsVehicle(Integer vehicleId) {
        return vehicleTable.containsKey(vehicleId);
    }

}