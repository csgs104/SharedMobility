package entity.data;

import entity.Entity;
import entity.data.vehicle.ElectricVehicle;
import entity.data.vehicle.MotorVehicle;
import entity.data.vehicle.SimpleVehicle;

import java.util.UUID;

public abstract class Vehicle extends Entity {

    private final String name;
    private final int level;
    private final double energyRate;
    private final double moneyRate;
    private String location;
    private boolean availability;

    public Vehicle(UUID id, String name, int level, double energyRate, double moneyRate, String location, boolean availability) {
        super(id);
        this.name = name;
        this.level = level;
        this.energyRate = energyRate;
        this.moneyRate = moneyRate;
        this.location = location;
        this.availability = availability;
    }

    public Vehicle(String name, int level, double energyRate, double moneyRate, String location, boolean availability) {
        super();
        this.name = name;
        this.level = level;
        this.energyRate = energyRate;
        this.moneyRate = moneyRate;
        this.location = location;
        this.availability = availability;
    }

    public Vehicle(String name, int level, double energyRate, double moneyRate, String location) {
        super();
        this.name = name;
        this.level = level;
        this.energyRate = energyRate;
        this.moneyRate = moneyRate;
        this.location = location;
        this.availability = true;
    }

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public double getEnergyRate() {
        return energyRate;
    }
    public double getMoneyRate() {
        return moneyRate;
    }
    public String getLocation() {
        return location;
    }
    public boolean getAvailability() {
        return availability;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getNominative() {
        String[] nominative = getClass().getName().split("\\.");
        return nominative[nominative.length - 1];
    }

    public String getType() {
        String[] nominative = getClass().getName().split("\\.");
        return nominative[nominative.length - 2];
    }

    public abstract double getEnergy();
    public abstract void setEnergy(double energy);
    public abstract boolean hasEnergy();

    public boolean requirement(User user) {
        return hasEnergy() && user.getLicense() != null && user.getLicense().getLevel() >= level && availability && user.getCredit() > 0;
    }

    @Override
    public String toString() {
        return "{" +
                ", id=" + getId() +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", energyRate=" + energyRate +
                ", moneyRate=" + moneyRate +
                ", location='" + location + '\'' +
                ", availability=" + availability +
                '}';
    }

    public static Vehicle fromCsv(String line) {
        String[] lines = line.split(",");
        return switch (lines[lines.length - 1]) {
            case "simple" -> SimpleVehicle.fromCsv(lines);
            case "electric" -> ElectricVehicle.fromCsv(lines);
            case "motor" -> MotorVehicle.fromCsv(lines);
            default -> null;
        };
    }

    public static String toCsv(Vehicle vehicle) {
        return switch (vehicle.getType()) {
            case "simple" -> SimpleVehicle.toCsv(vehicle) + "," + vehicle.getType();
            case "electric" -> ElectricVehicle.toCsv(vehicle) + "," + vehicle.getType();
            case "motor" -> MotorVehicle.toCsv(vehicle) + "," + vehicle.getType();
            default -> "";
        };
    }

}