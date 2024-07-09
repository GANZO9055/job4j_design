package ru.job4j.ood.srp;

import java.util.List;

/*
Нарушение принципа SRP,
т.к. имеется разный функционал,
генерация числа (generatedNumber),
добавление числа (addNumber),
вывод чисел на консоль(printNumber)
 */
public interface GeneratedNumber {
    Integer generatedNumber();
    List<Integer> addNumber(Integer number);
    void printNumber();
}
