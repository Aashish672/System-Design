package Projects.ElevatorSystem;

import Projects.ElevatorSystem.enums.*;
import Projects.ElevatorSystem.models.*;
import java.util.Arrays;

/**
 * Main class to simulate the Elevator System.
 * Place this file in the parent directory of your 'Projects' package.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Elevator System...");

        // 1. Get the Singleton instance of the Elevator System
        ElevatorSystem system = ElevatorSystem.getInstance();

        // 2. Create the building components
        Floor floor1 = new Floor(FloorNumber.ONE, new OutsidePannel());
        Floor floor2 = new Floor(FloorNumber.TWO, new OutsidePannel());
        // Add more floors as needed

        Elevator elevator1 = new Elevator();
        // Add more elevators as needed

        // 3. Initialize the Elevator System with floors and elevators
        system.setFloors(Arrays.asList(floor1, floor2));
        system.setElevators(Arrays.asList(elevator1));

        System.out.println("System Initialized with " + system.getFloors().size() + " floors and "
                + system.getElevators().size() + " elevator(s).");
        System.out.println("-------------------------------------------------");

        // 4. SIMULATION: A user on Floor 1 wants to go UP.
        System.out.println("User on Floor 1 presses the UP button.");
        // floor1.getOutsidePannel().pressButton(Direction.UP);

        // 5. The system receives the request and assigns an elevator
        // (Your current logic just returns null, so we'll fake it)
        Elevator assignedElevator = system.requestElevator(Direction.UP, floor1);

        if (assignedElevator == null) {
            // Your requestElevator logic is not implemented, so we'll manually assign one
            assignedElevator = system.getElevators().get(0);
            System.out.println("Dispatch logic incomplete. Manually assigning Elevator 1.");
        }

        // System.out.println("Elevator 1 is on floor " +
        // assignedElevator.getCurrentFloor());
        System.out.println("Elevator 1 moving to Floor 1...");
        assignedElevator.setCurrentFloorNumber(FloorNumber.ONE);

        // 6. Elevator arrives, door opens
        System.out.println("Elevator 1 has arrived at Floor 1. Door opening.");
        system.openDoor(assignedElevator);

        // 7. User gets in and selects Floor 2
        System.out.println("User gets in, presses button for Floor 2.");
        system.selectFloor(FloorNumber.TWO, assignedElevator);

        // 8. Door closes and elevator moves
        System.out.println("Door closing.");
        system.closeDoor(assignedElevator);

        System.out.println("Elevator moving to Floor 2...");
        assignedElevator.setCurrentFloorNumber(FloorNumber.TWO);
        System.out.println("Elevator has arrived at Floor 2.");

        // 9. Simulation ends
        System.out.println("-------------------------------------------------");
        System.out.println("Simulation complete.");
    }
}