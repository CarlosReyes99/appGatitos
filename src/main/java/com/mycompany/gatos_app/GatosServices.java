/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gatos_app;

import com.google.gson.Gson;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author MrX
 */
public class GatosServices {
    
    public static void verGatitos() throws IOException{
        
        //Trayendo datos de la API
       OkHttpClient client = new OkHttpClient().newBuilder().build();
       Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").method("GET", null).build();
       Response response = client.newCall(request).execute();
       
       String json= response.body().string();
       
       //Cortando primer y último corchete para poder leer el body
       json= json.substring(1, json.length());
       json= json.substring(0, json.length()-1);
       
       //crear un objeto de la clase json 
       Gson gson = new Gson();
       Gatos gatos= gson.fromJson(json, Gatos.class);
       
       //Redimensionando imagen 
       Image image= null;
       
        try {
            URL url= new URL(gatos.getUrl());
            image=ImageIO.read(url);
            ImageIcon fondoGato= new ImageIcon(image);
            
            if(fondoGato.getIconWidth() >800){
                
                Image modificada= fondoGato.getImage().getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);
            }
            
            
            String menu= "Opciones \n"+"Ver otro gatito"+"Gatito Favorito"+"Volver";
            String idGato= gatos.getId();
            
            String[] opcion= {"Ver otro gatito", "Gatito Favorito", "Volver"};
        int selectedOption = JOptionPane.showOptionDialog(null, menu, idGato, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, fondoGato, opcion, opcion[0]);
        
        if(selectedOption==0){
           GatosServices.verGatitos();
        
        }else if(selectedOption== 1) {
            System.out.println("Elegiste gato favorito");
            GatosServices.gatoFavorito(gatos);
        }else if (selectedOption==2) {
                System.out.println("Elegiste salir");
            }
            
        } catch (IOException e) {
            System.out.println(e);
        }
       
       
    }

    private static void gatoFavorito(Gatos gatos) {
        
    }
    
}
