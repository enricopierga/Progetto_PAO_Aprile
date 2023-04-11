import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un chef che partecipa a un'edizione del concorso.
 */
public class Chef {
    private String id;
    private boolean goloso;
    private boolean esteta;
    private boolean ricercato;
    private List<Partecipante> partecipanti;

    /**
     * Costruttore che imposta le proprietà della classe Chef in base ai valori dei parametri booleani passati.
     *
     * @param id l'ID del chef
     * @param goloso true se il chef è goloso, false altrimenti
     * @param esteta true se il chef è esteta, false altrimenti
     * @param ricercato true se il chef è ricercato, false altrimenti
     */
    public Chef(String id, boolean goloso, boolean esteta, boolean ricercato) {
        this.id = id;
        this.goloso = goloso;
        this.esteta = esteta;
        this.ricercato = ricercato;
        this.partecipanti = new ArrayList<>();
    }

    /**
     * Costruttore che imposta le proprietà della classe Chef in base ai valori dei parametri interi passati.
     * Si aspetta che i valori siano 0 o 1.
     * 1 rappresenta il valore true e 0 il valore false.
     *
     * @param id l'ID del chef
     * @param goloso 0 o 1 (1 se il chef è goloso, 0 altrimenti)
     * @param esteta 0 o 1 (1 se il chef è esteta, 0 altrimenti)
     * @param ricercato 0 o 1 (1 se il chef è ricercato, 0 altrimenti)
     */
    public Chef(String id, int goloso, int esteta, int ricercato) {
        // richiama il costruttore che imposta le proprietà della classe Chef in base ai parametri booleani
        this(id, goloso == 1, esteta == 1, ricercato == 1);
    }

    /**
     * Restituisce l'ID dell'Chef.
     *
     * @return l'ID dell'Chef
     */
    public String getId() {
        return id;
    }

    /**
     * Imposta l'ID dell'Chef.
     *
     * @param id il nuovo ID dell'Chef
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Restituisce true se l'Chef è goloso, false altrimenti.
     *
     * @return true se l'Chef è goloso, false altrimenti
     */
    public boolean isGoloso() {
        return goloso;
    }

    /**
     * Imposta se l'Chef è goloso.
     *
     * @param goloso true se l'Chef è goloso, false altrimenti
     */
    public void setGoloso(boolean goloso) {
        this.goloso = goloso;
    }

    /**
     * Restituisce true se l'Chef è esteta, false altrimenti.
     *
     * @return true se l'Chef è esteta, false altrimenti
     */
    public boolean isEsteta() {
        return esteta;
    }

    /**
     * Imposta se l'Chef è esteta.
     *
     * @param esteta true se l'Chef è esteta, false altrimenti
     */
    public void setEsteta(boolean esteta) {
        this.esteta = esteta;
    }

    /**
     * Restituisce true se l'Chef è ricercato, false altrimenti.
     *
     * @return true se l'Chef è ricercato, false altrimenti
     */
    public boolean isRicercato() {
        return ricercato;
    }

    /**
     * Imposta se l'Chef è ricercato.
     *
     * @param ricercato true se l'Chef è ricercato, false altrimenti
     */
    public void setRicercato(boolean ricercato) {
        this.ricercato = ricercato;
    }

    /**
     * Restituisce la lista di partecipanti associati all'Chef.
     *
     * @return la lista di partecipanti associati all'Chef
     */

    /*public boolean getPartecipanti(String idChef) {
        return partecipanti;
    }*/


    /**
     * Aggiunge un partecipante alla lista di partecipanti associati all'Chef.
     *
     * @param partecipante il partecipante da aggiungere
     */
    public void addPartecipante(Partecipante partecipante) {
        partecipanti.add(partecipante);
    }

    /**
     *
     * * Rimuove un partecipante dalla lista di partecipanti associati all'Chef.
     *
     * @param partecipante il partecipante da rimuovere
     */
    public void removePartecipante(Partecipante partecipante) {
        partecipanti.remove(partecipante);
    }
}