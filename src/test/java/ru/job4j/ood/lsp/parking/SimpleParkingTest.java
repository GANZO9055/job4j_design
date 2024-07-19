package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Disabled()
class SimpleParkingTest {

    @Test
    void whenParkingCarAndTruck() {
        SimpleParking simpleParking = new SimpleParking(6, 7);
        Car car = new Car();
        Truck truck = new Truck(4);
        assertTrue(simpleParking.parkVehicle(car));
        assertTrue(simpleParking.parkVehicle(truck));
    }

    @Test
    void whenNotAvailableSeatsForCar() {
        SimpleParking simpleParking = new SimpleParking(0, 10);
        Car car = new Car();
        boolean result = simpleParking.parkVehicle(car);
        assertFalse(result);
    }

    @Test
    void whenNotAvailableSeatsForTruck() {
        SimpleParking simpleParking = new SimpleParking(10, 2);
        Truck truck = new Truck(3);
        boolean result = simpleParking.parkVehicle(truck);
        assertFalse(result);
    }

    @Test
    void whenCarLeaveParking() {
        SimpleParking simpleParking = new SimpleParking(16, 10);
        Car car = new Car();
        boolean result = simpleParking.parkVehicle(car);
        assertTrue(result);
        simpleParking.leaveVehicle(car);
        assertEquals(simpleParking.getNumberAvailableSeatsForCars(), 16);
    }

    @Test
    void whenTruckLeaveParking() {
        SimpleParking simpleParking = new SimpleParking(16, 10);
        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(3);
        simpleParking.parkVehicle(truck1);
        simpleParking.parkVehicle(truck2);
        simpleParking.leaveVehicle(truck2);
        assertEquals(simpleParking.getNumberAvailableSeatsForTrucks(), 7);
    }
}