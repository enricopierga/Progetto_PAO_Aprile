public class Chef {
    private Integer flgGoloso;
    private Integer flgEsteta;
    private Integer flgRicercato;

    private String idChef;

    public Chef(String idChef, Integer flgGoloso, Integer flgEsteta, Integer flgRicercato) {
        this.flgEsteta = flgEsteta;
        this.flgGoloso = flgGoloso;
        this.flgRicercato = flgRicercato;
        this.idChef = idChef;
    }

    public Integer isFlgEsteta() {
        return flgEsteta;
    }
    public void setFlgEsteta(Integer flgEsteta) {
        this.flgEsteta = flgEsteta;
    }

    public Integer isFlgGoloso() {
        return flgGoloso;
    }

    public void setFlgGoloso(Integer flgGoloso) {
        this.flgGoloso = flgGoloso;
    }

    public Integer isFlgRicercato() {
        return flgRicercato;
    }

    public void setFlgRicercato(Integer flgRicercato) {
        this.flgRicercato = flgRicercato;
    }

    public String getIdChef() {
        return idChef;
    }
}

