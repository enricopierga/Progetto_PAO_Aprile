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

    public int getBonus(enum <Caratteristica> caratteristiche) {
        int bonus = aspetto + gusto + consistenza;

        // Calcolo dei bonus aggiuntivi in base alle caratteristiche dello chef giudice
        for (Caratteristica c : caratteristiche) {
            switch (c) {
                case GOL:
                    if (tipologia.equals("dolce") || tipologia.equals("carne")) {
                        bonus += aspetto + gusto + consistenza;
                    }
                    break;
                case RIC:
                    if ((portata.equals("antipasto") || portata.equals("secondo")) &&
                            (tipologia.equals("vegetariano") || tipologia.equals("pesce"))) {
                        bonus += aspetto + gusto + consistenza;
                    }
                    break;
                case EST:
                    if (portata.equals("antipasto")) {
                        bonus += aspetto + gusto + consistenza;
                    }
                    break;
            }
        }

        return bonus;
    }


}






