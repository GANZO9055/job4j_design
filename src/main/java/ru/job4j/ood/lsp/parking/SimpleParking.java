package ru.job4j.ood.lsp.parking;

import java.util.List;

public class SimpleParking implements Parking {

    private int numberCars;
    private int numberTrucks;
    List<Vahicle> listParkedVahicles;
    private final int numberOfAvailableCarSeats;
    private final int numberOfAvailableTruckSeats;

    public SimpleParking(int numberCars, int numberTrucks) {
        this.numberCars = numberCars;
        this.numberTrucks = numberTrucks;
        this.numberOfAvailableCarSeats = numberCars;
        this.numberOfAvailableTruckSeats = numberTrucks;
    }
    /*
    Припарковать машину на площадку
     */
    @Override
    public boolean parkVehicle(Vahicle vahicle) {
        return false;
    }
    /*
    Машина покидает площадку
     */
    @Override
    public void leaveVehicle(Vahicle vahicle) {

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
