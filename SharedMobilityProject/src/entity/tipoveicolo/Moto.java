package entity.tipoveicolo;

import entity.Vehicle;

public class Moto extends Vehicle {
    //casco
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

    public Moto(double tariffaOraria, int patente,double consumo,String targa) {
        super(tariffaOraria, patente,consumo);
        this.targa=targa;
        this.livelloCarburante=100.00;
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
