package HouseMain.Devices;

import Patterns.Device;

public class WashingMachine extends Device {

    public WashingMachine(String name, ResourceConsumption resourceConsumption) {
        super(name, resourceConsumption);
    }

    @Override
    public void use() {
        System.out.println("washing machine");
        this.state.use(this);
    }

}
