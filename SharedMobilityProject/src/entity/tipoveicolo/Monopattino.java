package entity.tipoveicolo;

import entity.Vehicle;

public class Monopattino extends Vehicle {

    private double livelloElettricita;

    public Monopattino(String posizione, double tariffaOraria, double consumoOrario) {
        super(posizione, 0, tariffaOraria, consumoOrario);
        this.livelloElettricita = 100.00;
    }

    @Override
    public boolean getStatoEnergia() {
        if (livelloElettricita < 10) setStatoEnergia(false);
        return super.getStatoEnergia();
    }

    @Override
    public String toString() {
        return "Monopattino{" + super.toString() +
                ", livelloElettricita='" + livelloElettricita + '\'' +
                '}';
    }

    @Override
    public double getLivelloEnergia(){
        return livelloElettricita;
    }

    @Override
    public void setLivelloEnergia(double livello){
        this.livelloElettricita = livello;
    }

}
