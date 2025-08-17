// Interface for any switchable device
interface SwitchOnOff {
    void turnOn();
    void turnOff();
}

// LightBulb now implements the SwitchOnOff interface
class LightBulb implements SwitchOnOff {
    public void turnOn() {
        System.out.println("Light turned on");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}

// The Switch depends on the abstraction, not on a concrete class
class Switch {
    private SwitchOnOff device;

    // ✅ Proper constructor (not a method)
    public Switch(SwitchOnOff device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}
public class Day21_DIP_Implementation {
    public static void main(String[] args) {
        SwitchOnOff lbulbobj = new LightBulb();      // ✅ Abstract reference
        Switch lightswitch = new Switch(lbulbobj);   // ✅ DIP: depends on abstraction
        lightswitch.operate();                       // ✅ Output: Light turned on
    }
}
