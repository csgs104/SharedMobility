import database.Database;
import database.DatabaseFile;
import entity.Rental;
import entity.User;
import entity.Vehicle;
import entity.tipoveicolo.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Database db = new Database();
        Database dbFile = new DatabaseFile(Paths.get( "src", "files", "users.txt"));
        // Users
        User u1 = new User("Cristian", "Torrisi",
                "CRSTN12TRRS345", "2001-01-31", 2);
        User u2 = new User("Stefano", "Casagrande",
                "STFN67CSGRND89", "1998-04-26", 0);
        User u3 = new User("Davide", "Cruciata",
                "DVD123CRCT4567", "2000-08-30", 3);
        User u4 = new User("Anonimo", "Qualcuno",
                "NNM9876QLCN543", "1980-12-11", 1);
        User u5 = new User("Viola", "Natale",
                "VLO9876NTLE543", "2004-03-01", 0);

        // Vehicles
        Vehicle v1 = new Automobile("Roma", 2.55,2.00,"abc123abc");
        Vehicle v2 = new Monopattino("Milano",1.15, 0.50);
        Vehicle v3 = new Furgone("Torino", 10.00,5.50,"cdcdcdcd");
        Vehicle v4 = new Bicicletta("Napoli", 40.40);
        Vehicle v5 = new Moto("Verona", 0.90,60,"ffssaa");
        dbFile.addUser(u1);
        dbFile.addUser(u2);
        dbFile.addUser(u3);
        dbFile.addUser(u4);
        dbFile.addUser(u5);
        dbFile.printUsers();
        System.out.println("");

        dbFile.addVehicle(v1);
        dbFile.addVehicle(v2);
        dbFile.addVehicle(v3);
        dbFile.addVehicle(v4);
        dbFile.addVehicle(v5);
        dbFile.printVehicles();
        System.out.println();

        Rental r0 = dbFile.rent(u1, v1);
        Rental r1 = dbFile.rent(u2, v2);
        Rental r2 = dbFile.rent(u3, v3);
        Rental r3 = dbFile.rent(u4, v4);
        Rental r4 = dbFile.rent(u5, v5);
        dbFile.printRentals();
        System.out.println();

        dbFile.startRental(r0.getId());
        dbFile.startRental(r1.getId());
        dbFile.startRental(r2.getId());
        Thread.sleep(12000);
        dbFile.endRental(r0.getId());
        dbFile.endRental(r1.getId());
        dbFile.endRental(r2.getId());
        dbFile.printRentals();

        System.out.println();
        dbFile.printUsers();

        System.out.println();
        dbFile.printVehicles();
    }
}