package database;

import entity.data.License;
import entity.data.Rental;
import entity.data.Vehicle;
import entity.data.User;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class DatabaseFile extends Database {

    private final Path licensePath;
    private final Path userPath;
    private final Path vehiclePath;
    private final Path rentalPath;

    public DatabaseFile(Path licensePath, Path userPath, Path vehiclePath, Path rentalPath) throws IOException {
        this.licensePath = licensePath;
        readLicenses();
        this.userPath = userPath;
        readUsers();
        this.vehiclePath = vehiclePath;
        readVehicles();
        this.rentalPath = rentalPath;
        readRentals();
    }

    private void readLicenses() throws IOException {
        List<String> lines = Files.readAllLines(licensePath);
        for (String line : lines) {
            License entity = License.fromCsv(line);
            // apply
            getLicenseTable().put(entity.getId(), entity);
        }
    }

    private void readUsers() throws IOException {
        List<String> lines = Files.readAllLines(userPath);
        for (String line : lines) {
            User entity = User.fromCsv(line);
            License license = getLicenseTable().get(entity.getLicenseId());
            entity.setLicense(license);
            // apply
            getUserTable().put(entity.getId(), entity);
        }
    }

    private void readVehicles() throws IOException {
        List<String> lines = Files.readAllLines(vehiclePath);
        for (String line : lines) {
            Vehicle entity = Vehicle.fromCsv(line);
            // apply
            getVehicleTable().put(entity.getId(), entity);
        }
    }

    private void readRentals() throws IOException {
        List<String> lines = Files.readAllLines(rentalPath);
        for (String line : lines) {
            Rental entity = Rental.fromCsv(line);
            User user = getUserTable().get(entity.getUserId());
            Vehicle vehicle = getVehicleTable().get(entity.getVehicleId());
            // apply
            entity.setUser(user);
            entity.setVehicle(vehicle);
            getRentalTable().put(entity.getId(), entity);
        }
    }

    private void saveLicenses() throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(licensePath);
        for (License entity : getLicenses()) {
            bw.write(License.toCsv(entity));
            bw.newLine();
        }
        bw.close();
    }

    private void saveUsers() throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(userPath);
        for (User user : getUsers()) {
            bw.write(User.toCsv(user));
            bw.newLine();
        }
        bw.close();
    }

    private void saveVehicles() throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(vehiclePath);
        for (Vehicle vehicle : getVehicles()) {
            bw.write(Vehicle.toCsv(vehicle));
            bw.newLine();
        }
        bw.close();
    }

    private void saveRentals() throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(rentalPath);
        for (Rental rental : getRentals()) {
            bw.write(Rental.toCsv(rental));
            bw.newLine();
        }
        bw.close();
    }

    @Override
    public void putLicense(License entity) {
        super.putLicense(entity);
        try { saveLicenses(); }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

    @Override
    public void removeLicense(UUID id) {
        super.removeUser(id);
        try { saveLicenses(); }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

    @Override
    public void putUser(User entity) {
        super.putUser(entity);
        try { saveUsers(); }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

    @Override
    public void removeUser(UUID id) {
        super.removeUser(id);
        try { saveUsers(); }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

    @Override
    public void putVehicle(Vehicle entity) {
        super.putVehicle(entity);
        try { saveVehicles(); }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

    @Override
    public void removeVehicle(UUID id) {
        super.removeVehicle(id);
        try { saveVehicles(); }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

    @Override
    public void putRental(User user, Vehicle vehicle) {
        User userIn = getUserTable().get(user.getId());
        Vehicle vehicleIn = getVehicleTable().get(vehicle.getId());
        License licenseIn = getLicenseTable().get(user.getLicenseId());
        if (userIn != null && vehicleIn != null && licenseIn != null) {
            userIn.setLicense(licenseIn);
            if (Rental.checkAll(user, vehicle)) {
                Rental rental = new Rental(userIn.getId(), vehicleIn.getId(), userIn, vehicleIn);
                getRentalTable().put(rental.getId(), rental);
                try { saveRentals(); }
                catch (IOException e) { System.out.println(e.getMessage()); }
            }
        }
    }

    @Override
    public void removeRental(UUID id) {
        super.removeRental(id);
        try { saveRentals(); }
        catch (IOException e) { System.out.println(e.getMessage()); }
    }

    @Override
    public Rental rent(User user, Vehicle vehicle) {
        User userIn = getUserTable().get(user.getId());
        Vehicle vehicleIn = getVehicleTable().get(vehicle.getId());
        License licenseIn = getLicenseTable().get(user.getLicenseId());
        if (userIn != null && vehicleIn != null && licenseIn != null) {
            userIn.setLicense(licenseIn);
            if (Rental.checkAll(user, vehicle)) {
                Rental rental = new Rental(userIn.getId(), vehicleIn.getId(), userIn, vehicleIn);
                Rental rentalIn = getRentalTable().put(rental.getId(), rental);
                try { saveRentals(); }
                catch (IOException e) { System.out.println(e.getMessage()); }
                return rentalIn;
            }
        }
        return null;
    }

    @Override
    public boolean startRental(UUID id) {
        Rental rental = getRentalTable().get(id);
        Vehicle vehicle = rental.getVehicle();
        if (vehicle.getAvailability()) {
            rental.setStart(LocalDateTime.now());
            rental.getVehicle().setAvailability(false);
            try { saveVehicles(); saveRentals(); }
            catch (IOException e) { System.out.println(e.getMessage()); }
            return true;
        }
        return false;
    }

    @Override
    public boolean endRental(UUID id) {
        Rental rental = getRentalTable().get(id);
        Duration duration = Duration.between(rental.getStart(), LocalDateTime.now());
        Vehicle vehicle = rental.getVehicle();
        if (!vehicle.getAvailability() && duration.getSeconds() > 10) {
            rental.setEnd(LocalDateTime.now());
            rental.getVehicle().setAvailability(true);
            rental.takeCredit();
            rental.takeEnergy();
            User userUpdated = rental.getUser();
            Vehicle vehicleUpdated = rental.getVehicle();
            super.putUser(userUpdated);
            super.putVehicle(vehicleUpdated);
            try { saveUsers(); saveVehicles(); saveRentals(); }
            catch (IOException e) { System.out.println(e.getMessage()); }
            return true;
        }
        return false;
    }

}