package Projects.ElevatorSystem.enums;

public enum FloorNumber {
    ONE(1), TWO(2);

    private int value;

    FloorNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
