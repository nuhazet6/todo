package org.nuhaempresario.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class HashGenerator {
    SecureRandom random;
    byte[] salt;
    MessageDigest messageDigest;
    byte[] hashedPassword;

    public HashGenerator() {
        random = new SecureRandom();
        salt = new byte[16];
        random.nextBytes(salt);
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(salt);
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public String generate(String password){
        hashedPassword = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        return messageDigest.toString();
    }

    public SecureRandom getRandom() {
        return random;
    }

    public byte[] getSalt() {
        return salt;
    }

    public MessageDigest getMessageDigest() {
        return messageDigest;
    }

    public byte[] getHashedPassword() {
        return hashedPassword;
    }
}
