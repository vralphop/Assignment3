/*

 * Class: CMSC203 20984

 * Instructor: Ahmed Tarek

 * Description: A program to encrypt and decrypt a phrase using two similar approaches.

 * Due: 10/09/2023

 * Platform/compiler: Eclipse

 * I pledge that I have completed the programming 

 * assignment independently. I have not copied the code 

 * from a student or any source. I have not given my code 

 * to any student.

   Print your Name here: ____Valerie Ralph-Opara______

*/
package Cryptography;


public class CryptoManager {

private static final char LOWER_RANGE = ' ';

private static final char UPPER_RANGE = '_';

private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;



public static boolean isStringInBounds(String plainText) {

for (char c : plainText.toCharArray()) {

if (c < LOWER_RANGE || c > UPPER_RANGE) {

return false;

}

}

return true;

}



public static String caesarEncryption(String plainText, int key) {

StringBuilder encryptedText = new StringBuilder();

for (char c : plainText.toCharArray()) {

int encryptedChar = c + key;

if (encryptedChar > UPPER_RANGE) {

encryptedChar -= RANGE;

}

encryptedText.append((char) encryptedChar);

}

return encryptedText.toString();

}



public static String caesarDecryption(String encryptedText, int key) {

StringBuilder decryptedText = new StringBuilder();

for (char c : encryptedText.toCharArray()) {

int decryptedChar = c - key;

if (decryptedChar < LOWER_RANGE) {

decryptedChar += RANGE;

}

decryptedText.append((char) decryptedChar);

}

return decryptedText.toString();

}



public static String bellasoEncryption(String plainText, String bellasoStr) {

StringBuilder encryptedText = new StringBuilder();

int bellasoLength = bellasoStr.length();

for (int i = 0; i < plainText.length(); i++) {

char plainChar = plainText.charAt(i);

char bellasoChar = bellasoStr.charAt(i % bellasoLength);

int encryptedChar = plainChar + bellasoChar;

if (encryptedChar > UPPER_RANGE) {

encryptedChar -= RANGE;

}

encryptedText.append((char) encryptedChar);

}

return encryptedText.toString();

}



public static String bellasoDecryption(String encryptedText, String bellasoStr) {

StringBuilder decryptedText = new StringBuilder();

int bellasoLength = bellasoStr.length();

for (int i = 0; i < encryptedText.length(); i++) {

char encryptedChar = encryptedText.charAt(i);

char bellasoChar = bellasoStr.charAt(i % bellasoLength);

int decryptedChar = encryptedChar - bellasoChar;

if (decryptedChar < LOWER_RANGE) {

decryptedChar += RANGE;

}

decryptedText.append((char) decryptedChar);

}

return decryptedText.toString();

}




}