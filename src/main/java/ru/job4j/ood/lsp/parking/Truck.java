package ru.job4j.ood.lsp.parking;

public class Truck implements Vahicle {

    private final int size;

    public Truck(int size) {
        this.size = size;
    }

    /*
    Вернуть размер грузовика
     */
    @Override
    public int getSize() {
        return size;
    }
}
