package entity.tipoveicolo;

import entity.Vehicle;

public class Bicicletta extends Vehicle {
    //casco
    public Bicicletta(double tariffaOraria, int patente) {
        super(tariffaOraria,patente);
    }

    @Override
    public String toString() {
        return "Bicicletta{"+super.toString()+"}";
    }
}
