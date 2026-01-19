package t3ejercicio6;

import t3ejercicio5.ClienteUDP;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteUDP3 {
    public static void main(String[] args) {

        final int PUERTO_SERVIDOR = 12345;
        byte[] buffer;
        ByteBuffer bytes = ByteBuffer.allocate(Integer.BYTES);

        try {
            //IP del servidor de Marc
            InetAddress direccionServidor = InetAddress.getByName("10.112.4.136");

            DatagramSocket socketUDP = new DatagramSocket();

            Integer mensaje = 69247;
            bytes.putInt(mensaje);

            buffer = bytes.array();

            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);

            System.out.println("Envio datos al servidor");
            socketUDP.send(pregunta);

            socketUDP.close();

        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
