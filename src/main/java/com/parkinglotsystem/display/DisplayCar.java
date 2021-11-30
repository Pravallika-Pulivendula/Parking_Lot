package com.parkinglotsystem.display;

import com.parkinglotsystem.models.ParkingFloor;
import com.parkinglotsystem.models.ParkingSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DisplayCar implements Display {

    ArrayList<ArrayList<Integer>> slotsInfo;
    ArrayList<Integer> free_slots, occupied_slots;

    public Map<Integer, ArrayList<ArrayList<Integer>>> display(ArrayList<ParkingFloor> floors) {
        Map<Integer, ArrayList<ArrayList<Integer>>> displayDetails = new HashMap<>();
        for (int floor = 0; floor < floors.size(); floor++) {
            initializeArrayLists();
            ParkingFloor eachFloor = floors.get(floor);
            slotsInfo = getSlotsInfo(eachFloor);
            displayDetails.put(floor, slotsInfo);
        }
        return displayDetails;
    }

    public void initializeArrayLists() {
        slotsInfo = new ArrayList<>();
        free_slots = new ArrayList<>();
        occupied_slots = new ArrayList<>();
    }

    public ArrayList<ArrayList<Integer>> getSlotsInfo(ParkingFloor eachFloor) {
        for (int eachSlot = 3; eachSlot < eachFloor.getSlots().size(); eachSlot++) {
            ParkingSlot slotPerFloor = eachFloor.getSlots().get(eachSlot);
            if (slotPerFloor.isSlotEmpty())
                free_slots.add(eachSlot + 1);
            else occupied_slots.add(eachSlot + 1);
        }
        slotsInfo.add(free_slots);
        slotsInfo.add(occupied_slots);
        return slotsInfo;
    }

    @Override
    public void displayFreeCount(ArrayList<ParkingFloor> floors) {
        int floor = 0;
        while (floor < floors.size()) {
            System.out.println("No of free slots for CAR on floor " + (floor + 1) + ": " + this.display(floors).get(floor).get(0).size());
            floor++;
        }
    }


    @Override
    public void displayFreeSlots(ArrayList<ParkingFloor> floors) {
        int floor = 0;
        while (floor < floors.size()) {
            System.out.println("Free slots for CAR on floor " + (floor + 1) + ": " + this.display(floors).get(floor).get(0).toString().replace("[", "").replace("]", ""));
            floor++;
        }
    }

    @Override
    public void displayOccupiedSlots(ArrayList<ParkingFloor> floors) {
        int floor = 0;
        while (floor < floors.size()) {
            System.out.println("Occupied slots for CAR on floor " + (floor + 1) + ": " + this.display(floors).get(floor).get(1).toString().replace("[", "").replace("]", ""));
            floor++;
        }
    }
}
