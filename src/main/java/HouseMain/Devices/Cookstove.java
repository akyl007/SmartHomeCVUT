package HouseMain.Devices;

import Patterns.Device;

public class Cookstove extends Device {

    public Cookstove(String name, ResourceConsumption resourceConsumption) {
        super(name, resourceConsumption);
    }

    @Override
    public void use() {
        System.out.println("CookStove");
        this.state.use(this);
    }

}
