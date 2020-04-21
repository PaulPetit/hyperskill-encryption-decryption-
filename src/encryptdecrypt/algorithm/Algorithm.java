package encryptdecrypt.algorithm;

public interface Algorithm {
    String execute(String message, int key);

    String encrypt(String messageToEncrypt, int key);

    String decrypt(String messageToDecrypt, int key);
}
