/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_refuerzoIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ruben
 */
public class Cliente{ 
    public static void main(String[]args) throws IOException{
    InetAddress ip=null;
    String cadena;
    
    try{
        ip = InetAddress.getByName("localhost");
    
    }catch(Exception ex){
        System.err.println("Error -> "+ex.getMessage());

    }
    
    try(
        Socket sc = new Socket(ip,15000);
        PrintWriter SAL = new PrintWriter(sc.getOutputStream(), true);
        BufferedReader ENT = new BufferedReader(new InputStreamReader(sc.getInputStream()));    
        ){
            
            
            while(true){
                cadena=ENT.readLine();
                if(cadena.equals("exit") || cadena.equals("quit")){
                    System.out.println("Saliendo del servidor...");
                    System.exit(0);
                }
                SAL.println("["+ip+"]> "+cadena);
            }
        
        }catch(Exception e){
            System.err.println("Error -> " + e.getMessage());
        }

    }
    
}
