package entity.tipoveicolo;

import entity.Vehicle;

public class Monopattino extends Vehicle {
    private boolean elettricita;
    private double livelloElettricita;

    @Override
    public double getLivelloEnergia(){
        return livelloElettricita;
    }
    @Override
    public void setLivelloEnergia(double livello){
        this.livelloElettricita=livello;
    }

    public Monopattino(double tariffaOraria, int patente,double consumo) {
        super(tariffaOraria, patente,consumo);
        this.elettricita=true;
        this.livelloElettricita=100.00;
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
