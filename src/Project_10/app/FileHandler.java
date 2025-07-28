package Project_10.app;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private final static String BASE_PATH = "Files/";

    public String writeFile(String fileContent, String fileName) {
        try(FileWriter fw = new FileWriter(BASE_PATH + fileName + ".txt")) {
            fw.write(fileContent);
            return "Success.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String readFile(String fileName) {
        try (FileReader reader = new FileReader(BASE_PATH + fileName + ".txt")) {
            int sym;
           StringBuilder stringBuilder = new StringBuilder();
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);
            }
            return stringBuilder.toString();
        } catch (IOException ex) {
            return "Error: " + ex.getMessage();
        }
    }
}
