package psp_refuerzoII;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author usuario5
 */
public class HiloServidor implements Runnable {
    int ncli;
    Socket con;
    BufferedReader IN;
    PrintWriter OUT;
    private ArrayList<Usuarios> misUsuarios;
    private Usuarios esteUsuario;
    
    public HiloServidor(Socket c, int cli, ArrayList<Usuarios> al){
        ncli=cli;
        con=c;
        misUsuarios=al;
    }
    
    @Override
    public void run(){
        try(
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            PrintWriter out = new PrintWriter(con.getOutputStream(), true);    
            ){
        
            IN=in;
            OUT=out;
            mostrarBanner();
            generaUsuario();
            String cad="";
            while(true){
                cad=IN.readLine();
                if(cad.equalsIgnoreCase("quit") || cad==null || cad.equalsIgnoreCase("exit")){break;}
                mandarMensaje(cad);
            }
            borrarUsuario();
            
        }catch(Exception ex){
            System.err.println("Error -> "+ex.getMessage());
        }
    }

    public void mostrarBanner() {
        OUT.println("+--------------------------------+");
        OUT.println("|--------------------------------|");
        OUT.println("|---     << CLIENTE " + ncli +" >>      ---|");
        OUT.println("|--------------------------------|");
        OUT.println("+--------------------------------+");
        OUT.println("(Hay un total de : " + misUsuarios.size() + ", clientes activos.)");
    }

    public void generaUsuario() {
          esteUsuario = new Usuarios(IN,OUT,ncli);
          misUsuarios.add(esteUsuario);
          System.out.println(esteUsuario.getNombre()+" Conectado.");
    }

    public void mandarMensaje(String cad) {
        for(Usuarios usu: misUsuarios){
            if(!usu.equals(esteUsuario)){
                usu.getOUT().println("["+esteUsuario.getNombre()+"]>"+cad);
            }
        }
    }

    public void borrarUsuario() {
       misUsuarios.remove(esteUsuario);
       System.out.println(esteUsuario.getNombre()+" Desconectado.");
    }
}
