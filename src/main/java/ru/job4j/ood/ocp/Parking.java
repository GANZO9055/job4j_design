package ru.job4j.ood.ocp;

public class Parking {

    private String typeCar;

    public Parking(String typeCar) {
        this.typeCar = typeCar;
    }

    /*
    Нарушение принципа OCP, при добавлении нового вида транспорта (Грузовик),
    происходит изменение метода passengerCars
     */
    void passengerCars() {
        if (typeCar.equals("Car1")) {
            System.out.println("Parking car1");
        } else if (typeCar.equals("Car2")) {
            System.out.println("Parking car2");
        } else if (typeCar.equals("Truck1")) {
            System.out.println("Parking truck1");
        } else {
            System.out.println("Error");
        }
    }
}
