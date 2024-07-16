package ru.job4j.ood.lsp.store;

import java.time.LocalDate;

public class Trash extends AbstractStore {
    @Override
    public boolean accept(Food food) {
        return LocalDate.now().isAfter(food.getExpiryDate());
    }
}
