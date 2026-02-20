package t3ejercicio5B;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteUDP5B {

    public static void main(String[] args) {

        // Puerto del servidor
        final int PUERTO_SERVIDOR = 5000;

        try {
            // Obtener la dirección IP del servidor (localhost)
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            // Crear el socket UDP (puerto efímero automático)
            DatagramSocket socketUDP = new DatagramSocket();

            // Mensaje a enviar
            String mensaje = "¡Hola mundo desde el cliente!";

            // Convertir mensaje a bytes
            byte[] bufferEnvio = mensaje.getBytes();

            // Crear datagrama con destino al servidor
            DatagramPacket pregunta = new DatagramPacket(
                    bufferEnvio,
                    bufferEnvio.length,
                    direccionServidor,
                    PUERTO_SERVIDOR
            );

            // Enviar paquete
            System.out.println("Envio datos al servidor");
            socketUDP.send(pregunta);

            // Preparar buffer para recibir respuesta
            byte[] bufferRecepcion = new byte[1024];
            DatagramPacket respuesta = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);

            // Recibir respuesta del servidor (bloqueante)
            socketUDP.receive(respuesta);
            System.out.println("Recibo datos del servidor");

            // Convertir solo los bytes realmente recibidos
            String mensajeRespuesta = new String(
                    respuesta.getData(),
                    0,
                    respuesta.getLength()
            );

            System.out.println("Respuesta del servidor: " + mensajeRespuesta);

            // Cerrar socket
            socketUDP.close();

        } catch (SocketException ex) {
            Logger.getLogger(ClienteUDP5B.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteUDP5B.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP5B.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}