package entity.data.vehicle;

import entity.data.Vehicle;

import java.util.UUID;

public class MotorVehicle extends Vehicle {

    private final String plate;
    private final double fuelMin;
    private double fuelLevel;

    public MotorVehicle(String name, int level, double energyRate, double moneyRate,
                        String location, boolean availability,
                        String plate, double fuelMin, double fuelLevel) {
        super(name, level, energyRate, moneyRate, location, availability);
        this.plate = plate;
        this.fuelMin = fuelMin;
        this.fuelLevel = fuelLevel;
    }

    public MotorVehicle(UUID id, String name, int level, double energyRate, double moneyRate,
                        String location, boolean availability,
                        String plate, double fuelMin, double fuelLevel) {
        super(id, name, level, energyRate, moneyRate, location, availability);
        this.plate = plate;
        this.fuelMin = fuelMin;
        this.fuelLevel = fuelLevel;
    }

    @Override
    public double getEnergy() {
        return fuelLevel;
    }

    @Override
    public void setEnergy(double level) {
        this.fuelLevel = level;
    }

    @Override
    public boolean hasEnergy() {
        return fuelLevel > fuelMin;
    }

    public String getPlate() {
        return plate;
    }

    public double getFuelMin() {
        return fuelMin;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public static Vehicle fromCsv(String[] lines) {
        Vehicle vehicle = new MotorVehicle(lines[1], Integer.parseInt(lines[2]),
                Double.parseDouble(lines[3]), Double.parseDouble(lines[4]),
                lines[5], Boolean.parseBoolean(lines[6]), lines[7],
                Integer.parseInt(lines[8]), Integer.parseInt(lines[9]));
        vehicle.setId(UUID.fromString(lines[0]));
        return vehicle;
    }

    public static String toCsv(Vehicle vehicle) {
        MotorVehicle motorVehicle = (MotorVehicle) vehicle;
        return  motorVehicle.getId() + "," +
                motorVehicle.getLevel() + "," +
                motorVehicle.getEnergy() + "," +
                motorVehicle.getMoneyRate() + "," +
                motorVehicle.getLocation() + "," +
                motorVehicle.getAvailability() + "," +
                motorVehicle.getPlate() + "," +
                motorVehicle.getFuelMin() + "," +
                motorVehicle.getFuelLevel();
    }

}