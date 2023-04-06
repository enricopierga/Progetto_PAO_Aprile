import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int L = scanner.nextInt();
        scanner.nextLine();

        /*List<Chef> chefs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] chefData = scanner.nextLine().split(" ");
            chefs.add(new Chef(chefData[0], Integer.parseInt(chefData[1]), Integer.parseInt(chefData[2]), Integer.parseInt(chefData[3])));
        }

        List<Piatto> piatti = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] piattoData = scanner.nextLine().split(" ");
            piatti.add(new Piatto(piattoData[0], Integer.parseInt(piattoData[1]), Integer.parseInt(piattoData[2]), Integer.parseInt(piattoData[3]), piattoData[4], piattoData[5]));
        }

        List<Partecipante> partecipanti = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            String[] partecipanteData = scanner.nextLine().split(" ");
            partecipanti.add(new Partecipante(partecipanteData[0], Integer.parseInt(partecipanteData[1]), Integer.parseInt(partecipanteData[2]), partecipanteData[3], partecipanteData[4]));
        }

        // Implementa qui la logica dell'algoritmo
    }
}*/

/*
class Chef {
    String id;
    int goloso;
    int esteta;
    int ricercato;

    public Chef(String id, int goloso, int esteta, int ricercato) {
        this.id = id;
        this.goloso = goloso;
        this.esteta = esteta;
        this.ricercato = ricercato;
    }
}

class Piatto {
    String id;
    int aspetto;
    int consistenza;
    int gusto;
    String portata;
    String tipologia;

    public Piatto(String id, int aspetto, int consistenza, int gusto, String portata, String tipologia) {
        this.id = id;
        this.aspetto = aspetto;
        this.consistenza = consistenza;
        this.gusto = gusto;
        this.portata = portata;
        this.tipologia = tipologia;
    }
}

class Partecipante {
    String id;
    int tecnica;
    int creativita;
    String piatti;
    String chefId;

    public Partecipante(String id, int tecnica, int creativita, String piatti, String chefId) {
        this.id = id;
        this.tecnica = tecnica;
        this.creativita = creativita;
        this.piatti = piatti;
        this.chefId = chefId;
    }
}*/
