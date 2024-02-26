package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private static void validationArguments(String[] values) {
        if (values.length != 3) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        for (int i = 0; i < 3; i++) {
            String[] value = values[i].split("=", 2);
            if (i == 0 && !Paths.get(value[1]).toFile().isDirectory()) {
                throw new IllegalArgumentException(
                        String.format("Not directory %s", Paths.get(value[1]).toFile()
                                .getAbsoluteFile()));
            }
            if (i == 1 && (value[1].length() < 3 || !value[1].startsWith("."))) {
                throw new IllegalArgumentException(String.format("Not exist %s", value[1]));
            }
            if (i == 2 && !value[1].endsWith(".zip")) {
                throw new IllegalArgumentException(
                        String.format(
                                "Incorrect file extension format %s, must be .zip", value[1]
                        )
                );
            }
        }
    }

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toString()));
                try (BufferedInputStream output = new BufferedInputStream(
                        new FileInputStream(source.toFile()))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        validationArguments(args);
        ArgsName argsName = ArgsName.of(args);

        String directoryPath = argsName.get("d");
        String exclude = argsName.get("e");
        String output = argsName.get("o");

        File directoryOne = new File(directoryPath);

        List<Path> filesToArchive = Search.search(
                directoryOne.toPath(), path -> !path.toFile().getName().endsWith(exclude));

        Zip zip = new Zip();
        zip.packFiles(filesToArchive, new File(output));
    }
}
