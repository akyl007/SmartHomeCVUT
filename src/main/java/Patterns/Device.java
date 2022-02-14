package Patterns;

import HouseMain.Devices.ResourceConsumption;
import Patterns.Observer;
import Patterns.Observered;
import EventsAndReports.Event;
import EventsAndReports.EventType;
import States.DeviceStateEnum;
import States.IdleState;
import States.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Device implements Observered {

    private String name;
    private List<Observer> observers = new ArrayList<>();

    public DeviceStateEnum deviceStateEnum;

    public State getState() {
        return state;
    }

    protected State state = new IdleState();
    public Integer totalElectricityConsumption = 0;
    public Integer totalWaterConsumption = 0;
    public Integer totalGasConsumption = 0;

    ResourceConsumption resourceConsumption;

    public Device(String name, ResourceConsumption resourceConsumption) {
        this.name = name;
        this.resourceConsumption = resourceConsumption;
        this.deviceStateEnum = DeviceStateEnum.IDLE;
    }

    public DeviceStateEnum getDeviceStateEnum() {
        return deviceStateEnum;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setTotalElectricityConsumption(Integer totalElectricityConsumption) {
        this.totalElectricityConsumption = totalElectricityConsumption;
    }

    public void setTotalWaterConsumption(Integer totalWaterConsumption) {
        this.totalWaterConsumption = totalWaterConsumption;
    }

    public void setTotalGasConsumption(Integer totalGasConsumption) {
        this.totalGasConsumption = totalGasConsumption;
    }

    public Integer getTotalElectricityConsumption() {
        return totalElectricityConsumption;
    }

    public Integer getTotalGasConsumption() {
        return totalGasConsumption;
    }

    public Integer getTotalWaterConsumption() {
        return totalWaterConsumption;
    }

    /**
     *  change state from OFF to IDLE
     */
    public void turnOn(){
        state.turnOn(this);
    }

    /**
     *  change state from IDLE/ACTIVE to OFF
     */
    public void turnOff(){
        state.turnOff(this);
    }

    /**
     *  change state from BROKEN to IDLE
     */
    public void fix(){
        state.fix(this);
    }

    /**
     *  change state from ACTIVE to IDLE
     */
    public void stopUse(){
        state.stopUse(this);
    }

    public abstract void use();

    public void addConsumption(){
        totalElectricityConsumption += resourceConsumption.getElectricityUsage(deviceStateEnum);
        totalWaterConsumption += resourceConsumption.getWaterUsage(deviceStateEnum);
        totalGasConsumption += resourceConsumption.getGasUsage(deviceStateEnum);
    }

    public void generateEvent(){
        Random random = new Random();
        int chance = random.nextInt(30);
        if (chance == 0){
            notifyAll(new Event(EventType.BROKEN));
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    @Override
    public void notifyAll(Event event) {
        for (Observer observer : observers){
            observer.handleEvent(event, this.toString());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
