package com.everest.parkinglotsystem.vehicles;

import com.everest.parkinglotsystem.models.ParkingFloor;
import com.everest.parkinglotsystem.models.Ticket;

import java.util.ArrayList;

public class VehicleStrategy {
    private final Vehicle Vehicle;

    public VehicleStrategy(Vehicle vehicle) {
        this.Vehicle = vehicle;
    }

    public void parkTheVehicleType(ArrayList<ParkingFloor> floors, Ticket tickets, String registrationNumber, String vehicleColor) {
        System.out.println(this.Vehicle.parkVehicle(floors, tickets, registrationNumber, vehicleColor));
    }
}
