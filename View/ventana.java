package View;

import Conection.conectarServidor;
import Conection.recibir;
import Controller.controlador;

import javax.swing.*;
import java.awt.*;

public class ventana extends JFrame {

    private String usuario;

    public JPanel panelPrincipal, panel1, panel2, panel3, panel4;

    public JComboBox selecUsuario;
    public JButton jbEnviar;
    public JTextField jtfEnviar;
    public JScrollPane scroll;
    public JTextArea jtaChat;
    public JLabel jlIp;

    public ventana(String usuario){
        this.usuario = usuario; //Usuario inciado

        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        crearVentanaPrincipal();
        add(panelPrincipal);
        setVisible(true);
        setTitle("Cliente");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();

        addWindowListener(new conectarServidor(usuario));
        recibir recibir = new recibir(this);
        recibir.start();
    }

    public void crearVentanaPrincipal(){
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        crearPanel1();
        crearPanel2();
        crearPanel3();
        crearPanel4();

        panelPrincipal.add(panel1);
        panelPrincipal.add(panel2);
        panelPrincipal.add(panel3);
        panelPrincipal.add(panel4);

    }

    public void crearPanel1(){
        panel1 = new JPanel();
        jlIp = new JLabel("Destino: ");
        selecUsuario = new JComboBox();

        panel1.setLayout(new GridLayout(0,1));
        panel1.add(jlIp);
        panel1.add(selecUsuario);
    }

    public void crearPanel2(){
        panel2 = new JPanel();
        jtaChat = new JTextArea(10,20);

        scroll = new JScrollPane(jtaChat);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jtaChat.setEditable(false);

        panel2.setLayout(new GridLayout(0,1));
        panel2.add(scroll);
    }


    public void crearPanel3(){
        panel3 = new JPanel();
        jtfEnviar = new JTextField();

        panel3.setLayout(new GridLayout(1,1));
        panel3.add(jtfEnviar);
    }

    public void crearPanel4(){
        panel4 = new JPanel();
        jbEnviar = new JButton("Enviar");

        panel4.add(jbEnviar);

        jbEnviar.addActionListener(new controlador(this));
    }


    public String dameUsuario(){
        return usuario;
    }
}
