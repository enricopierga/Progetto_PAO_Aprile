import java.util.List;

public class Partecipante {
    private int tecnica;
    private int creativita;

    private final String idPartecipante;
    private final String idChef;
    private List<String> listaPiatti;

    public Partecipante(int tecnica, int creativita, String idPartecipante, String idChef, List<String> listaPiatti) {
        this.tecnica = tecnica;
        this.creativita = creativita;
        this.idPartecipante = idPartecipante;
        this.idChef = idChef;
        this.listaPiatti = listaPiatti;
    }

    public int getTecnica() {
        return tecnica;
    }

    public void setTecnica(int tecnica) {
        this.tecnica = tecnica;
    }

    public int getCreativita() {
        return creativita;
    }

    public void setCreativita(int creativita) {
        this.creativita = creativita;
    }

    public String getIdPartecipante() {
        return idPartecipante;
    }



    public String getIdChef() {
        return idChef;
    }
    public List<String> getListaPiatti() {
        return listaPiatti;
    }

    public void setListaPiatti(List<String> listaPiatti) {
        this.listaPiatti = listaPiatti;
    }
    public void aggPiatto(String nuovoPiatto){
        this.listaPiatti.add(nuovoPiatto);
    }
}







/*public class MisterCuoco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lettura dei dati dell'edizione
        int numChefs = scanner.nextInt();
        Chef[] chefs = new Chef[numChefs];
        for (int i = 0; i < numChefs; i++) {
            String name = scanner.next();
            boolean goloso = scanner.nextInt() == 1;
            boolean ricercato = scanner.nextInt() == 1;
            boolean esteta = scanner.nextInt() == 1;
            chefs[i] = new Chef(name, goloso, ricercato, esteta);
        }

        // Lettura dei dati dei partecipanti
        int numParticipants = scanner.nextInt();
        Participant[] participants = new Participant[numParticipants];
        for (int i = 0; i < numParticipants; i++) {
            String id = scanner.next();
            int chefIndex = scanner.nextInt() - 1;
            int tecnica = scanner.nextInt();
            int creativita = scanner.nextInt();
            participants[i] = new Participant(id, chefs[chefIndex], tecnica, creativita);
        }

        // Lettura dell'ID del vincitore atteso
        String expectedWinnerId = scanner.next();

        // Calcolo del vincitore
        Participant winner = calculateWinner(participants);

        // Verifica se il vincitore atteso corrisponde al vincitore calcolato
        if (winner.getId().equals(expectedWinnerId)) {
            System.out.println("VALID");
        } else {
            System.out.println("NOT VALID");
        }
    }

    private static Participant calculateWinner(Participant[] participants) {
        // Calcolo del punteggio complessivo di ogni partecipante
        for (Participant participant : participants) {
            int totalScore = participant.getTecnica() + participant.getCreativita();
            int numBonuses = participant.getNumBonuses();
            for (Chef chef : participant.getChefsWithBonuses()) {
                if (chef.isGoloso()) {
                    numBonuses += participant.addBonus(totalScore);
                } else if (chef.isRicercato() || chef.isEsteta()) {
                    numBonuses += participant.addBonus(0);
                }
            }
            participant.setTotalScore(totalScore);
            participant.setNumBonuses(numBonuses);
        }

        // Selezione del vincitore in base al punteggio complessivo e ai criteri di desambiguazione
        Arrays.sort(participants, new Comparator<Participant>() {
            @Override
            public int compare(Participant p1, Participant p2) {
                if (p1.getTotalScore() != p2.getTotalScore()) {
                    return p2.getTotalScore() - p1.getTotalScore();
                } else if (p1.getNumBonuses() != p2.getNumBonuses()) {
                    return p2.getNumBonuses() - p1.getNumBonuses();
                } else if (p1.hasAllBonuses() != p2.hasAllBonuses()) {
                    return Boolean.compare(p2.hasAllBonuses(), p1.hasAllBonuses());
                } else {
                    return p1.getId().compareTo(p2.getId());
                }
            }
        });

        // Ritorno del vincitore
        return participants[0];
    }
}*/

