package entity.tipoveicolo;

import entity.User;
import entity.Vehicle;

public class Moto extends Vehicle {
    // casco
    private final String targa;
    private double livelloCarburante;

    public Moto(String posizione, double tariffaOraria,
                double consumoOrario, String targa) {
        super(posizione, 1, tariffaOraria, consumoOrario);
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
        return "Moto{" + super.toString()+
                ", targa='" + targa + '\'' +
                ", livelloCarburante='" + livelloCarburante + '\'' +
                '}';
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
    public boolean isEquipaggiato(User user) {
        return user.getCasco();
    }

}
