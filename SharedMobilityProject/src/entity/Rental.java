package entity;

import java.time.Duration;
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

    /**
     * Facciamo un check dei dati inseriti, verificando la consistenza dei dati
     * @param user utente
     * @param vehicle veicolo
     * @return true se tutto ok e false se è andato male qualcosa
     */
    public static boolean checkAll(User user, Vehicle vehicle) {
        if (user.getPatente().getLivello() > vehicle.getLivelloPatente() || !vehicle.getDisponibilita()
                || !vehicle.getStatoEnergia() || user.getWallet() < 0 || !vehicle.isEquipaggiato(user)) {
            return false;
        }
        else return true;
    }

    /**
     * Togliamo il carburante al veicolo, calcoliamo la differenza in ore tra data di start e  data di end,
     * quindi calcoliamo il consumo totale e lo togliamo dal livello di energia
     */
    public void togliCarburante(){
        Duration duration = Duration.between(start, end);
        double price = duration.toSeconds()  * vehicle.getConsumoOrario(); // da rimettere .toHours()
        double energia = vehicle.getLivelloEnergia();
        vehicle.setLivelloEnergia(energia - price);
    }

    /**
     * Togliamo i soldi all'utente, calcoliamo la differenza in ore tra data di start e  data di end,
     * quindi calcoliamo il prezzo totale e lo togliamo dal wallet
     */
    public void togliSoldi() {
        Duration duration = Duration.between(start, end);
        double price = duration.toSeconds() * vehicle.getTariffaOraria(); // da rimettere .toHours()
        double wallet = user.getWallet();
        user.setWallet(wallet - price);
    }

}
