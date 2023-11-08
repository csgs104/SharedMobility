package entity.data;

import entity.Entity;

import java.util.Objects;
import java.util.UUID;

public class User extends Entity {

    private final String name;
    private final String surname;
    private final String code;
    private final String birth;
    private double credit;
    private boolean helmet;
    private final UUID licenseId;
    private License license = null;

    public User(String name, String surname, String code, String birth, double credit, boolean helmet, UUID licenseId) {
        super();
        this.name = name;
        this.surname = surname;
        this.code = code;
        this.birth = birth;
        this.credit = credit;
        this.helmet = helmet;
        this.licenseId = licenseId;
    }

    public User(UUID id, String name, String surname, String code, String birth, double credit, boolean helmet, UUID licenseId) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.code = code;
        this.birth = birth;
        this.credit = credit;
        this.helmet = helmet;
        this.licenseId = licenseId;
    }

    public User(String name, String surname, String code, String birth, double credit, boolean helmet, UUID licenseId, License license) {
        super();
        this.name = name;
        this.surname = surname;
        this.code = code;
        this.birth = birth;
        this.credit = credit;
        this.helmet = helmet;
        this.licenseId = licenseId;
        this.license = license;
    }

    public User(UUID id, String name, String surname, String code, String birth, double credit, boolean helmet, UUID licenseId, License license) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.code = code;
        this.birth = birth;
        this.credit = credit;
        this.helmet = helmet;
        this.licenseId = licenseId;
        this.license = license;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getCode() {
        return code;
    }
    public String getBirth() {
        return birth;
    }
    public double getCredit() {
        return credit;
    }
    public boolean getHelmet() {
        return helmet;
    }
    public UUID getLicenseId() {
        return licenseId;
    }
    public License getLicense() {
        return license;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
    public void setHelmet(boolean helmet) {
        this.helmet = helmet;
    }
    public void setLicense(License license) {
        this.license = license;
    }

    public String getNominative() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return  "{" + super.toString() +
                "user='" + name + " " + surname + '\'' +
                ", code='" + code + '\'' +
                ", birth='" + birth + '\'' +
                ", credit=" + credit +
                ", helmet=" + helmet +
                ", licenseId=" + licenseId +
                '}';
    }

    public static User fromCsv(String line){
        String[] lines = line.split(",");
        return new User(UUID.fromString(lines[0]), lines[1], lines[2], lines[3], lines[4],
                Double.parseDouble(lines[5]), Boolean.parseBoolean(lines[6]), UUID.fromString(lines[7]));
    }

    public static String toCsv(User user){
        return  user.getId() + "," +
                user.getName() + "," +
                user.getSurname() + "," +
                user.getCode() + "," +
                user.getBirth() + "," +
                user.getCredit() + "," +
                user.getHelmet() + "," +
                user.getLicenseId();
    }

}