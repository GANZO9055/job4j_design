package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Shop extends AbstractStore {
    @Override
    public boolean accept(Food food) {
        long totalDays = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long usedDays = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        double percentage = (double) usedDays / totalDays;
        return percentage >= 0.25 && percentage <= 1.0;
    }

    @Override
    public void add(Food food) {
        long totalDays = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long usedDays = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        double percentage = (double) usedDays / totalDays;
        if (percentage >= 0.75) {
            food.setPrice(food.getPrice() * (1 - food.getDiscount()));
        }
        super.add(food);
    }
}
