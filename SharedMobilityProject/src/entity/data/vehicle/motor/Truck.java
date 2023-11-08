package entity.data.vehicle.motor;

import entity.data.vehicle.MotorVehicle;

public class Truck extends MotorVehicle {

    public Truck(String name, int license, double energyRate, double moneyRate,
                 String location, boolean availability, String plate,
                 double fuelMin, double fuelLevel) {
        super(name, license, energyRate, moneyRate, location,
                availability, plate, fuelMin, fuelLevel);
    }

}