package HouseMain.Devices;

import Patterns.Device;

public class Lamp extends Device {
    public Lamp(String name, ResourceConsumption resourceConsumption) {
        super(name, resourceConsumption);
    }

    @Override
    public void use() {
        System.out.println("lamp");
        this.state.use(this);
    }


}
