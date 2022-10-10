package serie1.es2;

public class Nodo <T> {
    T elemento;
    private Nodo next;
    private Nodo previus;

    public T getElemento() {
        return elemento;
    }

    public Nodo getNext() {
        return next;
    }

    public Nodo getPrevius() {
        return previus;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public void setPrevius(Nodo previus) {
        this.previus = previus;
    }

    Nodo(T elemento) {
        this.elemento = elemento;
    }

    public boolean compare(T ele1){
        if(this.elemento == ele1)
            return true;
        else return false;
    }

}
