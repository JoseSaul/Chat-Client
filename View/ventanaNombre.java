package View;

import Controller.controladorUsuario;

import javax.swing.*;
import java.awt.*;

public class ventanaNombre extends JFrame {

    private JPanel panel;
    private JLabel jlUsuario;
    public JTextField jtfUsuario;
    public JButton acceptar;

    public ventanaNombre(){
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        crearPanel();
        add(panel);
        setVisible(true);
        setTitle("Cliente");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
    }

    private void crearPanel(){
        panel = new JPanel();
        jlUsuario = new JLabel("Usuario: ");
        jtfUsuario = new JTextField();
        acceptar = new JButton("Aceptar");

        panel.setLayout(new GridLayout(0,1,2,5));
        panel.add(jlUsuario);
        panel.add(jtfUsuario);
        panel.add(acceptar);

        acceptar.addActionListener(new controladorUsuario(this));
    }


}
