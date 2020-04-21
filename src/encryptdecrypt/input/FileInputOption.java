package encryptdecrypt.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInputOption implements InputOption {

    private String filePath;

    public FileInputOption(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String load() {

        StringBuilder fileContent = new StringBuilder();
        File file = new File(filePath);
        System.out.println(file.getAbsolutePath());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                fileContent.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileContent.toString();
    }
}
