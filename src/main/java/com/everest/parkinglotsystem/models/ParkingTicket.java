package com.everest.parkinglotsystem.models;

import java.util.*;

public class ParkingTicket {
    Map<String, ArrayList<String>> ticketIdOfVehicles = new HashMap<>();

    public String generateTicketId(String parkingLotId, String registrationNumber, String color, int floorNo, int slotNo) {
        String ticketId = "";
        ticketId = parkingLotId + "_" + floorNo + "_" + slotNo;
        ticketIdOfVehicles.put(ticketId, new ArrayList<>(List.of(registrationNumber, color, Integer.toString(floorNo - 1), Integer.toString(slotNo - 1))));
        return ticketId;
    }

    public Map<String, ArrayList<String>> getTicketDetails() {
        return ticketIdOfVehicles;
    }

    public ArrayList<String> removeTicketId(String ticketId) {
        ArrayList<String> unparkedVehicleDetails = new ArrayList<>();
        if (ticketIdOfVehicles.containsKey(ticketId))
            unparkedVehicleDetails = ticketIdOfVehicles.remove(ticketId);
        return unparkedVehicleDetails;
    }
}


