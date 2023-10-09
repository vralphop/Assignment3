package Cryptography;

import static org.junit.Assert.*;
import org.junit.Test;

public class CryptoManagerPublicTest {

    @Test
    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("HELLO"));
        assertTrue(CryptoManager.isStringInBounds("CRYPTO"));
        assertFalse(CryptoManager.isStringInBounds("Test123")); 
        assertFalse(CryptoManager.isStringInBounds("Test@123")); 
        assertFalse(CryptoManager.isStringInBounds("{ IS OUTSIDE THE RANGE")); 
    }

    @Test
    public void testCaesarEncryption() {
        assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));
        assertEquals("SCYZI", CryptoManager.caesarEncryption("CRYPTO", 10));
        assertEquals("67890", CryptoManager.caesarEncryption("12345", 5));
        assertEquals("Invalid", CryptoManager.caesarEncryption("Test@123", 4)); 
        assertEquals("Invalid", CryptoManager.caesarEncryption("{", 1)); 
    }

    @Test
    public void testCaesarDecryption() {
        assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3));
        assertEquals("CRYPTO", CryptoManager.caesarDecryption("SCYZI", 10));
        assertEquals("12345", CryptoManager.caesarDecryption("67890", 5));
        assertEquals("Invalid", CryptoManager.caesarDecryption("Test@123", 4)); 
        assertEquals("Invalid", CryptoManager.caesarDecryption("{", 1)); 
    }

    @Test
    public void testBellasoEncryption() {
        assertEquals("LNVVR", CryptoManager.bellasoEncryption("HELLO", "WORLD"));
        assertEquals("WQ^GZ", CryptoManager.bellasoEncryption("HELLO", "KEY"));
        assertEquals("Invalid", CryptoManager.bellasoEncryption("12345", "5")); 
        assertEquals("Invalid", CryptoManager.bellasoEncryption("Test@123", "InvalidKey"));
    }

    @Test
    public void testBellasoDecryption() {
        assertEquals("HELLO", CryptoManager.bellasoDecryption("LNVVR", "WORLD"));
        assertEquals("HELLO", CryptoManager.bellasoDecryption("WQ^GZ", "KEY"));
        assertEquals("Invalid", CryptoManager.bellasoDecryption("12345", "5"));
        assertEquals("Invalid", CryptoManager.bellasoDecryption("Test@123", "InvalidKey"));
    }
}
