package ru.job4j.ood.isp;

public interface Workshop {
    void repair();
    void inspection();
    void purchaseOfSpareParts();
    void assembling();

}
/*
Нарушениие принципа ISP, неверное выделение абстракции,
из-за чего в классе WorkshopRepairCar (в методе assembling) возникает ошибка.
 */
class WorkshopRepairCar implements Workshop {

    @Override
    public void repair() {
        System.out.println("Repair car");
    }

    @Override
    public void inspection() {
        System.out.println("Inspection car");
    }

    @Override
    public void purchaseOfSpareParts() {
        System.out.println("Purchase of spare parts for the car");
    }

    @Override
    public void assembling() {
        throw new RuntimeException("Error");
    }
}

class WorkshopRepairComputer implements Workshop {

    @Override
    public void repair() {
        System.out.println("Repair computer");
    }

    @Override
    public void inspection() {
        System.out.println("Inspection computer");
    }

    @Override
    public void purchaseOfSpareParts() {
        System.out.println("Purchase of computer parts");
    }

    @Override
    public void assembling() {
        System.out.println("Computer assembly");
    }
}
