package Projects.ElevatorSystem.models;

import Projects.ElevatorSystem.enums.DoorAction;

public class Door {
    private DoorAction doorAction;

    public Door(DoorAction doorAction) {
        this.doorAction = doorAction;
    }

    public Door() {

    }

    public void openDoor() {
        doorAction = DoorAction.valueOf("OPEN");
    }

    public void closeDoor() {
        doorAction = DoorAction.valueOf("CLOSE");
    }
}
