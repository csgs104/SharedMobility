package entity.tipoveicolo;

import entity.Vehicle;

public class Monopattino extends Vehicle {
    private boolean elettricita;

    public Monopattino(double tariffaOraria, int patente) {
        super(tariffaOraria, patente);
        this.elettricita=true;
    }

    public boolean isElettricita() {
        return elettricita;
    }

    public void setElettricita(boolean elettricita) {
        this.elettricita = elettricita;
    }

    @Override
    public String toString() {
        return "Monopattino{" + super.toString()+
                ", elettricita=" + elettricita +
                '}';
    }
}
