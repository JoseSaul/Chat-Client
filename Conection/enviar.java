package Conection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class enviar {

    private String ipServer = "localhost";   //Cambiar antes de usar
    private paquete paquete;

    public enviar(paquete paquete){
        this.paquete = paquete;
    }

    public void conectar(){
        try {

            Socket miConexion = new Socket(ipServer,9090);
            ObjectOutputStream salida = new ObjectOutputStream(miConexion.getOutputStream());
            salida.writeObject(paquete);

            salida.close();
            miConexion.close();

        } catch (IOException e) {
            System.out.println("No puede conectar");
        }
    }

}
