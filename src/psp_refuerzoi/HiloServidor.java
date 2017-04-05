/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_refuerzoi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author usuario5
 */
public class HiloServidor implements Runnable {
    
    private Socket micon;
    private int id_cli;
    private BufferedReader IN;
    private PrintWriter OUT;

    public HiloServidor(Socket micon, int id_cli) {
        this.micon = micon;
        this.id_cli = id_cli;
    }
    
    @Override
    public void run(){
        String cad="";
        try(
                BufferedReader IN = new BufferedReader(new InputStreamReader(micon.getInputStream()));
                PrintWriter OUT = new PrintWriter(micon.getOutputStream(),true );
                ){
        
                OUT.println("Conectado al servidor, id_cli: "+id_cli+", \"quit\" o \"exit\" para salir");
                while(true){
                    cad=IN.readLine();
                    OUT.println();
                    System.out.println("Cli["+id_cli+"]: "+ cad);
                    if(cad.trim().equalsIgnoreCase("quit") || cad.trim().equalsIgnoreCase("exit") || cad==null) break;
                    
                }
                
        
            }catch(Exception e){}
    }
    
   
}
