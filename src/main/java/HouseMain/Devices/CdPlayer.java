package HouseMain.Devices;


import Patterns.Device;

public class CdPlayer extends Device {

    public CdPlayer(String name, ResourceConsumption resourceConsumption) {
        super(name, resourceConsumption);
    }

    @Override
    public void use() {
        System.out.println("CDPlayer");
        this.state.use(this);
    }
}
