enum Caratteristica {
    GOLOSO, RICERCATO, ESTETA
}

public class Chef {
    private boolean flgGoloso;
    private boolean flgEsteta;
    private boolean flgRicercato;

    private String idChef;

    public Chef(boolean flgEsteta, boolean flgGoloso, boolean flgRicercato, String idChef) {
        this.flgEsteta = flgEsteta;
        this.flgGoloso = flgGoloso;
        this.flgRicercato = flgRicercato;
        this.idChef = idChef;
    }

    public boolean isFlgEsteta() {
        return flgEsteta;
    }
    public void setFlgEsteta(boolean flgEsteta) {
        this.flgEsteta = flgEsteta;
    }

    public boolean isFlgGoloso() {
        return flgGoloso;
    }

    public void setFlgGoloso(boolean flgGoloso) {
        this.flgGoloso = flgGoloso;
    }

    public boolean isFlgRicercato() {
        return flgRicercato;
    }

    public void setFlgRicercato(boolean flgRicercato) {
        this.flgRicercato = flgRicercato;
    }

    public String getIdChef() {
        return idChef;
    }
}

