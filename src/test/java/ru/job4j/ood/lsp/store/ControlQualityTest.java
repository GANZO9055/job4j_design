package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import static org.mockito.Mockito.*;

class ControlQualityTest {
    @Test
    public void testDistribute() {
        Food food1 = new Food("Apple", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(1), 100, 0.2);
        Food food2 = new Food("Banana", LocalDate.now().plusDays(3),
                LocalDate.now().minusDays(1), 100, 0.2);
        Food food3 = new Food("Orange", LocalDate.now().plusDays(1),
                LocalDate.now().minusDays(3), 100, 0.2);
        Food food4 = new Food("Milk", LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(10), 100, 0.2);

        Store warehouse = mock(Warehouse.class);
        Store shop = mock(Shop.class);
        Store trash = mock(Trash.class);

        when(warehouse.accept(food1)).thenReturn(true);
        when(shop.accept(food2)).thenReturn(true);
        when(shop.accept(food3)).thenReturn(true);
        when(trash.accept(food4)).thenReturn(true);

        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        controlQuality.distribute(food1);
        controlQuality.distribute(food2);
        controlQuality.distribute(food3);
        controlQuality.distribute(food4);

        verify(warehouse).add(food1);
        verify(shop).add(food2);
        verify(shop).add(food3);
        verify(trash).add(food4);
    }
}