package entity.tipoveicolo;

import entity.User;
import entity.Vehicle;

public class Bicicletta extends Vehicle {

    public Bicicletta(String posizione, double tariffaOraria) {
        super(posizione, 0, tariffaOraria,0.0);
    }

    @Override
    public String toString() {
        return "Bicicletta{"+super.toString()+"}";
    }

    @Override
    public boolean isEquipaggiato(User user) {
        return user.getCasco();
    }

}
