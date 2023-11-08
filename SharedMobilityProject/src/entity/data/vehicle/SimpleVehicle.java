package entity.data.vehicle;

import entity.data.Vehicle;

import java.util.UUID;

public class SimpleVehicle extends Vehicle {

    public SimpleVehicle(String name, int level, double energyRate, double moneyRate,
                         String location, boolean availability) {
        super(name, level, energyRate, moneyRate, location, availability);
    }

    public SimpleVehicle(UUID id, String name, int level, double energyRate, double moneyRate,
                         String location, boolean availability) {
        super(id, name, level, energyRate, moneyRate, location, availability);
    }

    @Override
    public double getEnergy() {
        return 0.0;
    }

    @Override
    public void setEnergy(double level) {
        return;
    }

    @Override
    public boolean hasEnergy() {
        return true;
    }

    public static Vehicle fromCsv(String[] lines) {
        Vehicle vehicle = new SimpleVehicle(lines[1], Integer.parseInt(lines[2]),
                Double.parseDouble(lines[3]), Double.parseDouble(lines[4]),
                lines[5], Boolean.parseBoolean(lines[6]));
        vehicle.setId(UUID.fromString(lines[0]));
        return vehicle;
    }

    public static String toCsv(Vehicle vehicle) {
        SimpleVehicle motorVehicle = (SimpleVehicle) vehicle;
        return  motorVehicle.getId() + "," +
                motorVehicle.getLevel() + "," +
                motorVehicle.getEnergy() + "," +
                motorVehicle.getMoneyRate() + "," +
                motorVehicle.getLocation() + "," +
                motorVehicle.getAvailability();
    }

}