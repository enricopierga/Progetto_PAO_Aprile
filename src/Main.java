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











        //T1.2 trovare id partecipante con livello di ingresso minore

        String idpartecipminore = new String();
        int min_punteggio = 999
        for (Partecipante partecipante : partecipanteList) {

            int punteggio = partecipante.getTecnica() + partecipante.getCreativita();
            if(punteggio < min_punteggio){
                idpartecipminore = partecipante.getId();
                min_punteggio = punteggio;
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

        //MANCA RELAZIONE TRA CHEF ASSEGNATI AI PARTECIPANTI
        int nTotaleBonus;
        nTotaleBonus = 0;
        for (Partecipante partecipante : partecipanteList ){
            List<Piatto> piattiPresentati = partecipante.getPiattiPresentati();
            for (Piatto piatto : piattiPresentati ) {
               if ((piatto.getPortata().equals("DOLCE") || piatto.getTipologia().equals("CARNE") || piatto.getTipologia().equals("PESCE")) && partecipante.getChef().isGoloso()  ){
                   nTotaleBonus++;
                }
                if (((piatto.getPortata().equals("SECONDO")  && piatto.getTipologia().equals("VEGETARIANO") || piatto.getTipologia().equals("PESCE")) && piatto.getChefricercato ){
                    nTotaleBonus++;
                }
                if (((piatto.getPortata().equals("ANTIPASTO")  && piatto.getTipologia().equals("VEGETARIANO") || piatto.getTipologia().equals("PESCE")) && piatto.getChefricercato ){
                    nTotaleBonus++;
                }
                if (piatto.getPortata().equals("ANTIPASTO")  && piatto.getChefesteta ){
                    nTotaleBonus++;
                }
            }
        }
            System.out.println(nTotaleBonus);
            }



        //T1.6
        //MANCA RELAZIONE TRA PARTECIPANTE E PIATTO PRESENTATO
        int votoPiattoMax;
        int votoPiatto;
        String idPartecipValutazioneAlta;
        votoPiatto = 0;
        votoPiattoMax = 0;
        for(Partecipante partecipante : partecipanteList){
            votoPiatto = partecipante.getPiattiPresentati().getvotiPiattopresentato...........
            if(votoPiatto > votoPiattoMax){
                idPartecipValutazioneAlta = partecipante.getId();
            }
        }

        System.out.println(idPartecipValutazioneAlta);


        //T1.7
        int VotoMinoreGusto;
        VotoMinoreGusto = 9999;
        for(Piatto piatto : piattoList){
            if (piatto.getTipologia().equals("PESCE")){

                if (piatto.getGusto() < VotoMinoreGusto)
                    VotoMinoreGusto = piatto.getGusto();
            }
        }

        System.out.println(VotoMinoreGusto);
        }

         //T2
    //MANCANO RELAZIONI TRA PARTECIPANTI E PIATTI PRESENTATI
            Scanner t2 = new Scanner(System.in);
            int p = t2.nextInt();
            int q = t2.nextInt();
            int punteggioMedio = 0;
            boolean flag1, flag2, flag3;
            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||RIVED
        for(Piatto piatto : piattoList){
            punteggioMedio = piatto.getAspetto() + piatto.getGusto() + piatto.getConsistenza();
            if((punteggioMedio > p) && (punteggioMedio < q)){
               flag1 = true;
            }
                else flag1 = false;
        }


        for(Partecipante partecipante : partecipanteList){
            if(partecipante.getTecnica() < p || partecipante.getCreativita() < p) {
                flag2 = true;
            }else flag2 = false;

    }
        for(Piatto piatto : piattoList){
        if(piatto.getPartecipanti() != piatto.getPartecipanti())
            flag3 = true:
        else flag 3 = false;
    }









        // calcolo bonus per il T2.4
        int nTotaleBonus;
    nTotaleBonus = 0;
        for (Partecipante partecipante : partecipanteList) {
        if ((partecipante.getPiattiPresentati(). || piatto.getTipologia().equals("CARNE") || piatto.getTipologia().equals("PESCE")) && piatto.getChefgoloso ){
            nTotaleBonus++;
        }
        if (((piatto.getPortata().equals("SECONDO")  && piatto.getTipologia().equals("VEGETARIANO") || piatto.getTipologia().equals("PESCE")) && piatto.getChefricercato ){
            nTotaleBonus++;
        }
        if (((Partecipante.piatto.getPortata().equals("ANTIPASTO")  && piatto.getTipologia().equals("VEGETARIANO") || piatto.getTipologia().equals("PESCE")) && piatto.getChefricercato ){
            nTotaleBonus++;
        }
        if (piatto.getPortata().equals("ANTIPASTO")  && piatto.getChefesteta ){
            nTotaleBonus++;
        }



        System.out.println("YES");
        else System.out.println("NO");



        Scanner t3 = new Scanner(System.in);
        String idFornito;
        String isVincitore;
        idFornito = String.valueOf(t3.nextInt());
        int punteggioMaxComplessivo = 0;
        for(Partecipante partecipante : partecipanteList) {

            if ((partecipante.getCreativita() + partecipante.getTecnica()) > punteggioMaxComplessivo)
                if (idFornito == partecipante.getId()){
                    punteggioMaxComplessivo = partecipante.getCreativita() + partecipante.getTecnica();
            isVincitore = "VALID";
        } else isVincitore = "NOT VALID";

        }




















        }










    }















}

