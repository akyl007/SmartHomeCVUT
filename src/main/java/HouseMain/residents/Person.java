package HouseMain.residents;

import Patterns.Observer;
import Patterns.Device;
import HouseMain.Devices.Fridge;
import EventsAndReports.Event;
import EventsAndReports.EventType;
import HouseMain.House;
import HouseMain.Room;

import java.util.ArrayList;
import java.util.List;

public class Person implements Observer {

    House house = House.getInstance();
    private String name;
    private PersonType type;
    private Room room;

    public Device usingTarget;
    private List<Device> usedDevices = new ArrayList<>();


    public Person(){}

    public Person(String name, Room room, PersonType type ) {
        this.name = name;
        this.room = room;
        this.type = type;
    }
    public Person(String name, PersonType type) {
        this.name = name;
        this.type = type;
    }

    public PersonType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Room getRoom() {
        return room;
    }

    public List<Device> getUsedDevices() {
        return usedDevices;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void fix(Device device){
        device.fix();
        usedDevices.add(device);
    }

    private void buyFood(Fridge fridge){
        fridge.buyFood();
        usedDevices.add(fridge);
    }

    public void move(Room room){
        this.room.removePerson(this);
        this.setRoom(room);
        this.room.addPerson(this);
    }

    @Override
    public void handleEvent(Event event, Object device) {
        if (event.getEventType() == EventType.BROKEN && this.getType() == PersonType.FATHER){
            this.fix((Device) device);
            String report = "Type: " + event.getEventType() + " Source: " + device.toString() + " Target: " + this.toString() + " Action: fix";
            house.addEventMassage(report);
        }
        if (event.getEventType() == EventType.OUT_OF_FOOD && this.getType() == PersonType.MOTHER){
            String report = "Type: " + event.getEventType() + " Source: " + device.toString() + " Target: " + this.toString() + " Action: buy food";
            house.addEventMassage(report);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
