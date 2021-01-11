package com.example.user.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class PasswordEncoder {

    private static PasswordEncoder passwordEncoder;

    private PasswordEncoder() {

    }

    public static PasswordEncoder getInstance() {
        if (passwordEncoder == null) {
            passwordEncoder = new PasswordEncoder();
        }
        return passwordEncoder;
    }

    public String encodePassword(String password) {
        try {
            int iterations = 1000;
            char[] chars = password.toCharArray();
            byte[] salt = getSalt();

            PBEKeySpec pbeKeySpec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();
            return iterations + ":" + toHex(salt) + ":" + toHex(hash);
        } catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException("There was a problem encoding the password");
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("There was a problem encoding the password");
        }
    }

    private byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }

    private String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bigInteger = new BigInteger(1, array);
        String hex = bigInteger.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    public boolean decodePassword(String originalPassword, String storedPassword) {
        try {
            String[] parts = storedPassword.split(":");
            int iterations = Integer.parseInt(parts[0]);
            byte[] salt = fromHex(parts[1]);
            byte[] hash = fromHex(parts[2]);

            PBEKeySpec pbeKeySpec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] testHash = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();

            int diff = hash.length ^ testHash.length;
            for (int i = 0; i < hash.length && i < testHash.length; i++) {
                diff |= hash[i] ^ testHash[i];
            }
            return diff == 0;
        } catch (InvalidKeySpecException ex) {
            throw new RuntimeException("There was a problem decoding the password");
        } catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException("There was a problem decoding the password");
        }
    }

    private byte[] fromHex(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
