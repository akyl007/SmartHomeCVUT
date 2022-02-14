package HouseMain.Devices;

import Patterns.Device;

public class Computer extends Device {
    public Computer(String name, ResourceConsumption resourceConsumption) {
        super(name, resourceConsumption);
    }

    @Override
    public void use() {
        System.out.println("HouseMain.Devices.Computer");
        this.state.use(this);
    }

}
