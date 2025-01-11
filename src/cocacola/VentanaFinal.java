package cocacola;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaFinal extends JFrame implements ActionListener{
    
    private ventanaUno ventanaInicio;
    private String[] trabajos, antiguedad;
    private String recuperaNombre, recuperaApellido, recuperaTrabajos, recuperaAntiguedad;
    private Color colorRGB;
    private ImageIcon imagenCocaGrande;
    private Image iconoPequenio;
    private JTextField jtext1, jtext2;
    private JComboBox jcombo1, jcombo2;
    private JTextArea jtextarea1;
    private JLabel jlabel1, jlabel2, jlabel3, jlabel4, jlabel5, jlabel6, jlabel7, jlabel8;
    private JMenuBar jmenubar1;
    private JMenu opciones, calcular, coloresFondo;
    private JMenuItem nuevo, salir, vacaciones;
    private JMenuItem colorRojo, colorNegro, colorMorado; 
    
    VentanaFinal(ventanaUno ventanaPrincipio){
        dispose();
        ventanaInicio = ventanaPrincipio;
        
        String[] trabajos = {"", "Atención al cliente", "Departamento de logística", "Departamento de gerencia"};
        String[] antiguedad = {"", "1 año de servicio", "2-6 años de servicio", "7+ años de servicio"};
        
        this.setTitle("Ventana principal");
        
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        colorRGB = new Color(255,0,0);
        getContentPane().setBackground(colorRGB);
        iconoPequenio = Toolkit.getDefaultToolkit().getImage("images/icon.png");
        this.setIconImage(iconoPequenio);
        imagenCocaGrande = new ImageIcon("images/logo-coca.png");
        
        jlabel1 = new JLabel("Bienvenido " + ventanaUno.recuperarNombre);
        jlabel1.setBounds(450,20,300,80);
        jlabel1.setFont(new Font("Andale Mono", 1, 20));
        jlabel1.setForeground(new Color(255,255,255));
        add(jlabel1);
        
        jlabel2 = new JLabel("Datos del trabajador para el cálculo de vacaciones");
        jlabel2.setBounds(120,85,500,40);
        jlabel2.setFont(new Font("Andale Mono", 1, 16));
        jlabel2.setForeground(new Color(255,255,255));
        add(jlabel2);
        
        jlabel3 = new JLabel("©2025 The Coca-Cola Company | Todos los derechos reservados");
        jlabel3.setBounds(190,340,350,30);
        jlabel3.setFont(new Font("Andale Mono", 1, 10));
        jlabel3.setForeground(new Color(255,255,255));
        add(jlabel3);
        
        jlabel4 = new JLabel("Nombre:");
        jlabel4.setBounds(15,125,100,20);
        jlabel4.setFont(new Font("Andale Mono", 1, 12));
        jlabel4.setForeground(new Color(255,255,255));
        add(jlabel4);
        
        jlabel5 = new JLabel("Apellido:");
        jlabel5.setBounds(15,185,200,20);
        jlabel5.setFont(new Font("Andale Mono", 1, 12));
        jlabel5.setForeground(new Color(255,255,255));
        add(jlabel5);
        
        jlabel6 = new JLabel("Selecciona el departamento:");
        jlabel6.setBounds(302,130,200,20);
        jlabel6.setFont(new Font("Andale Mono", 1, 12));
        jlabel6.setForeground(new Color(255,255,255));
        add(jlabel6);
        
        jlabel7 = new JLabel("Selecciona la antiguedad:");
        jlabel7.setBounds(302,180,200,20);
        jlabel7.setFont(new Font("Andale Mono", 1, 12));
        jlabel7.setForeground(new Color(255,255,255));
        add(jlabel7);
        
        jlabel8 = new JLabel(imagenCocaGrande);
        jlabel8.setBounds(10,10,300,80);
        add(jlabel8);
        
        jtext1 = new JTextField();
        jtext1.setBounds(10,150,200,25);
        add(jtext1);
        
        jtext2 = new JTextField();
        jtext2.setBounds(10,210,200,25);
        add(jtext2);
        
        jcombo1 = new JComboBox(trabajos);
        jcombo1.setBounds(300,150,200,25);
        add(jcombo1);
        
        jcombo2 = new JComboBox(antiguedad);
        jcombo2.setBounds(300,200,200,25);
        add(jcombo2);
        
        jtextarea1 = new JTextArea("\n  Aquí se muestra el resultado del cálculo \n  de vacaciones");
        jtextarea1.setBounds(300,240,240,90);
        jtextarea1.setEditable(false);
        add(jtextarea1);
        
        jmenubar1 = new JMenuBar();
        setJMenuBar(jmenubar1);
        jmenubar1.setBackground(new Color(255,0,0));
        
        opciones = new JMenu("Opciones");
        opciones.setFont(new Font("Andale Mono", 1, 15));
        opciones.setForeground(new Color(255,255,255));
        jmenubar1.add(opciones);
        
        coloresFondo = new JMenu("Colores de fondo");
        coloresFondo.setFont(new Font("Andale mono", 1, 12));
        opciones.add(coloresFondo);
        
        colorRojo = new JMenuItem("Rojo");
        colorRojo.addActionListener(this);
        coloresFondo.add(colorRojo);
        
        colorNegro = new JMenuItem("Negro");
        colorNegro.addActionListener(this);
        coloresFondo.add(colorNegro);
        
        colorMorado = new JMenuItem("Morado");
        colorMorado.addActionListener(this);
        coloresFondo.add(colorMorado);
        
        calcular = new JMenu("Calcular");
        calcular.setFont(new Font("Andale Mono",1,15));
        calcular.setForeground(new Color(255,255,255));
        jmenubar1.add(calcular);
        
        nuevo = new JMenuItem("Nuevo");
        nuevo.addActionListener(this);
        opciones.add(nuevo);
        
        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        opciones.add(salir);
        
        vacaciones = new JMenuItem("Vacaciones");
        vacaciones.addActionListener(this);
        calcular.add(vacaciones);
    }
   
    @Override
    public void actionPerformed(ActionEvent e){
        //colores de fondo
        cambioDeColorFondo(e);
        
        //recuperar texto y calcular vacaciones
        int recuperarAntiguedadEntero;
        recuperaNombre = jtext1.getText();
        recuperaApellido = jtext2.getText();
        recuperaTrabajos = jcombo1.getSelectedItem().toString();
        recuperaAntiguedad = jcombo2.getSelectedItem().toString();
        
        if(e.getSource() == vacaciones){
            calculoVacaciones(recuperaNombre, recuperaApellido, recuperaTrabajos, recuperaAntiguedad);
        }
        
        if(e.getSource() == nuevo){
            settearTodoA0();
        }
        
        if(e.getSource() == salir){
            salir(ventanaInicio);
        }
    }
    
    private void cambioDeColorFondo(ActionEvent e){
        
        Container fondo = this.getContentPane(); //checkea todas las dimensiones de la GUI
        
        if(e.getSource() == colorRojo){
            fondo.setBackground(new Color(255,0,0));
        }else if(e.getSource() == colorNegro){
            fondo.setBackground(new Color(0,0,0));
        }else if(e.getSource() == colorMorado){
            fondo.setBackground(new Color(165,0,150));
        }
    }
    
    private void calculoVacaciones(String nombre, String apellido, String trabajos, String antiguedad){
        
        switch(trabajos.trim()){
            
            case "Atención al cliente":
                
                if(antiguedad.trim().equals("1 año de servicio")){
                    jtextarea1.setText("\n  El trabajador " + nombre + " " + apellido + " quien labora en" + "\n" + "  el area de " + trabajos + " con \n  " + antiguedad + " de servicio, recibe 6 días\n  de vacaciones" );
                }else if(antiguedad.trim().equals("2-6 años de servicio")){
                    jtextarea1.setText("\n  El trabajador " + nombre + " " + apellido + " quien labora en" + "\n" + "  el area de " + trabajos + " con \n  " + antiguedad + " de servicio, recibe 14 \n  días  de vacaciones" );
                }else if(antiguedad.trim().equals("7+ años de servicio")){
                    jtextarea1.setText("\n  El trabajador " + nombre + " " + apellido + " quien labora en" + "\n" + "  el area de " + trabajos + " con \n  " + antiguedad + " de servicio, recibe 20 \n  días de vacaciones" );
                }
                break;
                
            case "Departamento de logística":
                
                if(antiguedad.trim().equals("1 año de servicio")){
                    jtextarea1.setText("\n  El trabajador " + nombre + " " + apellido + " quien labora en" + "\n" + "  el area de " + trabajos + " con \n  " + antiguedad + " de servicio, recibe 7 días\n  de vacaciones" );
                }else if(antiguedad.trim().equals("2-6 años de servicio")){
                    jtextarea1.setText("\n  El trabajador " + nombre + " " + apellido + " quien labora en" + "\n" + "  el area de " + trabajos + " con \n  " + antiguedad + " de servicio, recibe 15 \n  días de vacaciones" );
                }else if(antiguedad.trim().equals("7+ años de servicio")){
                    jtextarea1.setText("\n  El trabajador " + nombre + " " + apellido + " quien labora en" + "\n" + "  el area de " + trabajos + " con \n  " + antiguedad + " de servicio, recibe 22 \n  días de vacaciones" );
                }
                break;
                
             case "Departamento de gerencia":
                 
                 if(antiguedad.trim().equals("1 año de servicio")){
                    jtextarea1.setText("\n  El trabajador " + nombre + " " + apellido + " quien labora en" + "\n" + "  el area de " + trabajos + " con \n  " + antiguedad + " de servicio, recibe 10 días\n  de vacaciones" );
                }else if(antiguedad.trim().equals("2-6 años de servicio")){
                    jtextarea1.setText("\n  El trabajador " + nombre + " " + apellido + " quien labora en" + "\n" + "  el area de " + trabajos + " con \n  " + antiguedad + " de servicio, recibe 20 \n  días de vacaciones" );
                }else if(antiguedad.trim().equals("7+ años de servicio")){
                    jtextarea1.setText("\n  El trabajador " + nombre + " " + apellido + " quien labora en" + "\n" + "  el area de " + trabajos + " con \n  " + antiguedad + " de servicio, recibe 30 \n  días de vacaciones" );
                }
                break;
                
             case "":
                 JOptionPane.showMessageDialog(null, "Por favor, rellene todo los campos para continuar");
             break;
        }
    }
    
    private void settearTodoA0(){
        jtext1.setText("");
        jtext2.setText("");
        jcombo1.setSelectedIndex(0);
        jcombo2.setSelectedIndex(0);
        jtextarea1.setText("\n  Aquí se muestra el resultado del cálculo \n  de vacaciones");
    }
    
    private void salir(ventanaUno ventanaInicio){
        this.dispose();
        ventanaInicio.setVisible(true);
    }
}
