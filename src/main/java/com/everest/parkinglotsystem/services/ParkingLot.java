package com.everest.parkinglotsystem.services;

import com.everest.parkinglotsystem.display.DisplayBike;
import com.everest.parkinglotsystem.display.DisplayCar;
import com.everest.parkinglotsystem.display.DisplayStrategy;
import com.everest.parkinglotsystem.display.DisplayTruck;
import com.everest.parkinglotsystem.enums.VehicleType;
import com.everest.parkinglotsystem.models.ParkingFloor;
import com.everest.parkinglotsystem.models.ParkingTicket;
import com.everest.parkinglotsystem.vehicles.Bike;
import com.everest.parkinglotsystem.vehicles.Car;
import com.everest.parkinglotsystem.vehicles.VehicleStrategy;
import com.everest.parkinglotsystem.vehicles.Truck;


import java.util.ArrayList;

public class ParkingLot {
    private final int noOfFloors;
    private final int noOfSlots;
    private final ArrayList<ParkingFloor> floors = new ArrayList<>();
    ParkingTicket tickets = new ParkingTicket();
    VehicleStrategy context;
    DisplayStrategy displayContext;

    public ParkingLot(String parkingLotId, int noOfFloors, int noOfSlots) {
        this.noOfFloors = noOfFloors;
        this.noOfSlots = noOfSlots;
        for (int floor = 0; floor < noOfFloors; floor++) {
            this.floors.add(new ParkingFloor(this.noOfSlots));
        }
    }

    public void createParkingLot() {
        System.out.println("Created parking lot with " + this.noOfFloors + " floors and " + this.noOfSlots + " slots per floor");
    }

    public void parkVehicle(VehicleType vehicleType, String registrationNumber, String vehicleColor) {
        switch (vehicleType) {
            case CAR -> context = new VehicleStrategy(new Car());
            case BIKE -> context = new VehicleStrategy(new Bike());
            case TRUCK -> context = new VehicleStrategy(new Truck());
            default -> throw new IllegalStateException("Enter valid vehicleType: " + vehicleType);
        }
        context.parkTheVehicleType(getFloorDetails(), tickets, registrationNumber, vehicleColor);
    }

    public String unParkVehicle(String ticketId) {
        ArrayList<String> unParkedVehicleDetails = tickets.removeTicketId(ticketId);
        if (unParkedVehicleDetails.size() == 0) return "Invalid ticket";
        int floorNo = Integer.parseInt(unParkedVehicleDetails.get(2));
        int slotNo = Integer.parseInt(unParkedVehicleDetails.get(3));
        floors.get(floorNo).getSlots().get(slotNo).freeSlot();
        return "UnParked vehicle with Registration number: " + unParkedVehicleDetails.get(0) + " and Color: " + unParkedVehicleDetails.get(1);
    }


    public ArrayList<ParkingFloor> getFloorDetails() {
        return this.floors;
    }

    public DisplayStrategy getDisplayContext(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR -> displayContext = new DisplayStrategy(new DisplayCar());
            case BIKE -> displayContext = new DisplayStrategy(new DisplayBike());
            case TRUCK -> displayContext = new DisplayStrategy(new DisplayTruck());
            default -> throw new IllegalStateException("Enter valid vehicleType: " + vehicleType);
        }
        return displayContext;
    }

}
