package encryptdecrypt;

import encryptdecrypt.algorithm.AlgorithmMode;
import encryptdecrypt.algorithm.AlgorithmSelection;
import encryptdecrypt.algorithm.ShiftAlgorithm;
import encryptdecrypt.algorithm.UnicodeAlgorithm;
import encryptdecrypt.input.ArgsInputOption;
import encryptdecrypt.input.FileInputOption;
import encryptdecrypt.input.InputOption;
import encryptdecrypt.output.FileOutputOption;
import encryptdecrypt.output.OutputOption;
import encryptdecrypt.output.TerminalOutputOption;

public class EncryptionDecryption {
    private OptionsHandler options;
    private InputOption inputOption;
    private AlgorithmSelection algorithmSelection;
    private OutputOption outputSelection;
    private String data;

    public EncryptionDecryption(OptionsHandler optionsHandler) {
        this.options = optionsHandler;
    }

    public void execute() {
        getInput();
        selectAlgorithm();
        executeAlgorithm();
        selectOutput();
        outputData();
    }

    private void selectOutput() {
        if (options.getOutPutOption().equals("file")) {
            outputSelection = new FileOutputOption(options.getFileNameWrite());
        } else {
            outputSelection = new TerminalOutputOption();
        }
    }

    private void outputData() {
        outputSelection.write(data);
    }

    private void executeAlgorithm() {
        data = algorithmSelection.execute(inputOption.load(), options.geteNumber());
    }

    private void selectAlgorithm() {
        algorithmSelection = new AlgorithmSelection();

        switch (options.getActionType()) {
            case "enc":
                switch (options.getAlg()) {
                    case "shift":
                        algorithmSelection.setAlgorithm(new ShiftAlgorithm(AlgorithmMode.ENCRYPTION));
                        break;
                    case "unicode":
                        algorithmSelection.setAlgorithm(new UnicodeAlgorithm(AlgorithmMode.ENCRYPTION));
                        break;
                }

                break;
            case "dec":
                switch (options.getAlg()) {
                    case "shift":
                        algorithmSelection.setAlgorithm(new ShiftAlgorithm(AlgorithmMode.DECRYPTION));
                        break;
                    case "unicode":
                        algorithmSelection.setAlgorithm(new UnicodeAlgorithm(AlgorithmMode.DECRYPTION));
                        break;
                }
                break;
            default:
                System.out.println("Incorrect type");
        }
    }

    private void getInput() {
        if (options.getFileNameRead() != null) {
            inputOption = new FileInputOption(options.getFileNameRead());
        } else {
            inputOption = new ArgsInputOption(options.getMessage());
        }
    }
}
