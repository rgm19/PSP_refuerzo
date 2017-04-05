/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_refuerzoII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario5
 */
public class Hablaservidor implements Runnable {
    
    private ArrayList<Usuarios> clientes;
    static Scanner teclado = new Scanner(System.in);

    public Hablaservidor(ArrayList<Usuarios> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public void run(){
        
                String cad;            
                while(true){
                    cad=teclado.nextLine();
                    if(cad.equalsIgnoreCase("quit") || cad==null || cad.equalsIgnoreCase("exit")){System.exit(-1);}
                    mandarMensaje(cad);
                }
    }

    private void mandarMensaje(String cad) {
            System.out.println("[***Servidor***]>"+cad);
          for(Usuarios usu: clientes){            
                usu.getOUT().println("[***Servidor***]>"+cad);
        }
    }
    
}
