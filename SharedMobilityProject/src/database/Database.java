package database;

import entity.Rental;
import entity.User;
import entity.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Database {

    private Map<Integer, User> userTable = new HashMap<>();
    private Map<Integer, Vehicle> vehicleTable = new HashMap<>();
    private Map<Integer, Rental> rentalTable = new HashMap<>();


    public Map<Integer, User> getUserTable() {
        return userTable;
    }

    public Map<Integer, Vehicle> getVehicleTable() {
        return vehicleTable;
    }

    public Map<Integer, Rental> getRentalTable() {
        return rentalTable;
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

    public void addRental(User user, Vehicle vehicle) {
        User userIn = userTable.get(user.getId());
        Vehicle vehicleIn = vehicleTable.get(vehicle.getId());
        if (userIn != null && vehicleIn != null && Rental.checkAll(userIn, vehicleIn) ) {
            Rental rental = new Rental(userIn.getId(), vehicleIn.getId(), userIn, vehicleIn);
            rentalTable.put(rental.getId(), rental);
        }
    }

    public void startRental(Integer rentalId) {
        Rental rental = rentalTable.get(rentalId);
        rental.setStart(LocalDateTime.now());
        rental.getVehicle().setDisponibilita(false);
    }

    public void endRental(Integer rentalId) {
        Rental rental = rentalTable.get(rentalId);
        Duration duration = Duration.between(rental.getStart(), LocalDateTime.now());
        if (duration.getSeconds() > 10) {
            rental.setEnd(LocalDateTime.now());
            rental.getVehicle().setDisponibilita(true);
            rental.togliSoldi();
            rental.togliCarburante();
        }
    }

    public Rental getRental(Integer rentalId) {
        return rentalTable.get(rentalId);
    }

    public void deleteRental(Integer rentalId) {
        rentalTable.remove(rentalId);
    }

    public boolean containsRental(Integer rentalId) {
        return rentalTable.containsKey(rentalId);
    }

    public Rental rent(User user, Vehicle vehicle) {
        User userIn = userTable.get(user.getId());
        Vehicle vehicleIn = vehicleTable.get(vehicle.getId());
        if (userIn != null && vehicleIn != null && Rental.checkAll(userIn, vehicleIn)) {
            Rental rental = new Rental(userIn.getId(), vehicleIn.getId(), userIn, vehicleIn);
            rentalTable.put(rental.getId(), rental);
            return rentalTable.get(rental.getId());
        }
        return null;
    }

    public User search(User user) {
        return getUser(user.getId());
    }

    public Vehicle search(Vehicle vehicle) {
        return getVehicle(vehicle.getId());
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
        Set<Integer> keys = userTable.keySet();
        System.out.println("##########################################################################################");
        System.out.println("######################################### USERS #########################################");
        System.out.println("##########################################################################################");
        for (Integer key : keys) System.out.println(userTable.get(key));
        System.out.println("##########################################################################################");
    }

    public void printVehicles() {
        Set<Integer> keys = vehicleTable.keySet();
        System.out.println("##########################################################################################");
        System.out.println("######################################## VEHICLES #######################################");
        System.out.println("##########################################################################################");
        for (Integer key : keys) System.out.println(vehicleTable.get(key));
        System.out.println("##########################################################################################");
    }

    public void printRentals() {
        Set<Integer> keys = rentalTable.keySet();
        System.out.println("##########################################################################################");
        System.out.println("######################################## RENTAL ########################################");
        System.out.println("##########################################################################################");
        for (Integer key : keys) System.out.println(rentalTable.get(key));
        System.out.println("##########################################################################################");
    }


}