public class Piatto {
    private int aspetto;
    private int gusto;
    private int consistenza;
    private String portata;
    private String tipologia;

    public Piatto(int aspetto, int gusto, int consistenza, String portata, String tipologia) {
        this.aspetto = aspetto;
        this.gusto = gusto;
        this.consistenza = consistenza;
        this.portata = portata;
        this.tipologia = tipologia;
    }

    public int getAspetto() {
        return aspetto;
    }

    public void setAspetto(int aspetto) {
        this.aspetto = aspetto;
    }

    public int getGusto() {
        return gusto;
    }

    public void setGusto(int gusto) {
        this.gusto = gusto;
    }

    public int getConsistenza() {
        return consistenza;
    }

    public void setConsistenza(int consistenza) {
        this.consistenza = consistenza;
    }

    public String getPortata() {
        return portata;
    }

    public void setPortata(String portata) {
        this.portata = portata;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
}

    public int getBonus(enum <Caratteristica> caratteristiche) {
        int bonus = aspetto + gusto + consistenza;

        // Calcolo dei bonus aggiuntivi in base alle caratteristiche dello chef giudice
        for (Caratteristica c : caratteristiche) {
            switch (c) {
                case GOL:
                    if (tipologia.equals("dolce") || tipologia.equals("carne")) {
                        bonus += aspetto + gusto + consistenza;
                    }
                    break;
                case RIC:
                    if ((portata.equals("antipasto") || portata.equals("secondo")) &&
                            (tipologia.equals("vegetariano") || tipologia.equals("pesce"))) {
                        bonus += aspetto + gusto + consistenza;
                    }
                    break;
                case EST:
                    if (portata.equals("antipasto")) {
                        bonus += aspetto + gusto + consistenza;
                    }
                    break;
            }
        }

        return bonus;
    }


}
public class MisterCuoco {
    private List<Partecipante> partecipanti;
    private List<Chef> giudici;
    private List<Piatto> piatti;

    public MisterCuoco(List<Partecipante> partecipanti, List<Chef> giudici, List<Piatto> piatti) {
        this.partecipanti = partecipanti;
        this.giudici = giudici;
        this.piatti = piatti;
    }

    public void calcolaBonus() {
        for (Piatto piatto : piatti) {
            int bonus = 0;
            for (Chef chef : giudici) {
                if (chef.puòValutare(piatto)) {
                    bonus += chef.calcolaBonus(piatto);
                }
            }
            piatto.setBonus(bonus);
        }
    }

    public boolean verificaCondizioni(int p, int q) {
        // Condizione 1
        int piattiConMediaMinoreDiP = 0;
        for (Piatto piatto : piatti) {
            int media = (piatto.getAspetto() + piatto.getConsistenza() + piatto.getGusto()) / 3;
            if (media < p) {
                piattiConMediaMinoreDiP++;
            }
        }
        if (piattiConMediaMinoreDiP > q) {
            return false;
        }

        // Condizione 2
        for (Partecipante partecipante : partecipanti) {
            int tecnica = partecipante.getTecnica();
            int creatività = partecipante.getCreatività();
            if (tecnica < p && creatività < p) {
                return false;
            }
            if (tecnica < p) {
                partecipante.incrementaCreatività(q / 2);
            }
            if (creatività < p) {
                partecipante.incrementaTecnica(q / 2);
            }
        }

        // Condizione 3
        Map<Piatto, Integer> conteggioPartecipantiPerPiatto = new HashMap<>();
        for (Piatto piatto : piatti) {
            conteggioPartecipantiPerPiatto.put(piatto, 0);
        }
        for (Partecipante partecipante : partecipanti) {
            Set<Piatto> piattiDelPartecipante = partecipante.getPiatti();
            for (Piatto piatto : piattiDelPartecipante) {
                int conteggio = conteggioPartecipantiPerPiatto.get(piatto);
                if (conteggio >= 2) {
                    return false;
                }
                conteggioPartecipantiPerPiatto.put(piatto, conteggio + 1);
            }
        }

        // Condizione 4
        for (Partecipante partecipante : partecipanti) {
            boolean haBonus = false;
            Set<Piatto> piattiDelPartecipante = partecipante.getPiatti();
            for (Piatto piatto : piattiDelPartecipante) {
                if (piatto.getBonus() > 0) {
                    haBonus = true;
                    break;
                }
            }
            if (!haBonus) {
                return false;
            }
        }

        return true;
    }
}






