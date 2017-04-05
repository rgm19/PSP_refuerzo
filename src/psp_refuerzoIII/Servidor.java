/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_refuerzoIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import psp_refuerzoII.Hablaservidor;
import psp_refuerzoII.HiloServidor;
import psp_refuerzoII.Usuarios;

/**
 *
 * @author usuario5
 */
public class Servidor{
       public static void main(String [] args) throws IOException{
        boolean salir=false;
        String cad;
        System.out.println("+-----------------------------------------+");
        System.out.println("|-------      SERVIDOR PUBLICO     -------|");
        System.out.println("|-------           (V 2.0)         -------|");
        System.out.println("+-----------------------------------------+");
        
        
        
        try(
                ServerSocket ss = new ServerSocket(15000);
                Socket sc1 = ss.accept();
                BufferedReader ENT = new BufferedReader(new InputStreamReader(sc1.getInputStream()));
            ){
            
                /*    
                Hablaservidor habla = new Hablaservidor(misUsuarios);
                Thread h1 = new Thread(habla);
                h1.start();
                */
                
                  while(true){
                      cad=ENT.readLine().trim();
                      if(cad.equalsIgnoreCase("quit") || cad==null || cad.equalsIgnoreCase("exit")){System.exit(-1);}
                      System.out.println("[***Servidor***]>"+cad);
                }
            
            
        }catch(Exception ex){
                System.err.println("Error -> "+ex.getMessage());
            }
    }
}
