package cocacola;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class VentanaCondiciones extends JFrame implements ActionListener, ChangeListener{
    
    private ventanaUno ventanaAnterior;
    private Image iconoPequenio;
    private ImageIcon imagenCocaGrande;
    private JLabel label2,label3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JCheckBox checkbox;
    private JButton boton1, boton2;
    private FileReader archivo;
    private BufferedReader lector;
    private String terminosYCondiciones;
    
    VentanaCondiciones(ventanaUno anterior){
        
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventanaAnterior = anterior;
        
        iconoPequenio = Toolkit.getDefaultToolkit().getImage("images/icon.png");
        this.setIconImage(iconoPequenio);
        imagenCocaGrande = new ImageIcon("images/coca-cola.png");
        
        label3 = new JLabel(imagenCocaGrande);
        label3.setBounds(0,0,1000,640);
        add(label3);
        
        label2 = new JLabel("TÉRMINOS Y CONDICIONES");
        label2.setBounds(220, 0, 170, 40);
        add(label2);
        
        textArea1 = new JTextArea();
        textArea1.setBounds(10,40,600,240);
        add(textArea1);
        
        try{
            
            archivo = new FileReader("Condiciones.txt");
            
            if(archivo.ready()){
                lector = new BufferedReader(archivo);
                terminosYCondiciones = lector.readLine();
                
                while(terminosYCondiciones != null){
                    textArea1.append(terminosYCondiciones + "\n");
                    terminosYCondiciones = lector.readLine();
                }
            }else{
                textArea1.append("NO SE HA PODIDO LEER EL ARCHIVO");
            }
            
        }catch(Exception e){
            textArea1.append("NO SE HA PODIDO LEER EL ARCHIVO");
        }
        
        scrollPane1 = new JScrollPane(textArea1);
        scrollPane1.setBounds(10,40,600,240);
        this.add(scrollPane1);
        
        checkbox = new JCheckBox("Yo " + ventanaUno.recuperarNombre + " acepto");
        checkbox.setBounds(10,280,150,30);
        add(checkbox);
        checkbox.addChangeListener(this);
        
        boton1 = new JButton("Continuar");
        boton1.setBounds(10,320,90,30);
        add(boton1);
        boton1.setEnabled(false);
        boton1.addActionListener(this);
        
        boton2 = new JButton("No acepto");
        boton2.setBounds(110,320,110,30);
        add(boton2);
        boton2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton2){
            this.dispose();
            ventanaAnterior.setVisible(true);
        }else if(e.getSource() == boton1){
            dispose();
            abrirVentanaFinal();
        }
    }
    
    public void stateChanged(ChangeEvent e){
        if(checkbox.isSelected()){
             boton1.setEnabled(true);
             boton2.setEnabled(false);
        }else if(checkbox.isSelected() == false){
            boton1.setEnabled(false);
            boton2.setEnabled(true);
        }
    }
    
    private void abrirVentanaFinal(){
        
        VentanaFinal ventafinal = new VentanaFinal(ventanaAnterior);
        ventafinal.setVisible(true);
        ventafinal.setBounds(0,0,700,430);
        ventafinal.setLocationRelativeTo(null);
        ventafinal.setResizable(true);
    }
    
}
