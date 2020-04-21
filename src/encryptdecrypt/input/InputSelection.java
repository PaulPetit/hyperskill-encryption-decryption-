package encryptdecrypt.input;

public class InputSelection {

    private InputOption inputOption;

    public void setInputOption(InputOption inputOption) {
        this.inputOption = inputOption;
    }

    public String getInputData() {
        return inputOption.load();
    }

}
