package entity.data;

import entity.Entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Rental extends Entity {

    private final UUID userId;
    private final UUID vehicleId;
    private LocalDateTime start = null;
    private LocalDateTime end = null;
    private User user = null;
    private Vehicle vehicle = null;

    public Rental(UUID userId, UUID vehicleId) {
        super();
        this.userId = userId;
        this.vehicleId = vehicleId;
    }

    public Rental(UUID id, UUID userId, UUID vehicleId) {
        super(id);
        this.userId = userId;
        this.vehicleId = vehicleId;
    }

    public Rental(UUID userId, UUID vehicleId, User user, Vehicle vehicle) {
        super();
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.user = user;
        this.vehicle = vehicle;
    }

    public Rental(UUID id, UUID userId, UUID vehicleId, User user, Vehicle vehicle) {
        super(id);
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.user = user;
        this.vehicle = vehicle;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getVehicleId() {
        return vehicleId;
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

    public void setStart(LocalDateTime start) {
        this.start = start;
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

    /**
     * Check dati inseriti per verificare consistenza
     * @param user utente
     * @param vehicle veicolo
     * @return true se condizioni sono rispettate altrimenti false
     */
    public static boolean checkAll(User user, Vehicle vehicle) {
        return vehicle.requirement(user);
    }

    /**
     * calcoliamo energia consumata dal veicolo, calcoliamo la differenza tra start e end,
     * quindi togliamo energia calcolata da livello di energia di veicolo
     */
    public void takeEnergy(){
        Duration duration = Duration.between(start, end);
        double toTake = duration.toSeconds()  * vehicle.getEnergyRate(); // put .toHours() instead of .toSeconds()
        double energy = vehicle.getEnergy();
        vehicle.setEnergy(energy - toTake);
    }

    /**
     * calcoliamo soldi richiesti a utente, calcoliamo la differenza tra start e end,
     * quindi togliamo soldi calcolati da soldi di utente
     */
    public void takeCredit() {
        Duration duration = Duration.between(start, end);
        double toTake = duration.toSeconds() * vehicle.getMoneyRate(); // put .toHours() instead of .toSeconds()
        double credit = user.getCredit();
        user.setCredit(credit - toTake);
    }

    @Override
    public String toString() {
        String nominativeUser = user != null ? user.getNominative() : "null";
        String nominativeVehicle = vehicle != null ? vehicle.getNominative() : "null";
        return "{" +
                "id=" + getId() +
                ", userId=" + userId +
                ", vehicleId=" + vehicleId +
                ", start=" + start +
                ", end=" + end +
                ", user='" + nominativeUser + '\'' +
                ", vehicle='" + nominativeVehicle + '\'' +
                '}';
    }

    public static Rental fromCsv(String line) {
        String[] lines = line.split(",");
        Rental rental = new Rental(UUID.fromString(lines[1]), UUID.fromString(lines[2]));
        rental.setId(UUID.fromString(lines[0]));
        rental.setStart(lines[3].equals("null") ? null : LocalDateTime.parse(lines[3]));
        rental.setEnd(lines[4].equals("null") ? null : LocalDateTime.parse(lines[4]));
        return rental;
    }

    public static String toCsv(Rental rental) {
        return  rental.getId() + "," +
                rental.getUserId() + "," +
                rental.getVehicleId() + "," +
                rental.getStart() + "," +
                rental.getEnd();
    }

}