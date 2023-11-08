package entity.data.vehicle.motor;

import entity.data.vehicle.MotorVehicle;

import java.util.UUID;

public class Van extends MotorVehicle {

    public Van(String name, int license, double energyRate, double moneyRate,
               String location, boolean availability, String plate,
               double fuelMin, double fuelLevel) {
        super(name, license, energyRate, moneyRate, location,
                availability, plate, fuelMin, fuelLevel);
    }

    public Van(UUID id, String name, int license, double energyRate, double moneyRate,
                 String location, boolean availability, String plate,
                 double fuelMin, double fuelLevel) {
        super(id, name, license, energyRate, moneyRate, location,
                availability, plate, fuelMin, fuelLevel);
    }

}