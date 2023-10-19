package entity.tipoveicolo;

import entity.Vehicle;

public class Automobile extends Vehicle {

    private String targa;
    private boolean carburante;
    private double livelloCarburante;//inteso come percentuale

    public Automobile(double tariffaOraria, int patente,double consumo,String targa) {
        super(tariffaOraria,patente,consumo);
        this.targa = targa;
        this.carburante = true;
        this.livelloCarburante=100.00;
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
    public double getLivelloEnergia(){
        return livelloCarburante;
    }
    @Override
    public void setLivelloEnergia(double livello){
        this.livelloCarburante=livello;
    }

    @Override
    public String toString() {
        return "Automobile{" + super.toString()+
                ", targa='" + targa + '\'' +
                ", carburante=" + carburante +
                '}';
    }
}
