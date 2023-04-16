import java.util.List;


public class Main {
    public static void main(String[] args) {
        while (true) {
            String ultimaRiga;

            Parser parser = new Parser();
            parser.Parse();

            List<Chef> chefList = parser.getChefList();
            List<Partecipante> partecipanteList = parser.getPartecipanteList();
            List<Piatto> piattoList = parser.getPiattoList();

            ultimaRiga = parser.getUltimaRiga();
            System.out.println("-------------");
            System.out.println(ultimaRiga);
            System.out.println("-------------");

            if (ultimaRiga.startsWith("TASK1")) {
                eseguiTask1(ultimaRiga, chefList, partecipanteList, piattoList);
            }

            if (ultimaRiga.startsWith("TASK2")) {
                eseguiTask2(ultimaRiga, partecipanteList, piattoList);
            }
        }
    }

    private static void eseguiTask2(String ultimaRiga, List<Partecipante> partecipanteList, List<Piatto> piattoList) {
        String[] input = ultimaRiga.split(" ");
        int p = Integer.parseInt(input[1]);
        int q = Integer.parseInt(input[2]);
        String resultTask2;

        int punteggioMedio;

        //T2.1
        int nPiattiMinoriP = 0;
        for (Piatto piatto : piattoList) {

            punteggioMedio = (piatto.getAspetto() + piatto.getGusto() + piatto.getConsistenza()) / 3;
            if ((punteggioMedio < p)) {
                nPiattiMinoriP++;

            }
        }
        boolean flag1 = nPiattiMinoriP <= q;

        //T2.2
        boolean flag2 = true;
        for (Partecipante pluto : partecipanteList) {
            if (pluto.getTecnica() < p && pluto.getCreativita() < p) {
                flag2 = false;
            }
        }

        //T2.3 controllo se un piatto viene presentato da max 2 partecipanti
        boolean flag3 = true;
        String idControllo = null;
        String perControllare = null;
        int numControllo = 0;

        for (Partecipante o : partecipanteList)
            for (Piatto pi : o.getPiattiPresentati()) {
                perControllare = o.getId();
                if (!perControllare.equals(idControllo)) {
                    idControllo = o.getId();
                    flag3 = true;
                } else numControllo++;
            }
        if (numControllo < 2) {
            flag3 = true;
        } else flag3 = false;


        // T2.4 controllo se ogni partecipante presenta un piatto da bonus
        boolean flag4 = false;
        boolean[] flagBonusPartecip = new boolean[partecipanteList.size()];

        for (int i = 0; i < partecipanteList.size(); i++) {
            Partecipante pippo = partecipanteList.get(i);
            for (Piatto piatto: pippo.getPiatti()) {
                if ((piatto.getPortata().equals(Portata.DOLCE) || piatto.getTipologia().equals(Tipologia.CARNE) || piatto.getTipologia().equals(Tipologia.PESCE)) && pippo.getChef().isGoloso()) {
                    flagBonusPartecip[i] = true;
                    break;
                } else if ((piatto.getPortata().equals(Portata.SECONDO) && piatto.getTipologia().equals(Tipologia.VEGETARIANO) || piatto.getTipologia().equals(Tipologia.PESCE)) && pippo.getChef().isRicercato()) {
                    flagBonusPartecip[i] = true;
                    break;
                } else if (piatto.getPortata().equals("ANTIPASTO") && pippo.getChef().isEsteta()) {
                    flagBonusPartecip[i] = true;
                    break;
                }
            }
        }

        for (Partecipante pippo : partecipanteList) {

        }

        for (int i = 0; i < flagBonusPartecip.length; i++) {
            if (!flagBonusPartecip[i]) {
                flag4 = true;
                break;
            }
        }

        resultTask2 = null;
        String controlloTask2 = String.format("TASK2 %s %s", p, q);

        if (flag1 && flag2 && flag3 && flag4) {
            if (ultimaRiga.equals(controlloTask2))
                resultTask2 = "YES";
        } else resultTask2 = "NO";

        if (ultimaRiga.equals(controlloTask2)) {
            System.out.println("\n" + resultTask2);
        }
    }

    private static void eseguiTask1(String ultimaRiga, List<Chef> chefList, List<Partecipante> partecipanteList, List<Piatto> piattoList) {
        String idChefPiuAssegnato = null;
        int maxNumPartecipAssociatiChef = 0;

        for (Chef c : chefList) {
            List<Partecipante> partecipantiAssociatiChef = c.getPartecipanti();
            int contaPartecipanti = partecipantiAssociatiChef.toArray().length;

            if (contaPartecipanti > maxNumPartecipAssociatiChef) {
                maxNumPartecipAssociatiChef = contaPartecipanti;
                idChefPiuAssegnato = c.getId();
            }
        }

        if (ultimaRiga.equals("TASK1")) {
            System.out.println(idChefPiuAssegnato);
        }

        //T1.2 trovare id partecipante con livello di ingresso minore
        String idpartecipminore = new String();
        int min_punteggio = 99999;
        int punteggio = 0;
        for (Partecipante partecipante : partecipanteList) {
            punteggio = partecipante.getTecnica() + partecipante.getCreativita();
            if (punteggio < min_punteggio) {
                min_punteggio = punteggio;
                idpartecipminore = partecipante.getId();
            }
        }

        if (ultimaRiga.equals("TASK1")) {
            System.out.println(idpartecipminore);
        }

        //T1.3 Caratteristica più frequente per gli chef
        String carFrequente;
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
            carFrequente = "ESTETA";
        } else if (nRicercato > nEsteta && nRicercato > nGoloso) {
            carFrequente = "RICERCATO";
        } else carFrequente = "GOLOSO";

        if (ultimaRiga.equals("TASK1")) {
            System.out.println(carFrequente);
        }


        //T1.4 Numero di Piatti Golosi
        int nPiattiGolosi = 0;

        for (Piatto piatto : piattoList) {

            if (piatto.getPortata().equals(Portata.DOLCE) || piatto.getTipologia().equals(Tipologia.CARNE) || piatto.getTipologia().equals(Tipologia.PESCE)) {
                nPiattiGolosi++;

            }
        }
        if (ultimaRiga.equals("TASK1")) {
            System.out.println(nPiattiGolosi);
        }


        //T1.5 Numero totale di Bonus
        // Calcolo dei bonus aggiuntivi in base alle caratteristiche dello chef giudice


        for (Partecipante partecipante : partecipanteList) {
            int[][] contaBonus = new int[piattoList.toArray().length][3];

            for (Chef chef : chefList) {
                int i = 0;
                for (Piatto pia : partecipante.getPiattiPresentati()) {


                    if (pia.getPortata().equals(Portata.DOLCE) && chef.isGoloso()) {
                        contaBonus[i][0] = 1;

                    }
                    if ((pia.getTipologia().equals(Tipologia.CARNE) || pia.getTipologia().equals(Tipologia.PESCE)) && chef.isGoloso()) {
                        contaBonus[i][0] = 1;


                    }
                    if (pia.getPortata().equals(Portata.SECONDO) && (pia.getTipologia().equals(Tipologia.VEGETARIANO) || pia.getTipologia().equals(Tipologia.PESCE)) && chef.isRicercato()) {
                        contaBonus[i][1] = 1;

                    }
                    if (pia.getPortata().equals(Portata.ANTIPASTO) && (pia.getTipologia().equals(Tipologia.VEGETARIANO) || pia.getTipologia().equals(Tipologia.PESCE)) && chef.isRicercato()) {
                        contaBonus[i][1] = 1;


                    }

                    if (pia.getPortata().equals(Portata.ANTIPASTO) && chef.isEsteta()) {
                        contaBonus[i][2] = 1;

                    }
                    i++;
                }


            }


            int nTotaleBonus = 0;

            if (ultimaRiga.equals("TASK1")) {
                for (int c = 0; c < 3; c++) {
                    for (int p = 0; p < piattoList.toArray().length; p++) {
                        nTotaleBonus = nTotaleBonus + contaBonus[p][c];
                    }

                }
            }
            System.out.printf(nTotaleBonus + " ");

        }
        System.out.printf(" \n");


        //T1.6 ID partecipante con piatto di valutazione complessiva più alto
        int votoPiattoMax = 0;
        int votoPiatto = 0;
        String idPartecipValutazioneAlta = null;
        votoPiatto = 0;
        votoPiattoMax = 0;

        for (Partecipante a : partecipanteList) {

            for (Piatto p : a.getPiattiPresentati()) {
                votoPiatto = p.getConsistenza() + p.getGusto() + p.getAspetto();

                if (votoPiatto > votoPiattoMax) {
                    idPartecipValutazioneAlta = a.getId();
                    votoPiattoMax = votoPiatto;
                }
            }
        }
        if (ultimaRiga.equals("TASK1")) {
            System.out.println(idPartecipValutazioneAlta);
        }


        //T1.7
        int VotoMinoreGusto;
        String idPiattoMinorePesce = null;
        VotoMinoreGusto = 11;

        for (Piatto piatto : piattoList) {

            if (piatto.getTipologia().equals(Tipologia.PESCE)) {

                if (piatto.getGusto() < VotoMinoreGusto) {
                    VotoMinoreGusto = piatto.getGusto();
                    idPiattoMinorePesce = piatto.getId();
                }
            }

        }
        if (ultimaRiga.equals("TASK1")) {
            System.out.println(idPiattoMinorePesce);
        }
    }
}










































