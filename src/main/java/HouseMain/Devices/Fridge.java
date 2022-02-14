package HouseMain.Devices;

import EventsAndReports.Event;
import EventsAndReports.EventType;
import Patterns.Device;

public class Fridge extends Device {

    private int FoodCount = 30;

    public Fridge(String name, ResourceConsumption resourceConsumption) {
        super(name, resourceConsumption);
    }

    @Override
    public void use() {
        FoodCount--;
        if (FoodCount == 0){
            notifyAll(new Event(EventType.OUT_OF_FOOD));
        }
        this.state.use(this);
    }

    public void buyFood(){
        FoodCount = 30;
    }


}
