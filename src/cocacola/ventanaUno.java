package cocacola;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ventanaUno extends JFrame implements ActionListener{
    
    private Color colorRGB;
    private JLabel imagenBienvenida;
    private ImageIcon image;
    private Image icono;
    private JTextField nombreUsuario;
    private JLabel label, label2;
    public static JButton botonSiguiente;
    public static String recuperarNombre;
    
    ventanaUno(){
        setLayout(null);
        this.setTitle("Ventana uno");
        colorRGB  = new Color(255,0,0);
        getContentPane().setBackground(colorRGB);
        icono = Toolkit.getDefaultToolkit().getImage("images/icon.png");
        this.setIconImage(icono);
        image = new ImageIcon("images/logo-coca.png");
        
        imagenBienvenida = new JLabel(image);
        imagenBienvenida.setBounds(0,0,230,320);
        add(imagenBienvenida);
        
        nombreUsuario = new JTextField();
        nombreUsuario.setBounds(15, 250, 200, 30);
        add(nombreUsuario);
        
        label = new JLabel("Introduzca su nombre");
        label.setBounds(17,220,130,30);
        label.setForeground(Color.white);
        add(label);
        
        label2 = new JLabel("©2025 The Coca-Cola Company.");
        label2.setForeground(Color.white);
        label2.setBounds(10,380,190,30);
        add(label2);
        
        botonSiguiente = new JButton("Siguiente");
        botonSiguiente.setBounds(120,340,90,30);
        botonSiguiente.addActionListener(this);
        add(botonSiguiente);
    }
    
    private void abrirVentanaCondiciones(){
        
        dispose();
                
        VentanaCondiciones terminos = new VentanaCondiciones(this);
        terminos.setVisible(true);
        terminos.setBounds(0,0,700,400);
        terminos.setLocationRelativeTo(null);
        terminos.setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == botonSiguiente){
            recuperarNombre = nombreUsuario.getText();
            if(recuperarNombre.isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor, introduzca un nombre para continuar");
            }else{
                abrirVentanaCondiciones();
            }
        }
    }
}
