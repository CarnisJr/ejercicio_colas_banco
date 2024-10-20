package GUI;

import Logica.Cliente;
import Logica.Cola;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColaBancoUI {
    private JTextField textField1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton agregarALaColaButton;
    private JButton atenderAClienteButton;
    private JPanel ColaBancoUI;
    private Cola cola = new Cola();

    public ColaBancoUI() {
        cola.refresh(textArea1);
        agregarALaColaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(textField1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Nombre no válido");
                }else{

                    Cliente cliente = new Cliente(textField1.getText());
                    cola.enqeueCliente(cliente, textArea1);
                    textField1.setText("");
                }
            }
        });
        atenderAClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cola.deqeueCliente(textArea1, textArea2);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColaBancoUI");
        frame.setContentPane(new ColaBancoUI().ColaBancoUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
