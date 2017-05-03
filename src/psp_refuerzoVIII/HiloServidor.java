/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_refuerzoVIII;

import java.io.File;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author usuario5
 */
public class HiloServidor implements Runnable {
    Socket con;
    File fichero;
    
    public HiloServidor(Socket s){
        con=s;
    }
    
    @Override
    public void run(){
        try(
            ObjectInputStream ois = new ObjectInputStream(con.getInputStream());    
            ){
            
            //llega el nombre del archivo
            Object mensaje = ois.readObject();
            /*
            if(mensaje instanceof aux.FicheroEntrada){
                String nombre = ((aux.FicheroEntrada) mensaje.getNombre_fichero())
            }
            */
        }catch(Exception e){}
    }
    
}
