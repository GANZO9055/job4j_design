package ru.job4j.ood.lsp.parking;

public class Car implements Vahicle {

    private final int size = 1;
    /*
    Вернуть размер легковой машины
     */
    @Override
    public int getSize() {
        return size;
    }
}
