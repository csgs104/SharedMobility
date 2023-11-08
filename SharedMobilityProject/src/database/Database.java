package database;

import entity.data.License;
import entity.data.Rental;
import entity.data.User;
import entity.data.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Database {

    private final Map<UUID, License> licenseTable = new HashMap<>();
    private final Map<UUID, User> userTable = new HashMap<>();
    private final Map<UUID, Vehicle> vehicleTable = new HashMap<>();
    private final Map<UUID, Rental> rentalTable = new HashMap<>();

    public Map<UUID, License> getLicenseTable() {
        return licenseTable;
    }
    public Map<UUID, User> getUserTable() {
        return userTable;
    }
    public Map<UUID, Vehicle> getVehicleTable() {
        return vehicleTable;
    }
    public Map<UUID, Rental> getRentalTable() {
        return rentalTable;
    }

    public void putLicense(License entity) {
        licenseTable.put(entity.getId(), entity);
    }
    public License getLicense(UUID id) {
        return licenseTable.get(id);
    }
    public void removeLicense(UUID id) {
        licenseTable.remove(id);
    }
    public boolean containsLicense(UUID id) {
        return licenseTable.containsKey(id);
    }

    public void putUser(User entity) {
        userTable.put(entity.getId(), entity);
    }
    public User getUser(UUID id) {
        return userTable.get(id);
    }
    public void removeUser(UUID id) {
        userTable.remove(id);
    }
    public boolean containsUser(UUID id) {
        return userTable.containsKey(id);
    }

    public void putVehicle(Vehicle entity) {
        vehicleTable.put(entity.getId(), entity);
    }
    public Vehicle getVehicle(UUID id) {
        return vehicleTable.get(id);
    }
    public void removeVehicle(UUID id) {
        vehicleTable.remove(id);
    }
    public boolean containsVehicle(UUID id) {
        return vehicleTable.containsKey(id);
    }

    public void putRental(User user, Vehicle vehicle) {
        User userIn = userTable.get(user.getId());
        Vehicle vehicleIn = vehicleTable.get(vehicle.getId());
        if (userIn != null && vehicleIn != null && Rental.checkAll(user, vehicle)) {
            Rental rental = new Rental(userIn.getId(), vehicleIn.getId(), userIn, vehicleIn);
            rentalTable.put(rental.getId(), rental);
        }
    }
    public Rental getRental(UUID id) {
        return rentalTable.get(id);
    }
    public void removeRental(UUID id) {
        rentalTable.remove(id);
    }
    public boolean containsRental(UUID id) {
        return rentalTable.containsKey(id);
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

    public boolean startRental(UUID id) {
        Rental rental = rentalTable.get(id);
        Vehicle vehicle = rental.getVehicle();
        if (vehicle.getAvailability()) {
            rental.setStart(LocalDateTime.now());
            rental.getVehicle().setAvailability(false);
            return true;
        }
        return false;
    }

    public boolean endRental(UUID id) {
        Rental rental = rentalTable.get(id);
        Duration duration = Duration.between(rental.getStart(), LocalDateTime.now());
        Vehicle vehicle = rental.getVehicle();
        if (!vehicle.getAvailability() && duration.getSeconds() > 10) {
            rental.setEnd(LocalDateTime.now());
            rental.getVehicle().setAvailability(true);
            rental.takeCredit();
            rental.takeEnergy();
            User userUpdated = rental.getUser();
            Vehicle vehicleUpdated = rental.getVehicle();
            putUser(userUpdated);
            putVehicle(vehicleUpdated);
            return true;
        }
        return false;
    }

    public Set<License> getLicenses() {
        Set<License> entities = new HashSet<>();
        for (UUID id : userTable.keySet()) entities.add(licenseTable.get(id));
        return entities;
    }

    public Set<User> getUsers() {
        Set<User> entities = new HashSet<>();
        for (UUID id : userTable.keySet()) entities.add(userTable.get(id));
        return entities;
    }

    public Set<Vehicle> getVehicles() {
        Set<Vehicle> entities = new HashSet<>();
        for (UUID id : vehicleTable.keySet()) entities.add(vehicleTable.get(id));
        return entities;
    }

    public Set<Rental> getRentals() {
        Set<Rental> entities = new HashSet<>();
        for (UUID id : rentalTable.keySet()) entities.add(rentalTable.get(id));
        return entities;
    }

    public void printLicenses() {
        Set<UUID> keys = userTable.keySet();
        System.out.println("##########################################################################################");
        System.out.println("######################################## LICENSES ########################################");
        System.out.println("##########################################################################################");
        for (UUID key : keys) System.out.println(userTable.get(key));
        System.out.println("##########################################################################################");
    }

    public void printUsers() {
        Set<UUID> keys = userTable.keySet();
        System.out.println("##########################################################################################");
        System.out.println("######################################### USERS #########################################");
        System.out.println("##########################################################################################");
        for (UUID key : keys) System.out.println(userTable.get(key));
        System.out.println("##########################################################################################");
    }

    public void printVehicles() {
        Set<UUID> keys = vehicleTable.keySet();
        System.out.println("##########################################################################################");
        System.out.println("######################################## VEHICLES #######################################");
        System.out.println("##########################################################################################");
        for (UUID key : keys) System.out.println(vehicleTable.get(key));
        System.out.println("##########################################################################################");
    }

    public void printRentals() {
        Set<UUID> keys = rentalTable.keySet();
        System.out.println("##########################################################################################");
        System.out.println("######################################### RENTAL #########################################");
        System.out.println("##########################################################################################");
        for (UUID key : keys) System.out.println(rentalTable.get(key));
        System.out.println("##########################################################################################");
    }

}