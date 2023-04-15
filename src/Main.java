import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Parser Parser = new Parser();

        Parser.Main();

        List<Chef> chefList = Parser.getChefList();
        List<Partecipante> partecipanteList = Parser.getPartecipanteList();
        List<Piatto> piattoList = Parser.getPiattoList();

        String ultimaRiga = Parser.getUltimaRiga();


//TASK


        while (true) {

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


            //T1.4 Numero di Piatti Golosi
            int nPiattiGolosi = 0;

            for (Piatto piatto : piattoList) {

                if (piatto.getPortata().equals(Portata.DOLCE) || piatto.getTipologia().equals(Tipologia.CARNE) || piatto.getTipologia().equals(Tipologia.PESCE)) {
                    nPiattiGolosi++;

                }
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
                for (int c = 0; c < 3; c++) {
                    for (int p = 0; p < piattoList.toArray().length; p++) {
                        nTotaleBonus = nTotaleBonus + contaBonus[p][c];
                    }
                }

                System.out.printf(nTotaleBonus + " ");

            }
            System.out.println(" ");


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


            //TASK2
            Scanner t2 = new Scanner(System.in);
            String[] input = t2.nextLine().split(" ");
            int p = Integer.parseInt(input[1]);
            int q = Integer.parseInt(input[2]);
            String resultTask2;

            int punteggioMedio = 0;


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
            for (Partecipante partecipante : partecipanteList) {
                if (partecipante.getTecnica() < p && partecipante.getCreativita() < p) {
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
            if (flagBonusPartecip) {
                flag4 = true;
            } else flag4 = false;

            if (flag1 && flag3 && flag3 && flag4) {
                resultTask2 = "YES";
            } else resultTask2 = "NO";
        }
    }
}


public void stampe tasks() {

                if (ultimaRiga == "TASK1") {
                System.out.println("\n" + idChefPiuAssegnato);
                System.out.println(idpartecipminore);
                System.out.println(carFrequente);
                System.out.println(nPiattiGolosi);

                System.out.println(idPartecipValutazioneAlta);
                System.out.println(idPiattoMinorePesce);
            }


        }
    }
}


        /*//TASK3
        //DA RIVEDERE

        Scanner t3 = new Scanner(System.in);
            String idFornito;
            String isVincitore=null;
            idFornito = String.valueOf(t3.next());
            int punteggioMaxComplessivo = 0;
            int nBonusMaggioreRicevuti = 0;
            String salvaIdPiuBonus = null;
            int controlloBonusOttenuti=0;
            int bonusOttenuto=0;




            //Calcolo e verifico: Partecipante che ha ottenuto più bonus
            // Partecipante con punteggio Max Complessivo
            //Controllo che ID Fornito corrispond a quello cercato


        for (Partecipante c : partecipanteList) {

                for(Piatto piatto : piattoList) {
                    if ((piatto.getPortata().equals(Portata.DOLCE) || piatto.getTipologia().equals(Tipologia.CARNE) || piatto.getTipologia().equals(Tipologia.PESCE)) && c.getChef().isGoloso()) {
                        bonusOttenuto++;
                    }
                    if ((piatto.getPortata().equals(Portata.SECONDO) && piatto.getTipologia().equals(Tipologia.VEGETARIANO) || piatto.getTipologia().equals(Tipologia.PESCE)) && c.getChef().isRicercato()) {
                        bonusOttenuto++;
                    }
                    if (piatto.getPortata().equals("ANTIPASTO") && c.getChef().isEsteta()) {
                        bonusOttenuto++;
                    }

                }

                if (c.getCreativita() + c.getTecnica() > punteggioMaxComplessivo){
                    if (bonusOttenuto >= controlloBonusOttenuti){
                        punteggioMaxComplessivo = c.getCreativita() + c.getTecnica();
                        salvaIdPiuBonus = c.getId();
                    }

                }

                if (idFornito == salvaIdPiuBonus) {
                    isVincitore = "VALID";
                } else isVincitore = "NOT VALID";
               }
                System.out.println(isVincitore);




        }


















*/






























