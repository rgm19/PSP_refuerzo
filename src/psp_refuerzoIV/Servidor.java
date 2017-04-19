/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_refuerzoIV;

import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author usuario5
 */
public class Servidor {
    public static void main(String []args){
        ArrayList<Usuarios> misUsuarios = new ArrayList<Usuarios>();
        System.out.println("+-----------------------------------------+");
        System.out.println("|-------      SERVIDOR PUBLICO     -------|");
        System.out.println("|-------           (V 1.0)         -------|");
        System.out.println("+-----------------------------------------+");
        int ncli=1;
        
        try(
            ServerSocket con = new ServerSocket(15000);    
            ){}catch(Exception ex){
            System.err.println("ERROR -> "+ex.getMessage());
        }
    }
}
