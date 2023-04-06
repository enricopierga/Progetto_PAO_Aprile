import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Initializer {
    private List<Chef> listaChef;
    private List<Piatto> listaPiatti;
    private List<Partecipante> listaPartecipanti;

    public Initializer() {
        this.listaChef = new LinkedList<>();
        this.listaPiatti = new LinkedList<>();
        this.listaPartecipanti = new LinkedList<>();
    }

    public void initialize(){
        Scanner scanner = new Scanner(System.in);
        String firstSting = scanner.nextLine();

        List<Integer> listaEntita = Arrays.stream(firstSting.split(" ")).map(s -> Integer.parseInt(s.trim())).toList();
        // for i in range(listaEntita[0]) -> read input line e interpreta come chef, crea checf per ogni riga e aggiungi alla lista
        for (int i = 0; i < listaEntita.get(0); i++) {
            String[] chefData = scanner.nextLine().split(" ");
            Chef newChef = new Chef(chefData[0], Integer.parseInt(chefData[1]), Integer.parseInt(chefData[2]), Integer.parseInt(chefData[3]))
            listaChef.add(newChef);
        }
        // for i in range(listaEntita[1]) -> read input line e interpreta come piatti, crea piatto per ogni riga e aggiungi alla lista
        // for i in range(listaEntita[2]) -> read input line e interpreta come partecipanti, crea partecipante per ogni riga* e aggiungi alla lista

        // *pre crear eun'entità, si splitta la riga per " " e si interpreta ogni elemento



    }
}



