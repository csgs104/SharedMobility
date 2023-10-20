package entity;

import java.util.Objects;

public class Vehicle {

    private static int ID = 0;
    private int id;
    private String posizione;
    private boolean disponibilita;
    private boolean statoEnergia;
    private final int livelloPatente;
    private double tariffaOraria;
    private double consumoOrario;

    public Vehicle(String posizione, int livelloPatente, double tariffaOraria, double consumoOrario) {
        this.id = ID++;
        this.posizione = posizione;
        this.disponibilita = true;
        this.statoEnergia = true;
        this.livelloPatente = livelloPatente;
        this.tariffaOraria = tariffaOraria;
        this.consumoOrario = consumoOrario;
    }

    public int getId() {
        return id;
    }

    public String getPosizione() {
        return posizione;
    }

    public boolean getDisponibilita() {
        return disponibilita;
    }

    public boolean getStatoEnergia() {
        return statoEnergia;
    }

    public int getLivelloPatente() {
        return livelloPatente;
    }

    public double getTariffaOraria() {
        return tariffaOraria;
    }

    public double getConsumoOrario() {
        return consumoOrario;
    }


    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public void setDisponibilita(boolean disponibilita) {
        this.disponibilita = disponibilita;
    }

    public void setStatoEnergia(boolean statoCarburante) {
        this.statoEnergia = statoCarburante;
    }

    public void setTariffaOraria(double tariffaOraria) {
        this.tariffaOraria = tariffaOraria;
    }

    public void setConsumoOrario(double consumoOrario) {
        this.consumoOrario = consumoOrario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", posizione='" + posizione + '\'' +
                ", disponibilita=" + disponibilita +
                ", statoEnergia=" + statoEnergia +
                ", tariffaOraria=" + tariffaOraria +
                ", consumoOrario=" + consumoOrario +
                ", patente=" + livelloPatente;
    }

    public double getLivelloEnergia(){
        return 0.0;
    }

    public void setLivelloEnergia(double livello) {   }

    public boolean isEquipaggiato(User user) {
        return true;
    }

}