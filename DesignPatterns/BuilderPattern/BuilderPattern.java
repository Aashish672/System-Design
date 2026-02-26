package BuilderPattern;

class Computer {
    private String cpu;
    private String ram;
    private String storage;

    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public void setRAM(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void displayInfo() {
        System.out.println("Computer Configuration:\n" +
                "CPU: " + cpu + "\n" +
                "RAM: " + ram + "\n" +
                "Storage: " + storage + "\n");
    }
}

// Builder Interface

interface Builder {
    void buildCPU();

    void buildRAM();

    void buildStorage();

    Computer getResult();
}

// ConcreteBuilder
class GamingComputerBuilder implements Builder {
    private Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.setCPU("Gaming CPU");
    }

    @Override
    public void buildRAM() {
        computer.setRAM("16GB DDR4");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("1TB SSD");
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}

// Director
class ComputeDirector {
    public void construct(Builder builder) {
        builder.buildCPU();
        ;
        builder.buildRAM();
        builder.buildStorage();
    }
}

// Cleint
public class BuilderPattern {
    public static void main(String[] args) {
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputeDirector director = new ComputeDirector();

        director.construct(gamingBuilder);
        Computer gamingcomputer = gamingBuilder.getResult();

        gamingcomputer.displayInfo();
    }
}
