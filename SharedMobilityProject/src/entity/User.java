package entity;

import java.util.Objects;

public class User {

    private static int ID = 0;
    private final int id;
    private String name;
    private String surname;
    private String cod_fiscale;
    private String data;
    private double wallet;
    private int patente;
    private boolean casco;

    public User() {
        id = ID++;
    }

    public User( String name, String surname, String cod_fiscale, String data, int patente) {
        this.id = ID++;
        this.name = name;
        this.surname = surname;
        this.cod_fiscale = cod_fiscale;
        this.data = data;
        this.wallet = 0.0;    //nuovo utente inizialmente non ha soldi
        this.patente = patente;
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

    public String getData() {
        return data;
    }

    public double getWallet() {
        return wallet;
    }

    public int getPatente() {
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

    public void setData(String data) {
        this.data = data;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void setPatente(int patente) {
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
                ", data='" + data + '\'' +
                ", wallet=" + wallet +
                ", patente=" + patente +
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