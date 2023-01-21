/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gatos_app;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author MrX
 */
public class Inicio {
    public static void main(String[] args) throws IOException {
        
        String[] opcion= {"Ver Gatitos", "Salir"};
        int selectedOption = JOptionPane.showOptionDialog(null, "Selecciona una opción", "Gatitos APP", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcion, opcion[0]);
        
        if(selectedOption==0){
           GatosServices.verGatitos();
        
        }else if(selectedOption== 1) {
            System.out.println("Elegiste salir");
        }
        
    }
}
