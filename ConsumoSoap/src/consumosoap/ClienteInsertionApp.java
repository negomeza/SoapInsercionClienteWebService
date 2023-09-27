/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumosoap;

import ws.MyWebService;
import ws.MyWebService_Service;
/**
 *
 * @author NELSON
 */
public class ClienteInsertionApp {

    public static void main(String[] args) {
        // Crear un cliente de servicio web
        MyWebService_Service service = new MyWebService_Service();
        MyWebService port = service.getMyWebServicePort();

        // Definir los datos del cliente a insertar
        int id = 1;
        String nombre = "Nombre del Cliente";
        String direccion = "Dirección del Cliente";
        String telefono = "1234567890";
        String correo = "cliente@example.com";
        String fechaNacimiento = "2000-01-01";
        double saldo = 100.0;
        String fechaUltimaCompra = "2023-09-26";

        // Llamar al método del servicio web para insertar el registro del cliente
        String resultado = port.agregarCliente(id, nombre, direccion, telefono, correo, fechaNacimiento, saldo, fechaUltimaCompra);

        // Imprimir el resultado
        System.out.println("Resultado de la inserción: " + resultado);
    }
}
