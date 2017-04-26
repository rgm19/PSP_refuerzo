/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_refuerzoVI;

import java.security.spec.KeySpec;
import static java.util.Arrays.copyOf;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 *
 * @author usuario5
 */
public class CifradoBase46 {
    //para cifrar
    public static String cifrarBase64(byte [] a){
        Base64.Encoder encoder = Base64.getEncoder();
        String b = encoder.encodeToString(a);
        return b;
    }
    //para descifrar
    public static String descifrarBase64(String a){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(a);
        String b = decodedByteArray.toString();
        return b;
    }
    
    public static void main(String[]args){
        String clave="ClaveCifrado";
        String frase ="FraseQueCifraremos";
        byte[] bclaveprov=null; //clave en bytes provisional
        byte[] bclave=null; //clave en 24bytes
        byte[] bfrase=null; //frase a cifrar en bytes
        byte[]befrase=null; //frase cifrada en bytes
        byte[]bpfrase=null; //frase descifrada en bytes
        KeySpec ks; //guarda la clave en bytes para usarla
        SecretKeyFactory skf; //crea la instancia para cifrar en DESede
        Cipher cifrar; //objeto usado para cifrar
        SecretKey clave_priv; //clave de cifrado de CIPHER
        
        try{
            //guardamos la clave en bytes de forma provisional
            bclaveprov=clave.getBytes("UTF8");
            //creamos la clave en bytes ajustandola a 24bytes
            bclave=copyOf(bclaveprov,24);
            //creamos la clave DESede
            ks= new DESedeKeySpec(bclave);
            //guardamos la clave DESede
            skf = SecretKeyFactory.getInstance("DESede");
            //Generamos la clave privada del cipher
            clave_priv=skf.generateSecret(ks);
            //lo iniciamos para cifrar en DESede
            cifrar=Cipher.getInstance("DESede");
            
            
            //Pasamos la frase a array de bytes
            bfrase=frase.getBytes("UTF8");
            //Iniciamos el modo cifrando
            cifrar.init(Cipher.ENCRYPT_MODE, clave_priv);
            //ciframos y guardamos lo cifrado en array de bytes
            befrase = cifrar.doFinal(bfrase);
            
            //Iniciamos el modo descifrar
            cifrar.init(Cipher.DECRYPT_MODE, clave_priv);
            //desciframos y lo guardamos en array de bytes
            bpfrase = cifrar.doFinal(befrase);
            
            
            
        }catch(Exception e){
            System.err.println("Error -> "+e.getMessage());
        }
        
       System.out.println("Frase Original: " + frase);
       System.out.println("Frase cifrada utilizando TripleDES (DESede)");
       System.out.println(cifrarBase64(befrase));
       System.out.println("Frase vuelta a descifrar: ");
       //Pasamos el array descifrado a base64 y lo decodificamos
       String df = cifrarBase64(bpfrase);
       System.out.println(descifrarBase64(df));
    }
    
}
