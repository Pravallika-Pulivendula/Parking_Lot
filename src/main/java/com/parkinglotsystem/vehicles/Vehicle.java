package com.parkinglotsystem.vehicles;

import com.parkinglotsystem.models.ParkingFloor;
import com.parkinglotsystem.models.ParkingTicket;

import java.util.ArrayList;

public interface Vehicle {
    default String parkVehicle(ArrayList<ParkingFloor> floors, ParkingTicket tickets, String registrationNumber, String color) {
        String ticketId = "";
        for (int floor = 0; floor < floors.size(); floor++) {
            ParkingFloor eachFloor = floors.get(floor);
            ticketId = getTicketIfSlotFree(eachFloor, tickets, registrationNumber, color, floor);
            if (ticketId.length() != 0) return "Parked vehicle. Ticket ID: " + ticketId;
        }
        return "Parking Lot Full";
    }

    String getTicketIfSlotFree(ParkingFloor eachFloor, ParkingTicket tickets, String registrationNumber, String color, int floor);
}
