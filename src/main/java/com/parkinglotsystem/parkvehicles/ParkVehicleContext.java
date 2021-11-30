package com.parkinglotsystem.parkvehicles;

import com.parkinglotsystem.ParkingFloor;
import com.parkinglotsystem.Ticket;

import java.util.ArrayList;

public class ParkVehicleContext {
    private final ParkVehicle parkVehicle;

    public ParkVehicleContext(ParkVehicle parkVehicle) {
        this.parkVehicle = parkVehicle;
    }

    public void parkTheVehicleType(ArrayList<ParkingFloor> floors, Ticket tickets, String registrationNumber, String vehicleColor) {
        this.parkVehicle.parkVehicle(floors, tickets, registrationNumber, vehicleColor);
    }
}
