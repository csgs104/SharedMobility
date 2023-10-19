package entity.tipoveicolo;

import entity.Vehicle;

public class Furgone extends Vehicle {
    private boolean carburante;
    private String targa;
    private double livelloCarburante;

    @Override
    public double getLivelloEnergia(){
        return livelloCarburante;
    }
    @Override
    public void setLivelloEnergia(double livello){
        this.livelloCarburante=livello;
    }

    public Furgone(double tariffaOraria, int patente, double consumo,String targa) {
        super(tariffaOraria, patente,consumo);
        carburante=true;
        this.targa = targa;
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
    public String toString() {
        return "Furgone{" + super.toString()+
                ", carburante=" + carburante +
                ", targa='" + targa + '\'' +
                '}';
    }
}
