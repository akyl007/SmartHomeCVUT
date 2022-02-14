package HouseMain.window;

import Patterns.Observer;
import EventsAndReports.Event;
import EventsAndReports.EventType;
import HouseMain.House;

public class Blind implements Observer {

    House house = House.getInstance();
    private BlindState blindState;
    boolean isOpen;

    public Blind() {
        this.blindState = new BlindOpen();
        this.isOpen = true;
    }

    private void open(){
        blindState.open(this);
    }

    private void close(){
        blindState.close(this);
    }

    public BlindState getBlindState() {
        return blindState;
    }

    public void setBlindState(BlindState blindState) {
        this.blindState = blindState;
    }

    @Override
    public void handleEvent(Event event, Object source) {
        if (event.getEventType() == EventType.SUNNY && !this.isOpen){
            open();
            String report = "Type: " + event.getEventType() + " Source: " + source.toString() + " Target: " + this.toString() + " Action: open";
            house.addEventMassage(report);
        }
        if (event.getEventType() == EventType.RAIN && this.isOpen){
            close();
            String report = "Type: " + event.getEventType() + " Source: " + source.toString() + " Target: " + this.toString() + " Action: close";
            house.addEventMassage(report);
        }
    }

    @Override
    public String toString() {
        return "HouseMain.window.Blind";
    }
}
