package Project_11.app;


import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    public String createFile(String path) {
        Path newFile = Path.of(path);
        try {
            Files.createFile(newFile);
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
        return "Created " + newFile;
    }

    public String writeToFile(String path, String  content) {
        Path path1 = Path.of(path);
        try {
            Files.writeString(path1, content);
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
        return "Recorded in " + path;
    }

    public String readFromFile(String path) {
        Path path2 = Path.of(path);
        try {
            return Files.readString(path2);
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
    }
}


