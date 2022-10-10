package serie1.es2;

public class Lista <T>{
    private Nodo head;
    private Nodo tail;

    private void inserisciInTesta(T elementoDaAggiungere) {
        Nodo nuovoNodo = new Nodo(elementoDaAggiungere);

        nuovoNodo.setNext(head);

        head = nuovoNodo;
    }

    public void inserisciInCoda(T elementoDaAggiungere) {

        if (head == null) {
            // La lista e' vuota, inserisci l'elemento in testa
            inserisciInTesta(elementoDaAggiungere);
            return;
        }

        // Scorrere la lista alla ricerca dell'ultimo nodo
        Nodo nodoCorrente = head;
        while (nodoCorrente.getNext() != null) {
            nodoCorrente.setNext(nodoCorrente.getNext());
        }

        // Creo il nuovo nodo
        Nodo nuovoNodo = new Nodo(elementoDaAggiungere);
        nuovoNodo.setNext(null);

        // Aggiungo il nuovo nodo, come ultimo nodo della lista
        nodoCorrente.setNext(nuovoNodo);
        tail = nuovoNodo;
    }

    public boolean rimuovi(T elementoDaRimuovere) {
        if (head == null) {
            // La lista e' vuota
            System.out.println("La lista e' vuota, non ci sono nodi da eliminare");
            return false;
        }
        // Cerca l'elemento da rimuovere partendo dalla testa
        Nodo nodoCorrente = head;
        while (nodoCorrente.getNext() != null && !nodoCorrente.getNext().getElemento().equals(elementoDaRimuovere)) {
            nodoCorrente.setNext(nodoCorrente.getNext());
        }
        if (nodoCorrente.getNext() == null) {
            // L'elemento da eliminare non e' presente nella lista
            return false;
        }
        // L'elemento da eliminare si trova nella lista
        nodoCorrente.setNext(nodoCorrente.getNext().getNext());
        tail = nodoCorrente.getNext();
        return true;
    }

    public void printLista() {
        if (head == null) {
            // Lista e' vuota
            System.out.println("Lista vuota.");
            return;
        }
        // Inizia ad attraversare la lista dalla testa
        Nodo nodoCorrente = head;
        while (nodoCorrente != null) {
            System.out.println(nodoCorrente.getElemento()); // Stampa a schermo la Persona presente nel nodo corrente
            // Passa al prossimo elemento
            nodoCorrente.setNext(nodoCorrente.getNext());
        }
    }

    public void sort(){
        Nodo start = head;
        Nodo corrente;
        while (start != null ){
            corrente = start.getNext();
            while(corrente != null){
                if(start.compare(corrente.elemento)){
                    Nodo temp = corrente;
                    start = corrente;
                    corrente = temp;
                }
                corrente.setNext(corrente.getNext());
            }
            start.setNext(start.getNext());
        }
    }

}
