package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.io.IOException;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.*;

class AnalysisTest {

    @Test
    void testOne(@TempDir Path pathDir) throws IOException {
        File source = pathDir.resolve("server.log").toFile();
        try (PrintWriter output = new PrintWriter(source)) {
            output.println("""
                    200 10:56:01
                    500 10:57:01
                    400 10:58:01
                    500 10:59:01
                    400 11:01:02
                    300 11:02:02
                    300 11:05:02
                    300 11:28:02
                    400 11:34:02
                    500 12:02:02
                    500 13:02:02
                    500 14:02:02
                    400 15:02:02
                    400 16:02:02
                    200 17:02:02
                    """);
        }
        File target = pathDir.resolve("target.csv").toFile();
        Analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder result = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(result::append);
        }
        assertThat("10:57:01;11:02:02;11:34:02;17:02:02;").hasToString(result.toString());
    }
}