package encryptdecrypt.algorithm;

public class ShiftAlgorithm implements Algorithm {

    AlgorithmMode mode;

    public ShiftAlgorithm(AlgorithmMode mode) {
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

    @Override
    public String encrypt(String messageToEncrypt, int key) {

        StringBuilder builder = new StringBuilder();

        for (char letter : messageToEncrypt.toCharArray()) {

            if (Character.isAlphabetic(letter) && Character.isUpperCase(letter)) {
                builder.append((char) ((letter + key - 'A') % 26 + 'A'));
            } else if (Character.isAlphabetic(letter) && Character.isLowerCase(letter)) {
                builder.append((char) ((letter + key - 'a') % 26 + 'a'));
            } else {
                builder.append(letter);
            }
        }

        return builder.toString();
    }

    @Override
    public String decrypt(String messageToDecrypt, int key) {

        StringBuilder builder = new StringBuilder();

        for (char letter : messageToDecrypt.toCharArray()) {

            if (Character.isAlphabetic(letter) && Character.isUpperCase(letter)) {
                builder.append((char) ((letter + 26 - key - 'A') % 26 + 'A'));
            } else if (Character.isAlphabetic(letter) && Character.isLowerCase(letter)) {
                builder.append((char) ((letter + 26 - key - 'a') % 26 + 'a'));
            } else {
                builder.append(letter);
            }
        }

        return builder.toString();
    }
}
