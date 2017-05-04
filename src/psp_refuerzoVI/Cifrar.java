package psp_refuerzoVI;

import java.security.spec.KeySpec;
import static java.util.Arrays.copyOf;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class Cifrar{
	
	public static String cifrar(byte[]a){
		Base64.Encoder encoder = Base64.getEncoder();
		String b = encoder.encodeToString(a);
		return b;
	}

	public static String descifrar(String a){
		Base64.Decoder decode = Base64.getDecoder();
		byte [] arraydecode = decode.decode(a);
		String b = new String(arraydecode);
		return b;
	}

	public static void main(String[]args){
		KeySpec ks;
		SecretKeyFactory skf;
		Cipher cifrar;
		SecretKey clave_priv;
                String clave="ClaveCifrado";
                String frase ="ruben";
                byte []bytesfrasecifrada=null;
                byte[] bytesdescifradafrase=null;

		try{
			//fase 1
			byte [] byteclaveprovisional = clave.getBytes("UTF8");

			byte [] bytesClave = copyOf(byteclaveprovisional, 24);

			ks = new DESedeKeySpec(bytesClave);

			skf = SecretKeyFactory.getInstance("DESede");

			clave_priv = skf.generateSecret(ks);

			cifrar = Cipher.getInstance("DESede");



			//fase 2
			byte[]bytesfrase = frase.getBytes("UTF8");
			cifrar.init(Cipher.ENCRYPT_MODE, clave_priv);
			bytesfrasecifrada = cifrar.doFinal(bytesfrase);



			//fase 3
			cifrar.init(Cipher.DECRYPT_MODE, clave_priv);
			bytesdescifradafrase = cifrar.doFinal(bytesfrasecifrada);
			
		}catch(Exception e){}
	
			       System.out.println("Frase Original: " + frase);
      			 System.out.println("Frase cifrada utilizando TripleDES (DESede)");
       System.out.println(cifrar(bytesfrasecifrada));
       System.out.println("Frase vuelta a descifrar: ");

		String df = cifrar(bytesdescifradafrase);
		System.out.println(descifrar(df));

		
		}
	

}
