package cocacola;

import java.awt.event.*;
import javax.swing.*;

public class CocaCola{

    public static void main(String[] args) {
        
        ventanaUno primeraVentana = new ventanaUno();
        
        primeraVentana.setVisible(true);
        primeraVentana.setBounds(0,0,250,450);
        primeraVentana.setLocationRelativeTo(null);
        primeraVentana.setResizable(false);
        primeraVentana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
