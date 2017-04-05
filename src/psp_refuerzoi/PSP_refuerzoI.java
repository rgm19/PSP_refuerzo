package psp_refuerzoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author usuario5
 */
public class PSP_refuerzoI {

    static int puerto =15000,  MAX=10;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int ncli=1;
        System.out.println("Servidor escuchando...");
        
        try(
                ServerSocket serv = new ServerSocket(puerto, MAX);
                 
            ){
        
            while(true){
                HiloServidor hm = new HiloServidor(serv.accept(), ncli);
                Thread hilo = new Thread(hm);
                hilo.setName("Conexion cliente: "+ncli);
                hilo.start();
                ncli++;
                
            }
        }catch(Exception e){}
    }
   
    
}
