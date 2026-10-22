package parking.refactored;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private final String fileName;

    public FileLogger(String fileName) { this.fileName = fileName; }

    @Override
    public void log(String line) {
        try (FileWriter fw = new FileWriter(fileName, true)) {   // append
            fw.write(line + System.lineSeparator());
        } catch (IOException e) {
           //handle the error here
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
