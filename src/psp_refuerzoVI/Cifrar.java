package psp_refuerzoVI;

public class cifrar{
	
	public static String cifrar(byte[]a){
		Base64.encoder encoder = Base64.getEncoder();
		String b = encoder.encodeToString(a);
		return b;
	}

	public static String descifrar(String a){
		Base64.decoder decode = Base64.getDecoder();
		byte [] arraydecode = decoder.decode(a);
		String b = arraydecode.toString();
		return b;
	}

	public static void main(String[]args){
		KeySpec ks;
		SecretKeyFactory skf;
		Cipher cifrar;
		SecretKey clave_priv;
        String clave="ClaveCifrado";
        String frase ="FraseQueCifraremos";

		try{
			//fase 1
			byte [] byteclaveprovisional = clave.getBytes("UTF8");

			byte [] bytesClave = copyOf(byteclaveprovisional, 24);

			ks = new DESedeKeySpec(bytesClave);

			skf = SecretKeyFactory.getInstance("DESede");

			clave_priv = skf.generateSecret(ks):

			cifrar = Cipher.getInstance("DESede");



			//fase 2
			byte[]bytesfrase = frase.getBytes("UTF8");
			cifrar.init(Ciphet.Encrypt_Mode, clave_priv);
			byte []bytesfrasecifrada = doFinal(bytesfrase);



			//fase 3
			cifrar.init(Cipher.Descrypy_MODE, clave_priv);
			byte[] bytesdescifradafrase = cifrar.doFinal(bytescifradafrase);
			
		}catch(Exception e){}
	
			       System.out.println("Frase Original: " + frase);
      			 System.out.println("Frase cifrada utilizando TripleDES (DESede)");
       System.out.println(cifrarBase64(befrase));
       System.out.println("Frase vuelta a descifrar: ");

		String frasedescifrada = cifrarBase64(bytesdescifradafrase);
		System.out.println(ddescifrarBase64(df));

		
		}
	

}
