package encryptdecrypt;

public class OptionsHandler {

    private String actionType = null;
    private String message = "";
    private Integer eNumber = null;
    private String fileNameRead = null;
    private String fileNameWrite = null;
    private String outPutOption = "terminal";
    private String alg = "shift";

    public OptionsHandler(String[] args) {
        extractArgs(args);
    }

    private void extractArgs(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    actionType = args[i + 1];
                    if (!(actionType.equalsIgnoreCase("enc") || actionType.equalsIgnoreCase("dec"))) {
                        throw new IllegalArgumentException("-mode should be enc or dec, got " + actionType);
                    }
                    break;
                case "-key":
                    eNumber = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    message = args[i + 1];
                    break;
                case "-in":
                    fileNameRead = args[i + 1];
                    break;
                case "-out":
                    fileNameWrite = args[i + 1];
                    outPutOption = "file";
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
                default:
                    if (actionType.isBlank()) {
                        actionType = "enc";
                    }
                    if (eNumber == null) {
                        eNumber = 0;
                    }
            }
        }
    }

    public String getActionType() {
        return actionType;
    }

    public String getMessage() {
        return message;
    }

    public Integer geteNumber() {
        return eNumber;
    }

    public String getFileNameRead() {
        return fileNameRead;
    }

    public String getFileNameWrite() {
        return fileNameWrite;
    }

    public String getOutPutOption() {
        return outPutOption;
    }

    public String getAlg() {
        return alg;
    }

}
