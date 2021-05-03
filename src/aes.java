//package cifrado;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class aes {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException 
    {
         System.out.println("Ingresa el texto a codificar...");
    }
    
    public static Cifrados ReturnCifrado(String cadenaEntrada) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException 
    {
    	
    	Cifrados value = new Cifrados(); //Se inicializa la clase cifrados, que tiene los campos del jFrame
    	
    	value.Base64 = Base64.getEncoder().encodeToString(cadenaEntrada.getBytes()); //convierte la cadena original en bytes
    																				//despues la convierte en base 64 y la almacena en value.Base64
    	
    	value.Base64toAES = value.Base64; //Se pasa el valor de base 64 de value.Base64 a value.Base64toAES
    	
		String algorithm = "AES";
	    Cipher cipher = Cipher.getInstance(algorithm); //Se inicializa la clase Cipher, que provee metodos de encriptación y desencriptación.
	    												//Se pasa el valor "AES", para indicar que se usara ese estandar
	            
	    KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm); //Se inicializa la clase que genera llaves, se
	    																//generará con el algoritmo AES, pasado como atributo.
	    
	    keyGenerator.init(256); //Se inicializa la llave con una longitud de 256 bits
	    
	    SecretKey secretKey = keyGenerator.generateKey(); //Se genera y se guarda una llave en la variable secretKey
        cipher.init(Cipher.ENCRYPT_MODE, secretKey); //Se inicializa la variable cipher para ENCRIPTAR con la llave generada
        byte[] TextoEncriptado = cipher.doFinal(value.Base64toAES.getBytes()); //Se genera una cadena de bytes al encriptar la cadena base 64.

        cipher.init(Cipher.DECRYPT_MODE, secretKey); //Se inicializa la variable cipher para DESENCRIPTAR con la llave generada
        byte[] TextoDesencriptado = cipher.doFinal(TextoEncriptado); //Se genera una cadena de bytes al desencriptar la cadena de bytes AES

        value.AES = javax.xml.bind.DatatypeConverter.printBase64Binary(TextoEncriptado); //Se convierte la cadena de bytes AES a String, se guarda en 
        																				//la variable value.AES
        value.DescAES = new String(TextoDesencriptado); //Se convierte la cadena de bytes desencripatada AES a String, se guarda en
        												//la variable valueDescAES
        
        byte[] BytesDescodificados = Base64.getDecoder().decode(TextoDesencriptado); //Se descodifica la cadena de bytes Base 64
        String StringDescodificado = new String(BytesDescodificados); //Se convierte a string la cadena de bytes anterior
        value.DecodBase64 = StringDescodificado; //Se almacena en la variable value.DecodBase 64
        
        return value; //Se retorna el valor
        
    }
}