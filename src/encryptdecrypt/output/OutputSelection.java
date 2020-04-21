package encryptdecrypt.output;

public class OutputSelection {

    private OutputOption outputOption;

    public void setOutputOption(OutputOption outputOption) {
        this.outputOption = outputOption;
    }

    public void write(String data) {
        this.outputOption.write(data);
    }
}
