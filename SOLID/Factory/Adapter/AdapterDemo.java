package SOLID.Adapter;

// Target Interface
interface USBTypeC {
    void chargePhone();
}

// Adaptee
class OldCharger {
    public void chargeWithRoundPin() {
        System.out.println("Charging phone with old round pin charger");
    }
}

// Adapter
class ChargerAdapter implements USBTypeC {
    OldCharger oldCharger;

    public ChargerAdapter(OldCharger oldCharger) {
        this.oldCharger = oldCharger;
    }

    @Override
    public void chargePhone() {
        // converting round pin to USB-C
        oldCharger.chargeWithRoundPin();
    }
}

// Client
public class AdapterDemo {
    public static void main(String[] args) {
        OldCharger oldCharger = new OldCharger();

        // Using adapter to connect old charger to USB-C port
        USBTypeC adapter = new ChargerAdapter(oldCharger);

        adapter.chargePhone(); // Output: Charging phone with old round pin charger
    }
}

