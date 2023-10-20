package entity;

public class Patente {

    private int livello;
    private String dataScadenza;
    private String dataRilasco;

    public Patente(int livello) {
        this.livello = livello;
    }

    public Patente(int livello, String dataScadenza, String dataRilasco) {
        this.livello = livello;
        this.dataScadenza = dataScadenza;
        this.dataRilasco = dataRilasco;
    }

    public int getLivello() {
        return livello;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public String getDataRilasco() {
        return dataRilasco;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public void setDataRilasco(String dataRilasco) {
        this.dataRilasco = dataRilasco;
    }

    /**
     * ToString solo per stampare il livello patente
     * @return livello patente utente
     */
    @Override
    public String toString() {
        return String.valueOf(livello);
    }

}
