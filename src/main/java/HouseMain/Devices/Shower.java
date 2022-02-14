package HouseMain.Devices;

import Patterns.Device;

public class Shower extends Device {
    public Shower(String name, ResourceConsumption resourceConsumption) {
        super(name, resourceConsumption);
    }

    @Override
    public void use() {
        System.out.println("shower");
        this.state.use(this);
    }

}
