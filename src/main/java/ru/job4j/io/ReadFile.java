package ru.job4j.io;

import java.io.FileInputStream;

public class ReadFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("data/txt/input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = input.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
