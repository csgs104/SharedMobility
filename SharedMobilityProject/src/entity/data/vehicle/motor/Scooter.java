package entity.data.vehicle.motor;

import entity.data.User;
import entity.data.vehicle.MotorVehicle;

import java.util.UUID;

public class Scooter extends MotorVehicle {

    public Scooter(String name, int license, double energyRate, double moneyRate,
                   String location, boolean availability, String plate,
                   double fuelMin, double fuelLevel) {
        super(name, license, energyRate, moneyRate, location,
                availability, plate, fuelMin, fuelLevel);
    }

    public Scooter(UUID id, String name, int license, double energyRate, double moneyRate,
               String location, boolean availability, String plate,
               double fuelMin, double fuelLevel) {
        super(id, name, license, energyRate, moneyRate, location,
                availability, plate, fuelMin, fuelLevel);
    }

    @Override
    public boolean requirement(User user) {
        return super.requirement(user) && user.getHelmet();
    }

}