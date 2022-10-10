package serie1.es2;

public class Main {
    public static void main(String[] args) {
        Lista<Integer> lista1 = new Lista<>();

        lista1.inserisciInCoda(4);
        lista1.inserisciInCoda(3);
        lista1.printLista();
        lista1.sort();
        lista1.printLista();
        lista1.rimuovi(3);
        lista1.printLista();

        Lista<Double> lista2 = new Lista<>();

        lista2.inserisciInCoda(4.2);
        lista2.inserisciInCoda(3.5);
        lista2.printLista();
        lista2.sort();
        lista2.printLista();
        lista2.rimuovi(3.5);
        lista2.printLista();
    }
}
