public class Chef {
    private boolean goloso;
    private boolean ricercato;
    private boolean esteta;

    public Chef(boolean goloso, boolean ricercato, boolean esteta) {
        this.goloso = goloso;
        this.ricercato = ricercato;
        this.esteta = esteta;
    }

    public boolean isGoloso() {
        return goloso;
    }

    public void setGoloso(boolean goloso) {
        this.goloso = goloso;
    }

    public boolean isRicercato() {
        return ricercato;
    }

    public void setRicercato(boolean ricercato) {
        this.ricercato = ricercato;
    }

    public boolean isEsteta() {
        return esteta;
    }

    public void setEsteta(boolean esteta) {
        this.esteta = esteta;
    }

    public boolean isNessuno() {
        return !goloso && !ricercato && !esteta;
    }
