package Controller;

import View.ventana;
import View.ventanaNombre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controladorUsuario implements ActionListener {

    ventanaNombre ventanaNombre;

    public controladorUsuario(ventanaNombre ventanaNombre){
        this.ventanaNombre = ventanaNombre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().contentEquals("Aceptar")){
            if (!ventanaNombre.jtfUsuario.getText().equals("")){
                ventana ven = new ventana(ventanaNombre.jtfUsuario.getText());
                ventanaNombre.setVisible(false);
            }
        }
    }
}
