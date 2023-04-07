import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un piatto presentato durante l'edizione del concorso.
 */
public class Piatto {
    private String id;
    private int aspetto;
    private int consistenza;
    private int gusto;
    private Portata portata;
    private Tipologia tipologia;
    private List<Partecipante> partecipanti;

    /**
     * Costruttore che crea un nuovo Piatto con l'ID specificato.
     *
     * @param id l'ID del Piatto
     */
    public Piatto(String id) {
        this.id = id;
        this.partecipanti = new ArrayList<>();
    }

    /**
     * Restituisce l'ID del Piatto.
     *
     * @return l'ID del Piatto
     */
    public String getId() {
        return id;
    }

    /**
     * Imposta l'ID del Piatto.
     *
     * @param id il nuovo ID del Piatto
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Restituisce la valutazione in termini di aspetto del Piatto.
     *
     * @return la valutazione in termini di aspetto del Piatto
     */
    public int getAspetto() {
        return aspetto;
    }

    /**
     * Imposta la valutazione in termini di aspetto del Piatto.
     *
     * @param aspetto la nuova valutazione in termini di aspetto del Piatto
     */
    public void setAspetto(int aspetto) {
        this.aspetto = aspetto;
    }

    /**
     * Restituisce la valutazione in termini di consistenza del Piatto.
     *
     * @return la valutazione in termini di consistenza del Piatto
     */
    public int getConsistenza() {
        return consistenza;
    }

    /**
     * Imposta la valutazione in termini di consistenza del Piatto.
     *
     * @param consistenza la nuova valutazione in termini di consistenza del Piatto
     */
    public void setConsistenza(int consistenza) {
        this.consistenza = consistenza;
    }

    /**
     * Restituisce la valutazione in termini di gusto del Piatto.
     *
     * @return la valutazione in termini di gusto del Piatto
     */
    public int getGusto() {
        return gusto;
    }

    /**
     * Imposta la valutazione in termini di gusto del Piatto.
     *
     * @param gusto la nuova valutazione in termini di gusto del Piatto
     */
    public void setGusto(int gusto) {
        this.gusto = gusto;
    }

    /**
     * Restituisce la portata del Piatto.
     *
     * @return la portata del Piatto
     */
    public Portata getPortata() {
        return portata;
    }

    /**
     * Imposta la portata del Piatto.
     *
     * @param portata la nuova portata del Piatto
     */
    public void setPortata(Portata portata) {
        this.portata = portata;
    }

    /**
     * Restituisce la tipologia
     * del Piatto.
     *
     * @return la tipologia del Piatto
     */
    public Tipologia getTipologia() {
        return tipologia;
    }

    /**
     * Imposta la tipologia del Piatto.
     *
     * @param tipologia la nuova tipologia del Piatto
     */
    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }

    /**
     * Restituisce la lista di partecipanti che hanno presentato il Piatto.
     *
     * @return la lista di partecipanti che hanno presentato il Piatto
     */
    public List<Partecipante> getPartecipanti() {
        return partecipanti;
    }

    /**
     * Aggiunge un partecipante alla lista di partecipanti che hanno presentato il Piatto.
     *
     * @param partecipante il partecipante da aggiungere
     */
    public void addPartecipante(Partecipante partecipante) {
        if (!partecipanti.contains(partecipante)) {
            partecipanti.add(partecipante);
            partecipante.addPiatto(this);
        }
    }

    /**
     * Rimuove un partecipante dalla lista di partecipanti che hanno presentato il Piatto.
     *
     * @param partecipante il partecipante da rimuovere
     */
    public void removePartecipante(Partecipante partecipante) {
        if (partecipanti.contains(partecipante)) {
            partecipanti.remove(partecipante);
            partecipante.removePiatto(this);
        }
    }
}
