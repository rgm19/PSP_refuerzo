/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_refuerzoIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author usuario5
 */
public class HiloServidor implements Runnable{
    Socket con;
    ArrayList<Usuarios> misUsuarios;
    private Usuarios usuario;
    int ncli;
    BufferedReader IN;
    PrintWriter OUT;

    public HiloServidor(Socket con, ArrayList<Usuarios> misUsuarios, int ncli) {
        this.con = con;
        this.misUsuarios = misUsuarios;
        this.ncli = ncli;
    }
    
    @Override
    public void run(){
    
        try(
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            PrintWriter out = new PrintWriter(con.getOutputStream());    
            ){
        
            IN=in;
            OUT=out;
            mostrarBanner();
            generarUsuario();
            String cad="";
            while(true){
                cad=IN.readLine();
                if(cad.equalsIgnoreCase("quit") || cad.equalsIgnoreCase("exit")) break;
                mandarMensaje(cad);
            }
            
            borrarUsuario();
            
            
            
        }catch(Exception e){
            System.err.println("Errpr -> "+e.getMessage());
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

    private void generarUsuario() {
        usuario = new Usuarios (IN, OUT, ncli);
        misUsuarios.add(usuario);
        System.out.println("Conectado -> "+usuario.getNombre());
    }

    private void mandarMensaje(String cad) {
        for(Usuarios aux : misUsuarios){
            if(!aux.equals(usuario)){
                aux.getOUT().println("["+usuario.getNombre()+"]>"+cad);
            }
        }
    }

    private void borrarUsuario(){
        misUsuarios.remove(usuario);
        System.out.println(usuario.getNombre()+" Desconectado.");
    }
    
}
