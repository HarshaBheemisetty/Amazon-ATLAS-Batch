package BuilderMethodDP;

public class LaptopDirector {
    private LaptopBuilder laptopBuilder;
    LaptopDirector(LaptopBuilder laptopBuilder) {
        this.laptopBuilder = laptopBuilder;
    }
    public Laptop constructLaptop() {
        return laptopBuilder
                .buildMemory(32)

                .buildStorage(1024)
                .build();
    }
}
