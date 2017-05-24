/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_rezuerzoIX;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario5
 */
public class HiloServidor implements Runnable {

    private Socket conexion;

    public HiloServidor(Socket conexion) {
        this.conexion = conexion;
    }

    public HiloServidor() {
    }
    
    
    @Override
    public void run() {
        try(
                ObjectInputStream OIS = new ObjectInputStream(conexion.getInputStream());
                PrintWriter OUT = new PrintWriter(conexion.getOutputStream(), true );
            ){
        
            Object mensaje = OIS.readObject();
            if(mensaje instanceof FicheroEntrada){
                String nombre = ((FicheroEntrada) mensaje).getFichero();
                FileOutputStream FOS = new FileOutputStream(nombre);
                FicheroSalida mensajeRecibido;
                Object mensajeAux;
                
                do{
                    mensajeAux=OIS.readObject();
                    if(mensajeAux instanceof FicheroSalida){
                        mensajeRecibido = (FicheroSalida) mensajeAux;
                        FOS.write(mensajeRecibido.contenidoFichero, 0, mensajeRecibido.byteValidos);
                    }else{
                        System.err.println("Error, el mensaje NO es de la clase esperada!!!");
                        break;
                    }
                }while(!mensajeRecibido.isUltimoMensaje());
                
                FOS.close();
                File file = new File(nombre);
                Cifrar cifrado = new Cifrar(file, "");
                OUT.println(cifrado.generarTipo(false));
       
            }else{
                System.err.println("Mensaje no esperado "
                    + mensaje.getClass().getName());
            }
       
         }catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
