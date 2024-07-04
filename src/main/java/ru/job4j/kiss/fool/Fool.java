package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        startGame();
    }

    public static void startGame() {
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(getFizzBuzz(startAt));
            startAt++;
            var answer = input.nextLine();
            if (!validation(startAt, answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    public static String getFizzBuzz(int startAt) {
        StringBuilder string = new StringBuilder();
        if (startAt % 3 == 0 && startAt % 5 == 0) {
            string.append("FizzBuzz");
        } else if (startAt % 3 == 0) {
            string.append("Fizz");
        } else if (startAt % 5 == 0) {
            string.append("Buzz");
        } else {
            string.append(startAt);
        }
        return string.toString();
    }

    public static boolean validation(int startAt, String answer) {
        return getFizzBuzz(startAt).equals(answer);
    }
}
