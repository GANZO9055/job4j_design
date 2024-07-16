package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Warehouse extends AbstractStore {
    @Override
    public boolean accept(Food food) {
        long totalDays = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long usedDays = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        double percentage = (double) usedDays / totalDays;
        return percentage < 0.25;
    }
}
