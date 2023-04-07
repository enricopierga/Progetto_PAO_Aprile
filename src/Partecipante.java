import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un partecipante al concorso.
 */
public class Partecipante {
    private String id;
    private int tecnica;
    private int creativita;
    private List<Piatto> piatti;
    private Chef chef;

    /**
     * Costruttore che crea un nuovo Partecipante con l'ID specificato.
     *
     * @param id l'ID del Partecipante
     */
    public Partecipante(String id) {
        this.id = id;
        this.piatti = new ArrayList<>();
    }

    /**
     * Restituisce l'ID del Partecipante.
     *
     * @return l'ID del Partecipante
     */
    public String getId() {
        return id;
    }

    /**
     * Imposta l'ID del Partecipante.
     *
     * @param id il nuovo ID del Partecipante
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Restituisce la valutazione in termini di tecnica del Partecipante.
     *
     * @return la valutazione in termini di tecnica del Partecipante
     */
    public int getTecnica() {
        return tecnica;
    }

    /**
     * Imposta la valutazione in termini di tecnica del Partecipante.
     *
     * @param tecnica la nuova valutazione in termini di tecnica del Partecipante
     */
    public void setTecnica(int tecnica) {
        this.tecnica = tecnica;
    }

    /**
     * Restituisce la valutazione in termini di creatività del Partecipante.
     *
     * @return la valutazione in termini di creatività del Partecipante
     */
    public int getCreativita() {
        return creativita;
    }

    /**
     * Restituisce la lista di piatti che il partecipante ha presentato durante l'edizione.
     *
     * @return la lista di piatti presentati dal partecipante
     */
    public List<Piatto> getPiattiPresentati() {
        return piatti;
    }

    /**
     * Imposta la valutazione in termini di creatività del Partecipante.
     *
     * @param creativita la nuova valutazione in termini di creatività del Partecipante
     */
    public void setCreativita(int creativita) {
        this.creativita = creativita;
    }

    /**
     * Restituisce la lista di piatti presentati dal Partecipante.
     *
     * @return la lista di piatti presentati dal Partecipante
     */
    public List<Piatto> getPiatti() {
        return piatti;
    }

    /**
     * Aggiunge un piatto alla lista di piatti presentati dal Partecipante.
     *
     * @param piatto il piatto da aggiungere
     */
    public void addPiatto(Piatto piatto) {
        if (!piatti.contains(piatto)) {
            piatti.add(piatto);
            piatto.addPartecipante(this);
        }
    }

    /**
     * Rimuove un piatto dalla lista di piatti presentati dal Partecipante.
     *
     * @param piatto il piatto da rimuovere
     */
    public void removePiatto(Piatto piatto) {
        if (piatti.contains(piatto)) {
            piatti.remove(piatto);
            piatto.removePartecipante(this);
        }
    }

    /**
     * Restituisce lo Chef di riferimento del Partecipante.
     *
     * @return lo Chef di riferimento del Partecipante
     */
    public Chef getChef() {
        return chef;
    }

    /**
     * Imposta lo Chef di riferimento del Partecipante.
     *
     * @param chef il nuovo Chef di riferimento del Partecipante
     */
    public void setChef(Chef chef) {
        this.chef = chef;
        chef.addPartecipante(this);
    }
}
