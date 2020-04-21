package encryptdecrypt.output;

public class TerminalOutputOption implements OutputOption {

    @Override
    public void write(String data) {
        System.out.println(data);
    }
}
