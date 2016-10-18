package com.epam.bigdata2016.files;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LogReader {

    private String directory;

    public LogReader(String directory) {
        this.directory = directory;
    }

    public void forEachLine(Consumer<String> func) {
        try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
            paths.filter(Files::isRegularFile)
                 .forEach(filePath -> processFile(filePath, func));
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    private void processFile(Path filePath, Consumer<String> func) {
        try (Stream<String> lines = Files.lines(filePath, Charset.forName("ISO-8859-1"))) {
            lines.forEach(func);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
