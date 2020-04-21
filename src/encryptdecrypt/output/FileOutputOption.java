package encryptdecrypt.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputOption implements OutputOption {

    private String filePath;

    public FileOutputOption(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String data) {
        File file = new File(filePath);
        System.out.println(file.getAbsolutePath());
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
