package Logica;

import javax.swing.*;

/**
 * Cola es una clase que define una estructura de datos que sigue el principio FIFO. Para su implementacion se va
 * a hacer uso del concepto de listas enlazadas.
 * @author Christopher Miranda
 */
public class Cola {

    private int cantidadClientes;
    private Nodo inicio;
    private Nodo fin;
    private String stringAtendidos = "";

    /**
     * Se crea una cola de prioridad sin recibir parámetros
     */
    public Cola(){

        this.cantidadClientes = 0;
        this.inicio = null;
        this.fin = null;
    }

    /**
     * Devuelve un booleano si la cola está vacía o no
     * @return devuelve el estado de la pila
     */
    public boolean isEmpty(){

        return this.inicio == null && this.fin == null;
    }

    /**
     * Agrega un elemento a la cola
     * @param cliente una instacia de la clase Cliente
     * @param textArea area de texto de Swing UI
     */
    public void enqeueCliente(Cliente cliente, JTextArea textArea){

        Nodo nuevoCliente = new Nodo(cliente, null);

        if(!isEmpty()){

            this.fin.setProximo(nuevoCliente);
            this.fin = nuevoCliente;
        }else{

            this.fin = this.inicio = nuevoCliente;
        }

        this.cantidadClientes++;
        refresh(textArea);
    }

    /**
     * Se encarga de sacar a un cliente de la cola
     * @param textArea es un area de texto donde se visualizan los clientes en la cola
     * @param textArea2 es un area de texto donde se visualizan los clientes atendidos
     */
    public void deqeueCliente(JTextArea textArea, JTextArea textArea2){

        if(!isEmpty()){

            stringAtendidos += this.inicio.getCliente().getNombre() + " \t" + "->\tAtendido" + "\n";
            textArea2.setText(stringAtendidos);

            if(this.inicio == this.fin){

                this.inicio = this.fin = null;
            }else{

                this.inicio = this.inicio.getProximo();
            }

            this.cantidadClientes--;
        }else{

            JOptionPane.showMessageDialog(null, "No hay nadie en la cola");
        }

        refresh(textArea);
    }

    /**
     * Devuelve los nombres de los clientes
     * @return devuelve un string donde se ha concatenado la informacion de los clientes
     */
    public String showClientes(){

        StringBuilder stringClientes = new StringBuilder();

        if(!isEmpty()){

            Nodo aux = this.inicio;
            while(aux != null){

                stringClientes.append(aux.getCliente().getNombre()).append("\n");
                aux = aux.getProximo();
            }

            return stringClientes.toString();
        }else{

            return stringClientes.toString();
        }
    }

    /**
     * Refresca el área de texto donde se visualiza los clientes a la cola
     * @param textArea un area de texto
     */
    public void refresh(JTextArea textArea){

        textArea.setText("Cantidad de personas en cola: " + this.cantidadClientes + "\n" + showClientes());
    }
}
