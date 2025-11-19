package com.dcscc.connector.client.common.utils;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final int IV_LENGTH = 12;  // Recommended IV length for GCM
    private static final int TAG_LENGTH = 128; // Authentication tag length
    private static final SecureRandom secureRandom = new SecureRandom();

    // Generate random IV (Base64 encoded)
    public static String generateIV() {
        byte[] iv = new byte[IV_LENGTH];
        secureRandom.nextBytes(iv);
        return Base64.getEncoder().encodeToString(iv);
    }

    // GCM mode encryption
    public static String encryptGCM(String plaintext, String base64Key, String base64IV) {
        try {
            SecretKey key = new SecretKeySpec(Base64.getDecoder().decode(base64Key), ALGORITHM);
            byte[] iv = Base64.getDecoder().decode(base64IV);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "SunJCE");
            GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH, iv);
            cipher.init(Cipher.ENCRYPT_MODE, key, spec);

            byte[] ciphertext = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(ciphertext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // GCM mode decryption
    public static String decryptGCM(String base64Ciphertext, String base64Key, String base64IV) {
        try {
            SecretKey key = new SecretKeySpec(Base64.getDecoder().decode(base64Key), ALGORITHM);
            byte[] iv = Base64.getDecoder().decode(base64IV);
            byte[] ciphertext = Base64.getDecoder().decode(base64Ciphertext);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "SunJCE");
            GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH, iv);
            cipher.init(Cipher.DECRYPT_MODE, key, spec);

            return new String(cipher.doFinal(ciphertext), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}