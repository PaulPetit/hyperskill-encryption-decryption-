package encryptdecrypt.algorithm;

public class UnicodeAlgorithm implements Algorithm {

    @Override
    public String encrypt(String messageToEncrypt, int key) {
        char[] arrayChar = messageToEncrypt.toCharArray();

        for (int i = 0; i < arrayChar.length; i++) {
            arrayChar[i] = (char) (arrayChar[i] + key);
        }

        return new String(arrayChar);

    }

    @Override
    public String decrypt(String messageToDecrypt, int key) {
        char[] arrayChar = messageToDecrypt.toCharArray();

        for (int i = 0; i < arrayChar.length; i++) {
            arrayChar[i] = (char) (arrayChar[i] - key);
        }

        return new String(arrayChar);
    }

    AlgorithmMode mode;

    public UnicodeAlgorithm(AlgorithmMode mode) {
        this.mode = mode;
    }

    @Override
    public String execute(String message, int key) {
        switch (mode) {
            case ENCRYPTION:
                return encrypt(message, key);
            case DECRYPTION:
                return decrypt(message, key);
            default:
                throw new IllegalStateException("Unexpected value: " + mode);
        }
    }
}
