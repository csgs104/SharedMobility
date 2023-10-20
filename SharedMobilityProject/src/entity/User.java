package entity;

import java.util.Objects;

public class User {

    private static int ID = 0;
    private final int id;
    private String name;
    private String surname;
    private String codFiscale;
    private String dataNascita;
    private double wallet;
    private boolean casco;
    private Patente patente;

    public User(String name, String surname, String codFiscale, String dataNascita, int levelPatente) {
        this.id = ID++;
        this.name = name;
        this.surname = surname;
        this.codFiscale = codFiscale;
        this.dataNascita = dataNascita;
        this.wallet = 0.0; // nuovo utente inizialmente non ha soldi
        this.patente = new Patente(levelPatente);
        this.casco = false;
    }
    public User(int id, String name, String surname, String codFiscale, String dataNascita, double wallet, int levelPatente,boolean casco) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.codFiscale = codFiscale;
        this.dataNascita = dataNascita;
        this.wallet = wallet;
        this.patente = new Patente(levelPatente);
        this.casco = casco;
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

    public String getCodFiscale() {
        return codFiscale;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public double getWallet() {
        return wallet;
    }

    public Patente getPatente() {
        return patente;
    }

    public boolean getCasco() {
        return casco;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCodFiscale(String codFiscale) {
        this.codFiscale = codFiscale;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
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

    public static User readByCsv(String user_string){
        String[] attributi = user_string.split(",");
        // creiamo un oggetto utente a partire dagli attributi recuperati dalla riga del csv
        return new User(Integer.parseInt(attributi[0]), attributi[1], attributi[2], attributi[3],
                attributi[4], Double.parseDouble(attributi[5]), Integer.parseInt(attributi[6]),
                Boolean.parseBoolean(attributi[7]));
    }

    public String writeToCsv(){
        return this.id + "," + this.name + "," + this.surname + "," + this.codFiscale + ","
                + this.dataNascita + "," + this.wallet + "," + this.patente.toString() + "," + this.casco;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cod_fiscale='" + codFiscale + '\'' +
                ", data_nascita='" + dataNascita + '\'' +
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