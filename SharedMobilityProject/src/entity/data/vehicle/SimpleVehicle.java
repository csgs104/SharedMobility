package entity.data.vehicle;

import entity.data.Vehicle;
import entity.data.vehicle.electric.Skate;
import entity.data.vehicle.simple.Bicycle;

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
        return switch (lines[lines.length - 2].toLowerCase()) {
            case "bicycle" -> new Bicycle(UUID.fromString(lines[0]), lines[1], Integer.parseInt(lines[2]),
                    Double.parseDouble(lines[3]), Double.parseDouble(lines[4]),
                    lines[5], Boolean.parseBoolean(lines[6]));
            default -> null;
        };
    }

    public static String toCsv(Vehicle vehicle) {
        String nominative = vehicle.getNominative();
        SimpleVehicle simpleVehicle = (SimpleVehicle) vehicle;
        return  simpleVehicle.getId() + "," +
                simpleVehicle.getName() + "," +
                simpleVehicle.getLevel() + "," +
                simpleVehicle.getEnergyRate() + "," +
                simpleVehicle.getMoneyRate() + "," +
                simpleVehicle.getLocation() + "," +
                simpleVehicle.getAvailability() + "," +
                nominative;
    }

}