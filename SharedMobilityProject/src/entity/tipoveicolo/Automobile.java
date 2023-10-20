package entity.tipoveicolo;

import entity.Vehicle;

public class Automobile extends Vehicle {

    private final String targa;
    private double livelloCarburante; // inteso come percentuale

    public Automobile(String posizione, double tariffaOraria,
                      double consumoOrario, String targa) {
        super(posizione, 2, tariffaOraria, consumoOrario);
        this.targa = targa;
        this.livelloCarburante = 100.00;
    }

    public String getTarga() {
        return targa;
    }

    @Override
    public boolean getStatoEnergia() {
        if (livelloCarburante < 5) setStatoEnergia(false);
        return super.getStatoEnergia();
    }

    @Override
    public double getLivelloEnergia(){
        return livelloCarburante;
    }

    @Override
    public void setLivelloEnergia(double livello){
        this.livelloCarburante = livello;
    }

    @Override
    public String toString() {
        return "Automobile{" + super.toString()+
                ", targa='" + targa + '\'' +
                ", livelloCarburante=" + livelloCarburante +
                '}';
    }
}
