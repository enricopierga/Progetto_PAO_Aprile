import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Si parte!!!");

        Scanner sc = new Scanner(System.in);

        // Leggi il numero di chef, piatti e partecipanti
        int numeroDiChef = sc.nextInt();
        System.out.printf("Ci sono %s chef.%n", numeroDiChef);

        int numeroDiPiatti = sc.nextInt();
        System.out.printf("Ci sono %s piatti.%n", numeroDiPiatti);

        int numeroDiPartecipanti = sc.nextInt();
        System.out.printf("Ci sono %s partecipanti.%n", numeroDiPartecipanti);

        sc.nextLine(); // consuma la fine linea

        // Crea la lista di chef
        List<Chef> chefList = new ArrayList<>();
        for (int i = 0; i < numeroDiChef; i++) {
            String[] chefData = sc.nextLine().split(" ");
            Chef chef = new Chef(chefData[0], Integer.parseInt(chefData[1]), Integer.parseInt(chefData[2]), Integer.parseInt(chefData[3]));
            chefList.add(chef);
        }

        // Crea la lista di piatti
        List<Piatto> piattoList = new ArrayList<>();
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

        // Crea la lista di partecipanti
        List<Partecipante> partecipanteList = new ArrayList<>();
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

        // Output di verifica
        System.out.println("Chef:");
        for (Chef chef : chefList) {
            System.out.println(chef.getId() + " " + chef.isGoloso() + " " + chef.isEsteta() + " " + chef.isRicercato());
        }

        System.out.println("Piatti:");
        for (Piatto piatto : piattoList) {
            System.out.println(piatto.getId() + " " + piatto.getAspetto() + " " + piatto.getConsistenza() + " " + piatto.getGusto() + " " + piatto.getPortata() + " " + piatto.getTipologia());
            for (Partecipante partecipante : piatto.getPartecipanti()) {
                System.out.print(partecipante.getId() + " ");
            }
            System.out.println();
        }

        System.out.println("Partecipanti:");
        for (Partecipante partecipante : partecipanteList) {
            System.out.print(partecipante.getId() + " " + partecipante.getTecnica() + " " + partecipante.getCreativita() + " ");
            for (Piatto piatto : partecipante.getPiattiPresentati()) {
                System.out.print(piatto.getId() + ",");
            }
            System.out.println(" " + partecipante.getChef().getId());
        }
    }
}

