package Controller;

import Conection.enviar;
import Conection.paquete;
import View.ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador implements ActionListener {

    ventana ven;

    public controlador(ventana ven){
        this.ven = ven;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().contentEquals("Enviar")){
            paquete paquete = new paquete();

            paquete.setUsuario(ven.dameUsuario());
            paquete.setIp(ven.selecUsuario.getSelectedItem().toString());
            paquete.setTexto(ven.jtfEnviar.getText());

            ven.jtaChat.setText(ven.jtaChat.getText() + "\n" + paquete.getUsuario() + ": " + paquete.getTexto());

            enviar enviar = new enviar(paquete);
            enviar.conectar();

            ven.jtfEnviar.setText("");
        }

    }
}
