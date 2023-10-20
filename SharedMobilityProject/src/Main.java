import database.Database;
import database.DatabaseFile;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        DatabaseFile db_file = new DatabaseFile(Paths.get("SharedMobilityProject", "src", "files", "users.txt"));
        // Users
        /*User u1 = new User("Cristian", "Torrisi",
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
        Vehicle v1 = new Automobile(12.00,2,"abc123abc");
        Vehicle v2 = new Monopattino(8.0,2);
        Vehicle v3 = new Furgone(20.00,2,"cdcdcdcd");
        Vehicle v4 = new Bicicletta(10.00,2);
        Vehicle v5 = new Moto(11.00,2,"ffssaa");

        database.addUser(u1);
        database.addUser(u2);
        database.addUser(u3);
        database.addUser(u4);
        database.addUser(u5);
        // database.printUsers();

        database.addVehicle(v1);
        database.addVehicle(v2);
        database.addVehicle(v3);
        database.addVehicle(v4);
        database.addVehicle(v5);
        // database.printVehicles();

        database.addRental(u1, v1);
        database.addRental(u2, v2);
        database.addRental(u3, v3);
        database.addRental(u4, v4);
        database.addRental(u5, v5);
        // database.printRentals();*/


    }
}