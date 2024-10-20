package Logica;

import javax.swing.*;

public class Cola {

    private int cantidadClientes;
    private Nodo inicio;
    private Nodo fin;
    private String stringAtendidos = "";

    public Cola(){

        this.cantidadClientes = 0;
        this.inicio = null;
        this.fin = null;
    }

    //Verificar si esta vacio
    public boolean isEmpty(){

        return this.inicio == null && this.fin == null;
    }

    //agregar a la cola
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

    //quitar de la cola
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

    //Mostrar los elementos
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

    public void refresh(JTextArea textArea){

        textArea.setText("Cantidad de personas en cola: " + this.cantidadClientes + "\n" + showClientes());
    }
}
