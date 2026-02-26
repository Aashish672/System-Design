package Projects.ElevatorSystem.enums;

public enum Direction {
    UP(1), DOWN(2), IDLE(3);

    private int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
