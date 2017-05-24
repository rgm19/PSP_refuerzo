/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_rezuerzoIX;

import java.io.File;
import java.security.spec.KeySpec;
import static java.util.Arrays.copyOf;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 *
 * @author usuario5
 */
public class Cifrar {
    private SecretKey clave;
    private File fichero;
    private String pass;
    private Cipher cifrar;
    private boolean envio;

    public Cifrar() {
    }

    public Cifrar(File fichero, String pass) {
        this.fichero = fichero;
        this.pass = pass;
    }
    
    private void inflar(){
        byte [] provisional = null;
        byte [] contra=null;
        
        KeySpec ks;
        SecretKeyFactory skf;
        
        try{
            provisional = pass.getBytes("UTF-8");
            contra = copyOf(provisional, 24);
            ks = new DESedeKeySpec(contra);
            skf = SecretKeyFactory.getInstance("DESede");
            clave = skf.generateSecret(ks);
            cifrar = Cipher.getInstance("DESede");     
        }catch(Exception e){
            System.err.println("Error -> "+e.getMessage());
        }
    }
    
    public File cifrado(boolean b){
      File archivo =null;
      int lectura =0;
      byte[]bfrase =new byte [1024];

      if(b==true){
          archivo = new File(fichero.getPath()+".des");
      }else{
          String des = fichero.getPath();
          des = des.substring(0, des.length() -4);
          archivo = new File(des);
      }
      
      //Continuar desde aqui
      
      
    return archivo;
    }
}
