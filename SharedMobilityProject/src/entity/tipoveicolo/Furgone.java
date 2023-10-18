package entity.tipoveicolo;

import entity.Vehicle;

public class Furgone extends Vehicle {
    private boolean carburante;
    private String targa;

    public Furgone(double tariffaOraria, int patente, String targa) {
        super(tariffaOraria, patente);
        carburante=true;
        this.targa = targa;
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
        return "Furgone{" + super.toString()+
                ", carburante=" + carburante +
                ", targa='" + targa + '\'' +
                '}';
    }
}
