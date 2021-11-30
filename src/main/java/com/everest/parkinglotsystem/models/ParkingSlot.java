package com.everest.parkinglotsystem.models;

public class ParkingSlot {
        private boolean isSlotFree;

        ParkingSlot() {
            this.isSlotFree = true;
        }

        public void freeSlot() {
            this.isSlotFree = true;
        }

        public void occupySlot() {
            this.isSlotFree = false;
        }

        public boolean isSlotEmpty() {
            return isSlotFree;
        }
}
