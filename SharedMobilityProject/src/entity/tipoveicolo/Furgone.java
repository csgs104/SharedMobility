package entity.tipoveicolo;

import entity.Vehicle;

public class Furgone extends Vehicle {
    private String targa;
    private double livelloCarburante;

    public Furgone(String posizione, double tariffaOraria,
                   double consumoOrario, String targa) {
        super(posizione, 3, tariffaOraria, consumoOrario);
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
    public String toString() {
        return "Furgone{" + super.toString()+
                ", targa='" + targa + '\'' +
                ", livelloCarburante=" + livelloCarburante +
                '}';
    }

    @Override
    public double getLivelloEnergia(){
        return livelloCarburante;
    }

    @Override
    public void setLivelloEnergia(double livello){
        this.livelloCarburante=livello;
    }

}
