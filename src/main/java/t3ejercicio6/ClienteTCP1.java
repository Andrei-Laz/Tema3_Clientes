package t3ejercicio6;

import java.io.*;
import java.net.Socket;

public class ClienteTCP1 {
    public static void main(String[] args) {
        try {
            //socket que se conecta al servidor de Marc
            Socket socket = new Socket("10.112.4.136", 12345);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream,true);

            Integer mensajeEntero = 69;

            out.printf("%d", mensajeEntero);

            //Codigo usado para recibir confirmación del envío del mensaje
//            InputStream inputStream = socket.getInputStream();
//            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//            String respuesta = in.readLine();
//            System.out.printf("Mensaje de servidor: %s", respuesta);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
