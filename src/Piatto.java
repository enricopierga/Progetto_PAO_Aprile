public class Piatto {
    private int aspetto;
    private int gusto;
    private int consistenza;
    private String portata;
    private String tipologia;

    public Piatto(int aspetto, int gusto, int consistenza, String portata, String tipologia) {
        this.aspetto = aspetto;
        this.gusto = gusto;
        this.consistenza = consistenza;
        this.portata = portata;
        this.tipologia = tipologia;
    }

    public int getAspetto() {
        return aspetto;
    }

    public void setAspetto(int aspetto) {
        this.aspetto = aspetto;
    }

    public int getGusto() {
        return gusto;
    }

    public void setGusto(int gusto) {
        this.gusto = gusto;
    }

    public int getConsistenza() {
        return consistenza;
    }

    public void setConsistenza(int consistenza) {
        this.consistenza = consistenza;
    }

    public String getPortata() {
        return portata;
    }

    public void setPortata(String portata) {
        this.portata = portata;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
}