package Sensors;

import Patterns.Observer;
import Patterns.Observered;
import EventsAndReports.Event;
import EventsAndReports.EventType;
import HouseMain.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WindSensor implements Observered {
    private static House house = House.getInstance();
    private static WindSensor instance;
    List<Observer> observers = new ArrayList<>();

    public static WindSensor getInstance() {
        if (instance == null) {
            instance = new WindSensor();
        }
        return instance;
    }

    public WindSensor() {
        house.setSensor(this);
    }

    public void generateEvent(){
        Random random = new Random();
        int chance = random.nextInt(2);

        if (chance == 0){
            notifyAll(new Event(EventType.RAIN));
        }
        else {
            notifyAll(new Event(EventType.SUNNY));
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
        return "Sensors.WindSensor";
    }
}
