package com.everest.parkinglotsystem;

import com.everest.parkinglotsystem.display.DisplayStrategy;
import com.everest.parkinglotsystem.enums.DisplayType;
import com.everest.parkinglotsystem.enums.InputCommands;
import com.everest.parkinglotsystem.enums.VehicleType;
import com.everest.parkinglotsystem.models.Input;
import com.everest.parkinglotsystem.services.ParkingLot;

public class Main {
    static ParkingLot parkingLot = null;

    public static void main(String[] args) {
        Input inputData = new Input();
        DisplayStrategy displayContext;

        for (String string : inputData.inputGenerator()) {
            String[] input;
            input = string.split(" ");
            switch (InputCommands.valueOf(input[0])) {
                case create_parking_lot -> {
                    if (parkingLot == null) {
                        parkingLot = new ParkingLot(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                        parkingLot.createParkingLot();
                    }
                }
                case park_vehicle -> {
                    if (parkingLot != null) parkingLot.parkVehicle(VehicleType.valueOf(input[1]), input[2], input[3]);
                    else System.out.println("Create parking lot first!");
                }
                case unpark_vehicle -> {
                    if (parkingLot != null) parkingLot.unParkVehicle(input[1]);
                    else System.out.println("Create parking lot first!");
                }
                case display -> {
                    if (parkingLot != null) {
                        displayContext = parkingLot.getDisplayContext(VehicleType.valueOf(input[2]));
                        switch (DisplayType.valueOf(input[1])) {
                            case free_count -> displayContext.displayCount(parkingLot.getFloorDetails());
                            case free_slots -> displayContext.displayFreeSlots(parkingLot.getFloorDetails());
                            case occupied_slots -> displayContext.displayOccupiedSlots(parkingLot.getFloorDetails());
                            default -> System.out.println("Enter valid display method");
                        }
                    } else
                        System.out.println("Create parking lot first!");
                }
                default -> throw new IllegalStateException("Unexpected value: " + input[0]);
            }
        }
    }
}
