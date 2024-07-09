package ru.job4j.ood.srp;

/*
Нарушение SRP, сервис банка может предоставить
обмен валют, выдачу кредита.
Обработка пользователя не входит в эту категорию.
 */

public interface BankServices {
    String currencyExchange();
    boolean loanIssuance(int sum, String user);
    String userProcessing();
}
