/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumosoap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ws.MyWebService;
import ws.MyWebService_Service;


public class ClienteInsertionGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField idField, nombreField, direccionField, telefonoField, correoField, fechaNacimientoField, saldoField, fechaUltimaCompraField;
    private JButton insertButton;

    public ClienteInsertionGUI() {
        frame = new JFrame("Inserción de Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Dirección:"));
        direccionField = new JTextField();
        panel.add(direccionField);

        panel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        panel.add(telefonoField);

        panel.add(new JLabel("Correo:"));
        correoField = new JTextField();
        panel.add(correoField);

        panel.add(new JLabel("Fecha de Nacimiento:"));
        fechaNacimientoField = new JTextField();
        panel.add(fechaNacimientoField);

        panel.add(new JLabel("Saldo:"));
        saldoField = new JTextField();
        panel.add(saldoField);

        panel.add(new JLabel("Fecha de Última Compra:"));
        fechaUltimaCompraField = new JTextField();
        panel.add(fechaUltimaCompraField);

        insertButton = new JButton("Insertar Cliente");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertarCliente();
            }
        });
        panel.add(insertButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void insertarCliente() {
        // Recuperar los valores de los campos de texto
        int id = Integer.parseInt(idField.getText());
        String nombre = nombreField.getText();
        String direccion = direccionField.getText();
        String telefono = telefonoField.getText();
        String correo = correoField.getText();
        String fechaNacimiento = fechaNacimientoField.getText();
        double saldo = Double.parseDouble(saldoField.getText());
        String fechaUltimaCompra = fechaUltimaCompraField.getText();

        // Llamar al servicio web para insertar el cliente
        MyWebService_Service service = new MyWebService_Service();
        MyWebService port = service.getMyWebServicePort();
        String resultado = port.agregarCliente(id, nombre, direccion, telefono, correo, fechaNacimiento, saldo, fechaUltimaCompra);

        // Mostrar el resultado en una ventana de diálogo
        JOptionPane.showMessageDialog(frame, resultado, "Resultado de la inserción", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClienteInsertionGUI();
            }
        });
    }
}