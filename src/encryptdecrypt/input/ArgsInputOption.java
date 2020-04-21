package encryptdecrypt.input;

public class ArgsInputOption implements InputOption {

    private String argData;

    public ArgsInputOption(String argData) {
        this.argData = argData;
    }

    @Override
    public String load() {
        return argData;
    }
}
