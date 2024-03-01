package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private List<String> saveLogChat;
    private boolean status;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        this.saveLogChat = new ArrayList<>();
        this.status = true;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<String> phrasesBot = readPhrases();
        boolean bot = true;
        while (status) {
            String inputUser = scanner.nextLine();
            int index = random.nextInt(phrasesBot.size());
            saveLogChat.add(inputUser);
            if (STOP.equals(inputUser)) {
                bot = false;
                System.out.println("Вы остановили бота, бот не отвечает.");
                continue;
            }
            if (CONTINUE.equals(inputUser)) {
                bot = true;
                System.out.println("Вы возобновили бота, бот отвечает.");
                continue;
            }
            if (OUT.equals(inputUser)) {
                status = false;
                System.out.println("Вы завершили бота, бот отключен");
                break;
            }
            if (bot) {
                saveLogChat.add(phrasesBot.get(index));
                System.out.println(phrasesBot.get(index));
            }
        }
        saveLog(saveLogChat);
    }

    private List<String> readPhrases() {
        List<String> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(
                new FileReader("data/txt/botAnswer", StandardCharsets.UTF_8))) {
            read.lines().forEach(result::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog(List<String> log) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("data/txt/chatLog", StandardCharsets.UTF_8))) {
            for (String line : log) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/txt/chatLog",
                "data/txt/botAnswer");
        consoleChat.run();
    }
}
