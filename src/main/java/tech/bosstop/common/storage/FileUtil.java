package tech.bosstop.common.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    public boolean folderExists(File file) {
        return file.exists();
    }

    public boolean folderExists(String path) {
        return new File(Paths.get(path).toString()).exists();
    }

    public boolean fileExists(File file) {
        return file.exists();
    }

    public boolean fileExists(String path) {
        return new File(Paths.get(path).toString()).exists();
    }

    public void createFolder(File file) {
        file.mkdir();
    }

    public void createFolder(String path) {
        new File(Paths.get(path).toString()).mkdir();
    }

    public String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }

    public void writeFile(String path, String content) throws IOException {
        try {
            File file = new File(Paths.get(path).toString());
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
