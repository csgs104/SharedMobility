package entity;

import java.util.Objects;
import util.Patente;
public class User {

    private static int ID = 0;
    private final int id;
    private String name;
    private String surname;
    private String cod_fiscale;
    private String data_nascita;
    private double wallet;
    private boolean casco;

    private Patente patente;
    public User() {
        id = ID++;
    }

    public User( String name, String surname, String cod_fiscale, String data_nascita, int level_patente) {
        this.id = ID++;
        this.name = name;
        this.surname = surname;
        this.cod_fiscale = cod_fiscale;
        this.data_nascita = data_nascita;
        this.wallet = 0.0;    //nuovo utente inizialmente non ha soldi
        this.patente = new Patente(level_patente);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCod_fiscale() {
        return cod_fiscale;
    }

    public String getData_nascita() {
        return data_nascita;
    }

    public double getWallet() {
        return wallet;
    }

    public Patente getPatente() {
        return patente;
    }

    public boolean isCasco() {
        return casco;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCod_fiscale(String cod_fiscale) {
        this.cod_fiscale = cod_fiscale;
    }

    public void setData_nascita(String data_nascita) {
        this.data_nascita = data_nascita;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void setPatente(Patente patente) {
        this.patente = patente;
    }

    public void setCasco(boolean casco) {
        this.casco = casco;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cod_fiscale='" + cod_fiscale + '\'' +
                ", data_nascita='" + data_nascita + '\'' +
                ", wallet=" + wallet +
                ", patente=" + patente.toString() +
                ", casco=" + casco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}