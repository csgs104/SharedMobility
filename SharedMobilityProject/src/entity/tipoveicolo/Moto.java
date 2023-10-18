package entity.tipoveicolo;

import entity.Vehicle;

public class Moto extends Vehicle {
    //casco
    private String targa;

    public Moto(double tariffaOraria, int patente,String targa) {
        super(tariffaOraria, patente);
        this.targa=targa;
    }

    public String getTarga() {
        return targa;
    }

    @Override
    public String toString() {
        return "Moto{" + super.toString()+
                ", targa='" + targa + '\'' +
                '}';
    }
}
