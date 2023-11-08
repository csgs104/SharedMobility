package entity.data.vehicle.simple;

import entity.data.User;
import entity.data.vehicle.SimpleVehicle;

import java.util.UUID;

public class Bicycle extends SimpleVehicle {

    public Bicycle(String name, int license, double energyRate, double moneyRate,
                   String location, boolean availability) {
        super(name, license, energyRate, moneyRate, location, availability);
    }

    public Bicycle(UUID id, String name, int license, double energyRate, double moneyRate,
                   String location, boolean availability) {
        super(id, name, license, energyRate, moneyRate, location, availability);
    }

    @Override
    public boolean requirement(User user) {
        return super.requirement(user) && user.getHelmet();
    }

}