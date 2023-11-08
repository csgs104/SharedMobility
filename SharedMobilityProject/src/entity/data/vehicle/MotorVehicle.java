package entity.data.vehicle;

import entity.data.Vehicle;
import entity.data.vehicle.motor.Car;
import entity.data.vehicle.motor.Scooter;
import entity.data.vehicle.motor.Truck;
import entity.data.vehicle.motor.Van;
import entity.data.vehicle.simple.Bicycle;

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
        return switch (lines[lines.length - 2].toLowerCase()) {
            case "car" -> new Car(UUID.fromString(lines[0]), lines[1], Integer.parseInt(lines[2]),
                    Double.parseDouble(lines[3]), Double.parseDouble(lines[4]),
                    lines[5], Boolean.parseBoolean(lines[6]), lines[7],
                    Double.parseDouble(lines[8]), Double.parseDouble(lines[9]));
            case "scooter" -> new Scooter(UUID.fromString(lines[0]), lines[1], Integer.parseInt(lines[2]),
                    Double.parseDouble(lines[3]), Double.parseDouble(lines[4]),
                    lines[5], Boolean.parseBoolean(lines[6]), lines[7],
                    Double.parseDouble(lines[8]), Double.parseDouble(lines[9]));
            case "truck" -> new Truck(UUID.fromString(lines[0]), lines[1], Integer.parseInt(lines[2]),
                    Double.parseDouble(lines[3]), Double.parseDouble(lines[4]),
                    lines[5], Boolean.parseBoolean(lines[6]), lines[7],
                    Double.parseDouble(lines[8]), Double.parseDouble(lines[9]));
            case "van" -> new Van(UUID.fromString(lines[0]), lines[1], Integer.parseInt(lines[2]),
                    Double.parseDouble(lines[3]), Double.parseDouble(lines[4]),
                    lines[5], Boolean.parseBoolean(lines[6]), lines[7],
                    Double.parseDouble(lines[8]), Double.parseDouble(lines[9]));
            default -> null;
        };
    }

    public static String toCsv(Vehicle vehicle) {
        String nominative = vehicle.getNominative();
        MotorVehicle motorVehicle = (MotorVehicle) vehicle;
        return  motorVehicle.getId() + "," +
                motorVehicle.getName() + "," +
                motorVehicle.getLevel() + "," +
                motorVehicle.getEnergyRate() + "," +
                motorVehicle.getMoneyRate() + "," +
                motorVehicle.getLocation() + "," +
                motorVehicle.getAvailability() + "," +
                motorVehicle.getPlate() + "," +
                motorVehicle.getFuelMin() + "," +
                motorVehicle.getFuelLevel() + "," +
                nominative;
    }

}