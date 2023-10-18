package entity.tipoveicolo;

import entity.Vehicle;

public class Automobile extends Vehicle {

    private String targa;
    private boolean carburante;

    public Automobile(double tariffaOraria, int patente,String targa) {
        super(tariffaOraria,patente);
        this.targa = targa;
        this.carburante = true;
    }

    public boolean isCarburante() {
        return carburante;
    }

    public void setCarburante(boolean carburante) {
        this.carburante = carburante;
    }

    public String getTarga() {
        return targa;
    }

    @Override
    public String toString() {
        return "Automobile{" + super.toString()+
                ", targa='" + targa + '\'' +
                ", carburante=" + carburante +
                '}';
    }
}
