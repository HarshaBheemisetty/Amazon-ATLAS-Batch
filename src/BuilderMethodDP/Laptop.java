package BuilderMethodDP;

public class Laptop {
    int memory;
    int storage;
    // graphic card,processor...
    Laptop() {
        System.out.println("Laptop constructor");
    }
    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getMemory() {
        return memory;
    }

    public int getStorage() {
        return storage;
    }
}
