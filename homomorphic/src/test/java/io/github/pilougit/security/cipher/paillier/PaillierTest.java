package io.github.pilougit.security.cipher.paillier;

import org.junit.jupiter.api.Test;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaillierTest {
    @Test
    public void testProvider() throws NoSuchAlgorithmException {
        Security.addProvider(new PaillierProvider());
        assertDoesNotThrow(() ->
                KeyPairGenerator.getInstance("Paillier"));


    }
    @Test
    public void testKeyGeneration() throws NoSuchAlgorithmException {
        Security.addProvider(new PaillierProvider());
        KeyPairGenerator generator=assertDoesNotThrow(() ->
                KeyPairGenerator.getInstance("Paillier"));
        assertNotNull(generator.generateKeyPair());



    }
}
