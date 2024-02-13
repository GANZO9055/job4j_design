package ru.job4j.io;

import java.io.*;

public class Analysis {
    public static void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(target)) {
            String line;
            String dateStart = null;
            String dateFinish = null;
            while ((line = read.readLine()) != null) {
                String[] strings = line.split(" ", 2);
                if (("400".equals(strings[0]) || "500".equals(strings[0]))
                        && dateStart == null) {
                    dateStart = strings[strings.length - 1];
                }
                if (("200".equals(strings[0]) || "300".equals(strings[0]))
                        && dateStart != null) {
                    dateFinish = strings[strings.length - 1];
                }
                if (dateStart != null && dateFinish != null) {
                    writer.printf("%s;%s;\n", dateStart, dateFinish);
                    dateStart = null;
                    dateFinish = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
