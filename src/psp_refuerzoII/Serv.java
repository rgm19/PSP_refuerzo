/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_refuerzoII;

import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author usuario5
 */
public class Serv {
    public static void main(String [] args){
        ArrayList<Usuarios> misUsuarios = new ArrayList<Usuarios>();
        System.out.println("+-----------------------------------------+");
        System.out.println("|-------      SERVIDOR PUBLICO     -------|");
        System.out.println("|-------           (V 1.0)         -------|");
        System.out.println("+-----------------------------------------+");
        
        int cli=1;
        
        try(
                ServerSocket ss = new ServerSocket(15000);
            ){
            
                Hablaservidor habla = new Hablaservidor(misUsuarios);
                Thread h1 = new Thread(habla);
                h1.start();
            
                  while(true){
                    HiloServidor hs = new HiloServidor(ss.accept(),cli,misUsuarios);
                    Thread hilo = new Thread(hs);    
                    hilo.start();
                    cli++;
                }
            
            
        }catch(Exception ex){
                System.err.println("Error -> "+ex.getMessage());
            }
    }
}
