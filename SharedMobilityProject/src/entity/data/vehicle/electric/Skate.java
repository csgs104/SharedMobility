package entity.data.vehicle.electric;

import entity.data.vehicle.ElectricVehicle;

import java.util.UUID;

public class Skate extends ElectricVehicle {

    public Skate(String name, int license, double energyRate, double moneyRate,
                 String location, boolean availability,
                 double electricityMin, double electricityLevel) {
        super(name, license, energyRate, moneyRate, location,
                availability, electricityMin, electricityLevel);
    }

    public Skate(UUID id, String name, int license, double energyRate, double moneyRate,
                 String location, boolean availability,
                 double electricityMin, double electricityLevel) {
        super(id, name, license, energyRate, moneyRate, location,
                availability, electricityMin, electricityLevel);
    }

}