package Conection;

import Conection.paquete;
import View.ventana;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class recibir extends Thread {

    ventana ven;

    public recibir(ventana ven){
        this.ven = ven;
    }

    @Override
    public void run() {
        try {
            ServerSocket servidorCliente = new ServerSocket(9999);
            Socket cliente;
            paquete paquete;

            while (true){
                cliente = servidorCliente.accept(); //Acepta las peticiones
                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

                paquete = (paquete) entrada.readObject();

                if (!paquete.getTexto().equals(" %&OnLiNe&")){
                    ven.jtaChat.setText(ven.jtaChat.getText() + "\n" + paquete.getUsuario() + ": " + paquete.getTexto());
                }else {
                    ArrayList<String> conectados = new ArrayList <String>();
                    conectados = paquete.getConectados();
                    ven.selecUsuario.removeAllItems();  //Elimina para reiniciar
                    ven.selecUsuario.addItem("Multicast");

                    for (String c: conectados){
                        ven.selecUsuario.addItem(c);
                    }
                }
                entrada.close();
            }
        } catch (IOException e) {
            System.out.println("Error de conexion");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
