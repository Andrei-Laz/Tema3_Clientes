package t3ejercicio4B;

import java.io.*;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) {
        try {
            //Prueba a IP de compañero
            //Socket socket = new Socket("10.112.4.140", 12345);
            Socket socket = new Socket("localhost", 12345);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream,true);
            out.println("Hola Servidor");

            InputStream inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String respuesta = in.readLine();
            System.out.printf("Mensaje de servidor: %s", respuesta);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
