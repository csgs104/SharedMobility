package entity.data.vehicle;

import entity.data.Vehicle;
import entity.data.vehicle.electric.Skate;

import java.util.UUID;

public class ElectricVehicle extends Vehicle {

    private final double batteryMin;
    private double batteryLevel;

    public ElectricVehicle(String name, int level, double energyRate, double moneyRate,
                           String location, boolean availability,
                           double batteryMin, double batteryLevel) {
        super(name, level, energyRate, moneyRate, location, availability);
        this.batteryMin = batteryMin;
        this.batteryLevel = batteryLevel;
    }

    public ElectricVehicle(UUID id, String name, int level, double energyRate, double moneyRate,
                           String location, boolean availability,
                           double batteryMin, double batteryLevel) {
        super(id, name, level, energyRate, moneyRate, location, availability);
        this.batteryMin = batteryMin;
        this.batteryLevel = batteryLevel;
    }

    @Override
    public double getEnergy() {
        return batteryLevel;
    }

    @Override
    public void setEnergy(double level) {
        this.batteryLevel = level;
    }

    @Override
    public boolean hasEnergy() {
        return batteryLevel > batteryMin;
    }

    public double getBatteryMin() {
        return batteryMin;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public static Vehicle fromCsv(String[] lines) {
        return switch (lines[lines.length - 2].toLowerCase()) {
            case "skate" -> new Skate(UUID.fromString(lines[0]), lines[1], Integer.parseInt(lines[2]),
                    Double.parseDouble(lines[3]), Double.parseDouble(lines[4]),
                    lines[5], Boolean.parseBoolean(lines[6]),
                    Double.parseDouble(lines[7]), Double.parseDouble(lines[8]));
            default -> null;
        };
    }

    public static String toCsv(Vehicle vehicle) {
        String nominative = vehicle.getNominative();
        ElectricVehicle electricVehicle = (ElectricVehicle) vehicle;
        return  electricVehicle.getId() + "," +
                electricVehicle.getName() + "," +
                electricVehicle.getLevel() + "," +
                electricVehicle.getEnergyRate() + "," +
                electricVehicle.getMoneyRate() + "," +
                electricVehicle.getLocation() + "," +
                electricVehicle.getAvailability() + "," +
                electricVehicle.getBatteryMin() + "," +
                electricVehicle.getBatteryLevel() + "," +
                nominative;
    }


}