package Conection;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class conectarServidor extends WindowAdapter{

    String ipServer = "localhost";   //Cambiar antes de usar
    String usuario;

    public conectarServidor(String usuario){
        this.usuario = usuario;
    }

    public void windowOpened(WindowEvent e){
            paquete paquete = new paquete();
            paquete.setUsuario(usuario);
            paquete.setIp(ipServer);
            paquete.setTexto(" %&OnLiNe&");

            enviar enviar = new enviar(paquete);
            enviar.conectar();
    }

}
