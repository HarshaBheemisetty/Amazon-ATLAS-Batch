import java.util.*;

class Animal {
    void sound() {
        System.out.println("Generic animal sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow is the sound of cat");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Woof is the sound of dog");
    }
}

public class Day21_GenericWildCards {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());

        // Read-only wildcards
        List<? extends Animal> animals = cats;
        for (Animal a : animals) {
            a.sound();  // ✅ Allowed
        }

        // animals.add(new Dog()); // ❌ Not allowed

        // Write-safe wildcards
        List<? super Cat> writeList = new ArrayList<>();
        writeList.add(new Cat()); // ✅ OK
        writeList.add(new Tiger()); // ✅ if Tiger extends Cat

        // Object obj = writeList.get(0); // Only returns Object
    }
}

class Tiger extends Cat {}
