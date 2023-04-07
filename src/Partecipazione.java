public class Partecipazione {
    private Partecipante partecipante;
    private Piatto piatto;

    public Partecipazione(Partecipante partecipante, Piatto piatto) {
        this.partecipante = partecipante;
        this.piatto = piatto;
    }

    public Partecipante getPartecipante() {
        return partecipante;
    }

    public Piatto getPiatto() {
        return piatto;
    }
}