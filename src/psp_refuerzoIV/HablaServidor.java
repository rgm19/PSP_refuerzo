/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_refuerzoIV;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario5
 */
public class HablaServidor implements Runnable {

    private ArrayList<Usuarios> misUsuarios;
    Scanner teclado = new Scanner(System.in);

    public HablaServidor(ArrayList<Usuarios> misUsuarios) {
        this.misUsuarios = misUsuarios;
    }
    
    @Override
    public void run(){
        String cad ="";
        while(true){
            cad=teclado.nextLine();
            if(cad.equalsIgnoreCase("quit") || cad.equalsIgnoreCase("exit") || cad==null){System.exit(-1);}
            mandarMensaje(cad);
        }
    }

    private void mandarMensaje(String cad) {
        System.out.println("[***Servidor***]>"+cad);
        for(Usuarios usu : misUsuarios){
            usu.getOUT().println("[***Servidor***]>"+cad);
        }
    }
    
}
