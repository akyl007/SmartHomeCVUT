package HouseMain;

import Patterns.Device;
import Sensors.WindSensor;

import java.util.ArrayList;
import java.util.List;

public class House {

    private static House instance;
    private List<Floor> floors = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private List<Device> devices = new ArrayList<>();
    private WindSensor sensor;
    private List<String> massages = new ArrayList<>();

    public static House getInstance() {
        if (instance == null) {
            instance = new House();
        }
        return instance;
    }

    public void addFloor(Floor floor){
        floors.add(floor);
    }

    public WindSensor getSensor() {
        return sensor;
    }

    public void setSensor(WindSensor sensor) {
        this.sensor = sensor;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<String> getMassages() {
        return massages;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevices(List<Device> devices){
        this.devices.addAll(devices);
    }

    public void addEventMassage(String eventMassage){
        massages.add(eventMassage);
    }



}
