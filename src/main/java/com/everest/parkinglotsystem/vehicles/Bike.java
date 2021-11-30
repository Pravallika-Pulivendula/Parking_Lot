package com.everest.parkinglotsystem.vehicles;

import com.everest.parkinglotsystem.models.ParkingFloor;
import com.everest.parkinglotsystem.models.ParkingSlot;
import com.everest.parkinglotsystem.models.ParkingTicket;

import java.util.ArrayList;

public class Bike implements Vehicle {
    @Override
    public String parkVehicle(ArrayList<ParkingFloor> floors, ParkingTicket tickets, String registrationNumber, String color) {
        String ticketId = "";
        for (int floor = 0; floor < floors.size(); floor++) {
            ParkingFloor eachFloor = floors.get(floor);
            ticketId = getTicketIfSlotFree(eachFloor, tickets, registrationNumber, color, floor);
            if (ticketId.length() != 0) return "Parked vehicle. Ticket ID: " + ticketId;
        }
        return "Parking Lot Full";
    }

    public String getTicketIfSlotFree(ParkingFloor eachFloor, ParkingTicket tickets, String registrationNumber, String color, int floor) {
        String ticketId = "";
        for (int eachSlot = 1; eachSlot < 3; eachSlot++) {
            ParkingSlot slotPerFloor = eachFloor.getSlots().get(eachSlot);
            if (slotPerFloor.isSlotEmpty()) {
                slotPerFloor.occupySlot();
                ticketId = tickets.generateTicketId("PR1234", registrationNumber, color, floor + 1, eachSlot + 1);
                return ticketId;
            }
        }
        return ticketId;
    }
}
