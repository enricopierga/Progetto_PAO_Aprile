import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    public List<Chef> chefList = new ArrayList<Chef>();
    public List<Partecipante> partecipanteList = new ArrayList<Partecipante>();
    public List<Piatto> piattoList = new ArrayList<Piatto>();
    private Scanner sc;

    public String ultimaRiga;

    public void Parse() {
        sc = new Scanner(System.in);
        // Leggi il numero di chef, piatti e partecipanti
        int numeroDiChef = sc.nextInt();
        int numeroDiPiatti = sc.nextInt();
        int numeroDiPartecipanti = sc.nextInt();
        sc.nextLine(); // consuma la fine linea

        parseChef(sc, numeroDiChef);
        parsePiatti(sc, numeroDiPiatti);
        parsePartecipanti(sc, numeroDiPartecipanti);
    }

    public List<Chef> getChefList() {
        return chefList;
    }

    public List<Partecipante> getPartecipanteList() {
        return partecipanteList;
    }

    public List<Piatto> getPiattoList() {
        return piattoList;
    }

    public String getUltimaRiga() {

        return sc.nextLine();
    }

    private void parsePartecipanti(Scanner sc, int numeroDiPartecipanti) {
        // Crea la lista di partecipanti
        for (int i = 0; i < numeroDiPartecipanti; i++) {
            String[] partecipanteData = sc.nextLine().split(" ");
            Partecipante partecipante = new Partecipante(partecipanteData[0]);
            partecipante.setTecnica(Integer.parseInt(partecipanteData[1]));

            partecipante.setCreativita(Integer.parseInt(partecipanteData[2]));


            String[] piattiPresentati = partecipanteData[3].split(",");
            for (String idPiatto : piattiPresentati) {
                for (Piatto piatto : piattoList) {
                    if (piatto.getId().equals(idPiatto)) {
                        partecipante.addPiatto(piatto);
                        break;
                    }
                }
            }


            String idChef = partecipanteData[4];
            for (Chef chef : chefList) {
                if (chef.getId().equals(idChef)) {
                    partecipante.setChef(chef);
                    break;
                }
            }

            partecipanteList.add(partecipante);
        }
    }

    private void parsePiatti(Scanner sc, int numeroDiPiatti) {
        // Crea la lista di piatti
        for (int i = 0; i < numeroDiPiatti; i++) {
            String[] piattoData = sc.nextLine().split(" ");
            Piatto piatto = new Piatto(piattoData[0]);
            piatto.setAspetto(Integer.parseInt(piattoData[1]));
            piatto.setConsistenza(Integer.parseInt(piattoData[2]));
            piatto.setGusto(Integer.parseInt(piattoData[3]));
            piatto.setPortata(Portata.valueOf(piattoData[4].toUpperCase()));
            piatto.setTipologia(Tipologia.valueOf(piattoData[5].toUpperCase()));
            piattoList.add(piatto);
        }
    }

    private void parseChef(Scanner sc, int numeroDiChef) {
        // Crea la lista di chef
        for (int i = 0; i < numeroDiChef; i++) {
            String[] chefData = sc.nextLine().split(" ");
            Chef chef = new Chef(chefData[0], Integer.parseInt(chefData[1]), Integer.parseInt(chefData[2]), Integer.parseInt(chefData[3]));
            chefList.add(chef);
        }
    }
}