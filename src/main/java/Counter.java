import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Counter {
    public static void main(String[] args) throws IOException {
        int cn = count("/Users/stanislavserbakov/Desktop/java_lab3/src/main/java");
        System.out.printf("%nPackage contains %d lines%n", cn);
    }
    public static int countFileLines(String absPath) throws IOException {
        Path path = Paths.get(absPath);
        List<String> lines = Files.readAllLines(path);
        System.out.printf("File[%s] contains %d lines%n", absPath, lines.size());
        return lines.size();
    }
    public static int count(String filePath) throws IOException {
        File startFile = new File(filePath);
        if (!startFile.isDirectory()){
            return countFileLines(startFile.getAbsolutePath());
        }
        int countAll = 0;
        for (File file : Objects.requireNonNull(startFile.listFiles())){
            if (file.isDirectory()) countAll += count(file.getAbsolutePath());
            else countAll += countFileLines(file.getAbsolutePath());
        }
        return countAll;
    }
}
