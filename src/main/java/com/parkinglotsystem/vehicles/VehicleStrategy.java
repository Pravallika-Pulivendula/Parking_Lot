package com.parkinglotsystem.vehicles;

import com.parkinglotsystem.models.ParkingFloor;
import com.parkinglotsystem.models.ParkingTicket;

import java.util.ArrayList;

public class VehicleStrategy {
    private final Vehicle Vehicle;

    public VehicleStrategy(Vehicle vehicle) {
        this.Vehicle = vehicle;
    }

    public void parkTheVehicleType(ArrayList<ParkingFloor> floors, ParkingTicket tickets, String registrationNumber, String vehicleColor) {
        System.out.println(this.Vehicle.parkVehicle(floors, tickets, registrationNumber, vehicleColor));
    }

}
