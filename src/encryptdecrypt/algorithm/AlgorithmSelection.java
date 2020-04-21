package encryptdecrypt.algorithm;

public class AlgorithmSelection {

    private Algorithm algorithm;

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String execute(String message, int key) {
        return this.algorithm.execute(message, key);
    }

}
