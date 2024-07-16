package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> getAll() {
        return foods;
    }
}
