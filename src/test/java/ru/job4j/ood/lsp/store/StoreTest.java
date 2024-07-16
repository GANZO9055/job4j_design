package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    @Test
    public void testWarehouseAccept() {
        Food food = new Food("Apple", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(1), 100, 0.2);
        Warehouse warehouse = new Warehouse();
        assertTrue(warehouse.accept(food));
    }

    @Test
    public void testShopAccept() {
        Food food = new Food("Banana", LocalDate.now().plusDays(3),
                LocalDate.now().minusDays(1), 100, 0.2);
        Shop shop = new Shop();
        assertTrue(shop.accept(food));
    }

    @Test
    public void testShopDiscount() {
        Food food = new Food("Orange", LocalDate.now().plusDays(1),
                LocalDate.now().minusDays(3), 100, 0.2);
        Shop shop = new Shop();
        shop.add(food);
        assertEquals(80, food.getPrice(), 0.01);
    }

    @Test
    public void testTrashAccept() {
        Food food = new Food("Milk", LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(10), 100, 0.2);
        Trash trash = new Trash();
        assertTrue(trash.accept(food));
    }
}