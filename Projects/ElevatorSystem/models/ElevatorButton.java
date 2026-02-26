package Projects.ElevatorSystem.models;

import Projects.ElevatorSystem.enums.FloorNumber; // Import the enum
import Projects.ElevatorSystem.interfaces.Button; // Import the interface

// Implement the Button interface
public class ElevatorButton implements Button {
    private boolean status;
    private FloorNumber floorNumber; // Use the FloorNumber enum, not Integer

    // Constructor now accepts the FloorNumber enum
    public ElevatorButton(boolean status, FloorNumber floorNumber) {
        this.status = status;
        this.floorNumber = floorNumber;
    }

    public FloorNumber getFloorNumber() {
        return this.floorNumber;
    }

    public void setFloorNumber(FloorNumber floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean isPressed() {
        return this.status;
    }

    // Must return boolean to match the Button interface
    @Override
    public boolean press() {
        this.status = !this.status;
        return this.status;
    }
}