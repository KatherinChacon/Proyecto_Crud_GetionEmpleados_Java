/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;


import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 * @author KATHE
 */
public class Encoder {
    static Cipher cipher;
    String secretKey = "ProgramacionAvanzada";
    
    public String encrypt(String plainText)
     throws Exception{
        cipher = Cipher.getInstance("AES");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));
        byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
        SecretKey secretKey = new SecretKeySpec(BytesKey, "AES");
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;        
    }
    
    public String decrypt (String encryptedText)
     throws Exception{
        cipher = Cipher.getInstance("AES");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));
        byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
        SecretKey secretKey = new SecretKeySpec(BytesKey, "AES");
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;       
    }
}
