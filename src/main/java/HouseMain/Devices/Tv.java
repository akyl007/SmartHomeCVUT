package HouseMain.Devices;

import Patterns.Device;

public class Tv extends Device {
    public Tv(String name, ResourceConsumption resourceConsumption) {
        super(name, resourceConsumption);
    }

    @Override
    public void use() {
        System.out.println("tv");
        this.state.use(this);
    }

}
