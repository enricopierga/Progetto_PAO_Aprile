import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    public static List<Chef> chefList = new ArrayList<Chef>();
    public static List<Partecipante> partecipanteList = new ArrayList<Partecipante>();
    public static List<Piatto> piattoList = new ArrayList<Piatto>();
    private static int righeDaleggere;

    public static String ultimaRiga;



    public static void Main (){


        Scanner sc = new Scanner(System.in);
        // Leggi il numero di chef, piatti e partecipanti
        int numeroDiChef = sc.nextInt();
        int numeroDiPiatti = sc.nextInt();
        int numeroDiPartecipanti = sc.nextInt();
        sc.nextLine(); // consuma la fine linea




        // Crea la lista di chef
        for (int i = 0; i < numeroDiChef; i++) {
            String[] chefData = sc.nextLine().split(" ");
            Chef chef = new Chef(chefData[0], Integer.parseInt(chefData[1]), Integer.parseInt(chefData[2]), Integer.parseInt(chefData[3]));
            chefList.add(chef);
        }

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

        ultimaRiga = sc.nextLine();
        System.out.println(ultimaRiga);


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


        public String getUltimaRiga(){

        return ultimaRiga;
        }







}
