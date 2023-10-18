package entity;

import java.util.Objects;

public class Vehicle {

    private static int ID=0;
    private int id ;
    private String posizione;
    private boolean disponibilita;
    private boolean statoCarburante;
    private double tariffaOraria;
    private int patente;


    public Vehicle(double tariffaOraria, int patente) {
        this.id = ID++;
        this.disponibilita = true;
        this.statoCarburante = true;
        this.tariffaOraria = tariffaOraria;
        this.patente = patente;
    }

    public String getPosizione() {
        return posizione;
    }

    public boolean isDisponibilita() {
        return disponibilita;
    }

    public boolean isStatoCarburante() {
        return statoCarburante;
    }

    public double getTariffaOraria() {
        return tariffaOraria;
    }

    public int getPatente() {
        return patente;
    }
    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public void setDisponibilita(boolean disponibilita) {
        this.disponibilita = disponibilita;
    }

    public void setStatoCarburante(boolean statoCarburante) {
        this.statoCarburante = statoCarburante;
    }

    public void setTariffaOraria(double tariffaOraria) {
        this.tariffaOraria = tariffaOraria;
    }


    public int getId() {
        return id;
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
                ", statoCarburante=" + statoCarburante +
                ", tariffaOraria=" + tariffaOraria +
                ", patente=" + patente;
    }
}