package database;

import entity.User;
import entity.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Database {

    private Map<Integer, User> userTable = new HashMap<>();
    private Map<Integer, Vehicle> vehicleTable = new HashMap<>();

    public Map<Integer, User> getUserTable() {
        return userTable;
    }

    public Map<Integer, Vehicle> getVehicleTable() {
        return vehicleTable;
    }

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

    public boolean rent(User user, Vehicle vehicle) {
        if (containsUser(user.getId()) && containsVehicle(vehicle.getId())) {
            Vehicle v = vehicleTable.get(vehicle.getId());
            User u = userTable.get(user.getId());
            // u.setVehicle(v);
            return true;
        }
        return false;
    }

    public boolean free(User user) {
        return true;
    }

    public boolean search(User user) {
        return true;
    }

    public boolean search(Vehicle user) {
        return true;
    }

    public User registration(User user) {
        userTable.put(user.getId(), user);
        return userTable.get(user.getId());
    }

    public Vehicle registration(Vehicle vehicle) {
        vehicleTable.put(vehicle.getId(), vehicle);
        return vehicleTable.get(vehicle.getId());
    }

    public void printUsers() {
        Set<Integer> keys = vehicleTable.keySet();
        System.out.println("##########################################################################################");
        System.out.println("######################################### USERS #########################################");
        System.out.println("##########################################################################################");
        for (Integer key : keys) System.out.println(vehicleTable.get(key));
        System.out.println("##########################################################################################");
    }

    public void printVehicles() {
        Set<Integer> keys = userTable.keySet();
        System.out.println("##########################################################################################");
        System.out.println("######################################## VEHICLES ########################################");
        System.out.println("##########################################################################################");
        for (Integer key : keys) System.out.println(userTable.get(key));
        System.out.println("##########################################################################################");
    }

}