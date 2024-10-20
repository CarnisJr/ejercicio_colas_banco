package Logica;

public class Nodo {

    Cliente cliente;
    Nodo proximo;

    /**
     * Para crear un nodo se debe ingresar al cliente y instanciar el siguiente nodo
     * @param cliente una instacia de la clase Cliente
     * @param proximo reservar la memoria para el siguiente nodo, siempre null
     */
    public Nodo(Cliente cliente, Nodo proximo) {

        this.cliente = cliente;
        this.proximo = proximo;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Nodo getProximo(){
        return this.proximo;
    }

    public void setProximo(Nodo proximo){
        this.proximo = proximo;
    }
}
