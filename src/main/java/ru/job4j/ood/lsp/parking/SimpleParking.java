package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class SimpleParking implements Parking {

    private int numberCars;
    private int numberTrucks;
    List<Vahicle> listParkedVahicles;
    private int numberOfAvailableCarSeats;
    private int numberOfAvailableTruckSeats;

    public SimpleParking(int numberCars, int numberTrucks) {
        this.numberCars = numberCars;
        this.numberTrucks = numberTrucks;
        this.numberOfAvailableCarSeats = numberCars;
        this.numberOfAvailableTruckSeats = numberTrucks;
        this.listParkedVahicles = new ArrayList<>();
    }
    /*
    Припарковать машину на площадку
     */
    @Override
    public boolean parkVehicle(Vahicle vahicle) {
        boolean value = false;
        if (vahicle.getSize() == 1 && numberOfAvailableCarSeats > 0) {
            listParkedVahicles.add(vahicle);
            numberOfAvailableCarSeats--;
            value = true;
        } else {
            if (vahicle.getSize() > 1 && numberOfAvailableTruckSeats > 0) {
                listParkedVahicles.add(vahicle);
                numberOfAvailableTruckSeats--;
                value = true;
            } else if (numberOfAvailableCarSeats >= vahicle.getSize()) {
                listParkedVahicles.add(vahicle);
                numberOfAvailableCarSeats -= vahicle.getSize();
                value = true;
            }
        }
        return value;
    }
    /*
    Машина покидает площадку
    В случае если грузовик занимает место легковых машин, то количество мест освобождается
    и счетчик грузовиков обновляется до прежнего уровня.
     */
    @Override
    public void leaveVehicle(Vahicle vahicle) {
        if (listParkedVahicles.remove(vahicle)) {
            if (vahicle.getSize() == 1) {
                numberOfAvailableCarSeats++;
            } else {
                numberOfAvailableTruckSeats++;
                if (numberOfAvailableTruckSeats > numberTrucks) {
                    numberOfAvailableCarSeats += vahicle.getSize();
                    numberOfAvailableTruckSeats = numberTrucks;
                }
            }
        }
    }
    /*
    Вернуть количество свободных мест для легковых автомобилей
     */
    @Override
    public int getNumberAvailableSeatsForCars() {
        return numberOfAvailableCarSeats;
    }
    /*
    Вернуть количество свободных мест для грузовиков
    */
    @Override
    public int getNumberAvailableSeatsForTrucks() {
        return numberOfAvailableTruckSeats;
    }
}
