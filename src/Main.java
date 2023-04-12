

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Si parte!!!");

        Scanner sc = new Scanner(System.in);

        // Leggi il numero di chef, piatti e partecipanti
        int numeroDiChef = sc.nextInt();
        System.out.printf("%nCi sono %s chef.%n", numeroDiChef);

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

//INIZIO TASKS
//TASK
//
// T1.1 ID Chef con più partecipanti assegnati

        String idChefPiuAssegnato = null;
        int contaPartecipanti=0;
        int maxNumPartecipAssociatiChef = 0;
        for(Chef c : chefList){

            List<Partecipante> partecipantiAssociatiChef = c.getPartecipanti(c.getId());

            for(Partecipante partecipante  : partecipantiAssociatiChef){
            }
                if(contaPartecipanti > maxNumPartecipAssociatiChef){
                    maxNumPartecipAssociatiChef = contaPartecipanti;
                    idChefPiuAssegnato = c.getId();
            }

        }
System.out.println(idChefPiuAssegnato);




        //T1.2 trovare id partecipante con livello di ingresso minore
        String idpartecipminore = new String();
        int min_punteggio = 99999;
        int punteggio = 0;
        for (Partecipante partecipante : partecipanteList) {
            punteggio = partecipante.getTecnica() + partecipante.getCreativita();
            if(punteggio < min_punteggio){
                min_punteggio = punteggio;
                idpartecipminore = partecipante.getId();
            }
        }
        System.out.println(" " + idpartecipminore);






        //T1.3 Caratteristica più frequente per gli chef
            int nEsteta = 0, nGoloso = 0, nRicercato = 0;
            for (Chef chef : chefList) {
                if (chef.isEsteta())
                    nEsteta++;
                else if (chef.isGoloso()) {
                    nGoloso++;

                } else if (chef.isRicercato()) {
                    nRicercato++;
                }
            }

            if (nEsteta > nRicercato && nEsteta > nGoloso) {
                System.out.println("ESTETA");
            } else if (nRicercato > nEsteta && nRicercato > nGoloso) {
                System.out.println("RICERCATO");
            } else System.out.println("GOLOSO");






            //T1.4 Numero di Piatti Golosi
        int nPiattiGolosi = 0;
        for (Piatto piatto :  piattoList) {
            if (piatto.getPortata().equals(Portata.DOLCE) || piatto.getTipologia().equals(Tipologia.CARNE) || piatto.getTipologia().equals(Tipologia.PESCE)){
               nPiattiGolosi++;
            }
        }
        System.out.print(nPiattiGolosi);







        //T1.5 Numero totale di Bonus
        // Calcolo dei bonus aggiuntivi in base alle caratteristiche dello chef giudice
        int nTotaleBonus;
        nTotaleBonus = 0;
        for (Partecipante partecipante : partecipanteList ){
            List<Piatto> piattiPresentati = partecipante.getPiattiPresentati();
            for (Piatto piatto : piattiPresentati ) {
               if ((piatto.getPortata().equals(Portata.DOLCE) || piatto.getTipologia().equals(Tipologia.CARNE) || piatto.getTipologia().equals(Tipologia.PESCE)) && partecipante.getChef().isGoloso()){
                   nTotaleBonus++;
                }
                if ((piatto.getPortata().equals(Portata.SECONDO)  && piatto.getTipologia().equals(Tipologia.VEGETARIANO) || piatto.getTipologia().equals(Tipologia.PESCE)) && partecipante.getChef().isRicercato()){
                    nTotaleBonus++;
                }
                if (piatto.getPortata().equals(Portata.ANTIPASTO)  && partecipante.getChef().isEsteta() ){
                    nTotaleBonus++;
                }
            }
            System.out.println(nTotaleBonus + " ");
        }







        //T1.6 ID partecipante con piatto di valutazione complessiva più alto
        int votoPiattoMax=0;
        int votoPiatto=0;
        String idPartecipValutazioneAlta=null;
        votoPiatto = 0;
        votoPiattoMax = 0;

        for(Partecipante a : partecipanteList){

            for (Piatto p : a.getPiattiPresentati()) {
                votoPiatto = p.getConsistenza() + p.getGusto() + p.getAspetto();

                if (votoPiatto > votoPiattoMax) {
                    idPartecipValutazioneAlta = a.getId();
                    votoPiattoMax = votoPiatto;
                }
            }
        }
        System.out.println(idPartecipValutazioneAlta);



        //T1.7
        int VotoMinoreGusto;
        String idPiattoMinorePesce=null;
        VotoMinoreGusto = 9999;
        for(Piatto piatto : piattoList){
            if (piatto.getTipologia().equals(Tipologia.PESCE)){

                if (piatto.getGusto() < VotoMinoreGusto)
                    VotoMinoreGusto = piatto.getGusto();
                idPiattoMinorePesce = piatto.getId();

            }
        }

        System.out.println(idPiattoMinorePesce);








        //TASK2
        Scanner t2 = new Scanner(System.in);
            int p = t2.nextInt();
            int q = t2.nextInt();
            int punteggioMedio = 0;
            boolean flag1 = true;



            //T2.1

        for(Piatto piatto : piattoList){
            int nPiattiMinoriP = 0;

            while(nPiattiMinoriP < q) {
                punteggioMedio = (piatto.getAspetto() + piatto.getGusto() + piatto.getConsistenza()) / 3;
                if((punteggioMedio < p)){
                    flag1 = true;
                } else flag1 = false;
            }
        }



        //T2.2
        boolean flag2 = true;
        for(Partecipante partecipante : partecipanteList){
            if(partecipante.getTecnica() < p || partecipante.getCreativita() < p) {
                flag2 = true;
            }else flag2 = false;
        }




        //T2.3 controllo se un piatto viene presentato da max 2 partecipanti
        boolean flag3 = true;
        String idControllo = null;
        String perControllare = null;
        int numControllo = 0;

for(Partecipante o : partecipanteList)
    for(Piatto pi : o.getPiattiPresentati()){
            perControllare = o.getId();
                if (!perControllare.equals(idControllo)) {
                    idControllo = o.getId();
                    flag3 = true;
                } else numControllo++;
            }
        if(numControllo < 2){
            flag3 = true;
        }else flag3 = false;




        // T2.4 controllo se ogni partecipante presenta un piatto da bonus
    boolean flag4;
    boolean flagBonusPartecip = true;
        for (Partecipante partecipante : partecipanteList) {
            for (Piatto piatto : piattoList) {
                do {
                    if ((piatto.getPortata().equals(Portata.DOLCE) || piatto.getTipologia().equals(Tipologia.CARNE) || piatto.getTipologia().equals(Tipologia.PESCE)) && partecipante.getChef().isGoloso()) {
                        flagBonusPartecip = true;
                    } else flagBonusPartecip = false;


                    if ((piatto.getPortata().equals(Portata.SECONDO) && piatto.getTipologia().equals(Tipologia.VEGETARIANO) || piatto.getTipologia().equals(Tipologia.PESCE)) && partecipante.getChef().isRicercato()) {
                        flagBonusPartecip = true;
                    } else flagBonusPartecip = false;

                    if (piatto.getPortata().equals("ANTIPASTO") && partecipante.getChef().isEsteta()) {
                        flagBonusPartecip = true;
                    } else flagBonusPartecip = false;

                } while (flagBonusPartecip);

            }
        }
        if (flagBonusPartecip){
            flag4 = true;
        }else flag4= false;

        if(flag1 && flag3 && flag3 && flag4){
            System.out.println("YES");
        } else System.out.println("NO");


            //TASK3

            Scanner t3 = new Scanner(System.in);
            String idFornito;
            String isVincitore=null;
            idFornito = String.valueOf(t3.next());
            int punteggioMaxComplessivo = 0;
            for (Partecipante c : partecipanteList) {

                if ((c.getCreativita() + c.getTecnica()) > punteggioMaxComplessivo)
                    if (idFornito == c.getId()) {
                        punteggioMaxComplessivo = c.getCreativita() + c.getTecnica();
                        isVincitore = "VALID";
                    } else isVincitore = "NOT VALID";
            }
            System.out.println(isVincitore);
        }




















        }




























