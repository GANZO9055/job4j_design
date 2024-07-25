package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlQualityTest {
    @Test
    public void whenRedistributeThenFoodInCorrectStore() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));

        Food food = new Food("Milk", LocalDate.now().plusDays(30), LocalDate.now()
                .minusDays(10), 50, 0);
        controlQuality.distribute(food);

        assertTrue(shop.getAll().contains(food));
    }

    @Test
    void whenResort() {
        Food food1 = new Food("Apple", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(1), 100, 0.2);
        Food food2 = new Food("Banana", LocalDate.now().plusDays(3),
                LocalDate.now().minusDays(1), 100, 0.2);
        Food food3 = new Food("Orange", LocalDate.now().plusDays(1),
                LocalDate.now().minusDays(3), 100, 0.2);
        Food food4 = new Food("Milk", LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(10), 100, 0.2);

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        controlQuality.distribute(food1);
        controlQuality.distribute(food2);
        controlQuality.distribute(food3);
        controlQuality.distribute(food4);

        controlQuality.resort();

        List<Food> warehouseFoods = warehouse.getAll();
        List<Food> shopFoods = shop.getAll();
        List<Food> trashFoods = trash.getAll();

        assertTrue(warehouseFoods.contains(food1));
        assertTrue(shopFoods.contains(food2));
        assertTrue(shopFoods.contains(food3));
        assertTrue(trashFoods.contains(food4));
    }
}