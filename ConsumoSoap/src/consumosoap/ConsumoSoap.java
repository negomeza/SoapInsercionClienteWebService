/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumosoap;

/**
 *
 * @author NELSON
 */
public class ConsumoSoap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int numero1 = 5;
        int numero2 = 10;
        int respuesta = 0;
        respuesta = suma(numero1,numero2);
        
        double lado = 5;
        double cuadrado = 0;
        cuadrado = calcularAreaCuadrado(lado);
        
        double pentagono = 0;
        pentagono = calcularAreaPentagonoRegular(lado);
        
    }

    private static int suma(int numero1, int numero2) {
        ws.MyWebService_Service service = new ws.MyWebService_Service();
        ws.MyWebService port = service.getMyWebServicePort();
        return port.suma(numero1, numero2);
    }

    private static double calcularAreaCuadrado(double lado) {
        ws.MyWebService_Service service = new ws.MyWebService_Service();
        ws.MyWebService port = service.getMyWebServicePort();
        return port.calcularAreaCuadrado(lado);
    }

    private static double calcularAreaPentagonoRegular(double lado) {
        ws.MyWebService_Service service = new ws.MyWebService_Service();
        ws.MyWebService port = service.getMyWebServicePort();
        return port.calcularAreaPentagonoRegular(lado);
    }
    
    
    
}
