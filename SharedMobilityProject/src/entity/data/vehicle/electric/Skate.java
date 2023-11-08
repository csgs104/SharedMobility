package entity.data.vehicle.electric;

import entity.data.vehicle.ElectricVehicle;

public class Skate extends ElectricVehicle {

    public Skate(String name, int license, double energyRate, double moneyRate,
                 String location, boolean availability,
                 double electricityMin, double electricityLevel) {
        super(name, license, energyRate, moneyRate, location,
                availability, electricityMin, electricityLevel);
    }

}