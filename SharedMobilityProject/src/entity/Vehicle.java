package entity;

import java.util.Objects;

public class Vehicle {

    private static int ID=0;
    private boolean statoEnergia;
    private int id ;
    private String posizione;
    private boolean disponibilita;

    private double tariffaOraria;
    private int livello_patente;
    private double consumoOrario;


    public Vehicle(double tariffaOraria, int livello_patente,double consumo) {
        this.id = ID++;
        this.disponibilita = true;
        this.statoEnergia = true;
        this.tariffaOraria = tariffaOraria;
        this.livello_patente = livello_patente;
        this.consumoOrario=consumo;
    }

    public double getConsumoOrario() {
        return consumoOrario;
    }

    public void setConsumoOrario(double consumoOrario) {
        this.consumoOrario = consumoOrario;
    }

    public String getPosizione() {
        return posizione;
    }

    public boolean getDisponibilita() {
        return disponibilita;
    }

    public double getTariffaOraria() {
        return tariffaOraria;
    }

    public int getPatente() {
        return livello_patente;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public boolean getStatoEnergia() {
        return statoEnergia;
    }
    public double getLivelloEnergia(){
        return 0.0;
    }
    public void setLivelloEnergia(double livello){   }

    public void setDisponibilita(boolean disponibilita) {
        this.disponibilita = disponibilita;
    }

    public void setStatoEnergia(boolean statoCarburante) {
        this.statoEnergia = statoCarburante;
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
                ", statoEnergia=" + statoEnergia +
                ", tariffaOraria=" + tariffaOraria +
                ", patente=" + livello_patente;
    }
}