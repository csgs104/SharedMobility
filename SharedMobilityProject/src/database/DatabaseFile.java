package database;

import entity.User;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class DatabaseFile extends Database{

    private final Path path_file ;

    public DatabaseFile(Path path)  {
        this.path_file = path;
        try {
            readUtenti();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addUser(User user) {
        getUserTable().put(user.getId(), user);
        try {
            saveFileUtenti();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void deleteUser(Integer userId) {
        getUserTable().remove(userId);
        try {
            saveFileUtenti();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public User registration(User user) {
        User user_in = getUserTable().put(user.getId(), user);
        try {
            saveFileUtenti();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return user_in;
    }


    private void readUtenti() throws  IOException {
        List<String> utentiString = Files.readAllLines(path_file);

        for (String s : utentiString) {
            User utente = User.readByCsv(s);
            getUserTable().put(utente.getId(), utente);
        }
    }

        private void saveFileUtenti() throws IOException {
            BufferedWriter bw = Files.newBufferedWriter(path_file);

            for (User utente : getUserTable().values()) {
                bw.write(utente.writeToCsv());
                bw.newLine();
            }

            bw.close();
        }
}
