import database.Database;
import database.DatabaseFile;
import entity.data.License;
import entity.data.Rental;
import entity.data.User;
import entity.data.Vehicle;
import entity.data.vehicle.electric.Skate;
import entity.data.vehicle.motor.Car;
import entity.data.vehicle.motor.Scooter;
import entity.data.vehicle.motor.Van;
import entity.data.vehicle.simple.Bicycle;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path licensePath = Paths.get( "src", "file", "licenses.txt");
        Path userPath = Paths.get( "src", "file", "users.txt");
        Path vehiclePath = Paths.get( "src", "file", "vehicles.txt");
        Path rentalPath = Paths.get( "src", "file", "rentals.txt");
        Database db = new DatabaseFile(licensePath, userPath, vehiclePath, rentalPath);

        /*
        License l1 = new License(0);
        License l2 = new License(1);
        License l3 = new License(2);
        License l4 = new License(3);
        License l5 = new License(4);
        User u1 = new User("Some", "ME1", "S1", "1991-01-01", 100.00, true, l1.getId());
        User u2 = new User("Some", "ME2", "S2", "1992-02-02", 200.00, false, l2.getId());
        User u3 = new User("Some", "ME3", "S3", "1993-03-03", 300.00, true, l3.getId());
        User u4 = new User("Some", "ME4", "S4", "1994-04-04", 400.00, false, l4.getId());
        User u5 = new User("Some", "ME5", "S5", "1995-05-05", 500.00, true, l5.getId());
        Vehicle v1 = new Bicycle("Bianchi", 0,0.00,1.20,"Roma", true);
        Vehicle v2 = new Skate("XYZ", 0,1.50,2.20,"Milano", true, 10, 100);
        Vehicle v3 = new Scooter("Honda", 1,2.50,3.10, "Torino", true, "SCR1", 5, 100);
        Vehicle v4 = new Car("Fiat", 2,3.50,4.10, "Trieste", true, "CAR1", 8, 100);
        Vehicle v5 = new Van("Nissan", 3,3.50,4.10, "Verona", true, "VAN1", 8, 100);
        db.putLicense(l1);
        db.putLicense(l2);
        db.putLicense(l3);
        db.putLicense(l4);
        db.putLicense(l5);
        db.putUser(u1);
        db.putUser(u2);
        db.putUser(u3);
        db.putUser(u4);
        db.putUser(u5);
        db.putVehicle(v1);
        db.putVehicle(v2);
        db.putVehicle(v3);
        db.putVehicle(v4);
        db.putVehicle(v5);
        Rental r1 = db.rent(u1, v5);
        Rental r2 = db.rent(u2, v2);
        Rental r3 = db.rent(u3, v3);
        Rental r4 = db.rent(u4, v4);
        Rental r5 = db.rent(u5, v1);
        */
        db.printLicenses();
        System.out.println();
        db.printUsers();
        System.out.println();
        db.printVehicles();
        System.out.println();
        db.printRentals();
        System.out.println();
        // db.startRental(r1.getId());
        // db.startRental(r2.getId());
        // db.startRental(r3.getId());
        // Thread.sleep(12000);
        // db.endRental(r1.getId());
        // db.endRental(r2.getId());
        // db.endRental(r3.getId());
        // db.printRentals();

        // System.out.println();
        // db.printUsers();

        // System.out.println();
        // db.printVehicles();
    }

}