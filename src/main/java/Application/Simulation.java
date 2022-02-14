package Application;

import HouseMain.Devices.*;
import EventsAndReports.ActivityAndUsageReport;
import EventsAndReports.ConsumptionReport;
import EventsAndReports.EventReport;
import EventsAndReports.HouseConfigurationReport;
import HouseMain.Floor;
import HouseMain.House;
import HouseMain.Room;
import HouseMain.residents.*;
import Patterns.Device;
import Patterns.DeviceFactory;

public class Simulation {


    House house = House.getInstance();
    private void conf(){
        DeviceFactory deviceFactory = new DeviceFactory();

        Fridge fridge = deviceFactory.createFridge("fridge");
        Cookstove cookstove = deviceFactory.createCookstove("cook stove");
        Lamp lamp1 = deviceFactory.createLamp("lamp1");
        Lamp lamp2 = deviceFactory.createLamp("lamp2");
        Computer computer = deviceFactory.createComputer("computer");
        CdPlayer cdPlayer = deviceFactory.createCdPlayer("cd player");
        Shower shower = deviceFactory.createShower("shower");
        WashingMachine washingMachine = deviceFactory.createWashingMachine("washing machine");
        Tv tv = deviceFactory.createTv("TV");


        Floor floor1 = new Floor(1);

        Room Kitchen = new Room("room");
        Kitchen.addDevice(fridge);
        Kitchen.addDevice(cookstove);

        Room BedRoom1 = new Room("room");
        BedRoom1.addDevice(lamp1);
        BedRoom1.addDevice(computer);

        Room BedRoom2 = new Room("room");
        BedRoom2.addDevice(lamp2);
        BedRoom2.addDevice(cdPlayer);

        Room BathRoom = new Room("room");
        BathRoom.addDevice(shower);
        BathRoom.addDevice(washingMachine);

        Room LivingRoom = new Room("room");
        LivingRoom.addDevice(tv);

        floor1.addRoom(Kitchen);
        floor1.addRoom(BedRoom1);
        floor1.addRoom(BedRoom2);
        floor1.addRoom(BathRoom);
        floor1.addRoom(LivingRoom);

        house.addFloor(floor1);

        Person person1 = new Person("Father", LivingRoom, PersonType.FATHER);
        Person person2 = new Person("Mother", LivingRoom, PersonType.MOTHER);
        Person person3 = new Person("Son", LivingRoom, PersonType.SON);
        Pet pet = new Pet("Rex", PetType.DOG);
        LivingRoom.addPerson(person1);
        BathRoom.addPerson(person2);
        BedRoom1.addPerson(person3);
        BedRoom1.addPet(pet);


        PersonApi api = new PersonApi();
        PetApi petApi = new PetApi();
        int round = 0;

        /*
        Application.Simulation per round:
            1. HouseMain.Devices and sensor generates events
            2. Each person move to random room and use random device in this room,
               if there are not devices -> DO_NOTHING
            3. Collect information about consumption
         */

        HouseConfigurationReport houseConfigurationReport = new HouseConfigurationReport(house, 1);
        ConsumptionReport consumptionReport = new ConsumptionReport(house, 1);
        ActivityAndUsageReport activityAndUsageReport = new ActivityAndUsageReport(house,1);
        EventReport eventReport = new EventReport(House.getInstance(), 1);
        while (round < 5){
            devicesEvent();
            api.startRound(person1);
            api.startRound(person2);
            api.startRound(person3);
            petApi.startRound(pet);

            addConsumption();
            eventReport.addRound(round);
            api.finshRound(person1);
            api.finshRound(person2);
            api.finshRound(person3);

            round++;
        }

        consumptionReport.generateReport();
        houseConfigurationReport.generateReport();
        activityAndUsageReport.generateReport();
        eventReport.generateReport();



    }

    public void run(){
        conf();
    }

    private void addConsumption() {
        this.house.getFloors().forEach(f -> f.getRooms().forEach(room -> room.getDevices().forEach(Device::addConsumption)));
    }

    private void devicesEvent() {
        this.house.getFloors().forEach(
                floor -> floor.getRooms().forEach(
                        room -> room.getDevices().forEach(Device::generateEvent)));
    }

    private void sensorEvent() {
        house.getSensor().generateEvent();
    }

}


//import Application.Config1;
//import Patterns.Device;
//import devices.objects.*;
//import event.EventMassage;
//import house.*;
//import HouseMain.window.Blind;
//import Patterns.DeviceFactory;
//import EventsAndReports.ActivityAndUsageReport;
//import EventsAndReports.ConsumptionReport;
//import EventsAndReports.EventReport;
//import EventsAndReports.HouseConfigurationReport;
//import HouseMain.residents.Person;
//import HouseMain.residents.PersonType;
//import HouseMain.residents.PersonApi;
//import Sensors.WindSensor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Application.Simulation {
//
//
//    HouseMain.House house = HouseMain.House.getInstance();
//    private void conf(){
//
//        //Gen devices and sensor
//        List<Patterns.Device> devices = new ArrayList<>();
//        Sensors.WindSensor sensor = Sensors.WindSensor.getInstance();
//
//        Patterns.DeviceFactory deviceFactory = new Patterns.DeviceFactory();
//        HouseMain.Devices.Fridge fridge = deviceFactory.createFridge("fridge");
//        HouseMain.Devices.Computer computer = deviceFactory.createComputer("computer");
//        HouseMain.Devices.Shower shower = deviceFactory.createShower("computer");
//        devices.add(fridge);
//        devices.add(computer);
//        devices.add(shower);
//
//        //Gen floor
//        HouseMain.Floor floor = new HouseMain.Floor(1);
//        HouseMain.Room lr = new HouseMain.Room("living room");
//        HouseMain.Room br = new HouseMain.Room("bathroom room");
//        lr.addDevice(fridge);
//        lr.addDevice(computer);
//        br.addDevice(shower);
//        floor.addRoom(lr);
//        floor.addRoom(br);
//
//        HouseMain.window.Window window = new HouseMain.window.Window();
//        HouseMain.window.Blind blind = new HouseMain.window.Blind();
//        window.setBlind(blind);
//        lr.addWindow(window);
//
//        //Gen person
//        HouseMain.residents.Person person1 = new HouseMain.residents.Person("Father", lr, HouseMain.residents.PersonType.FATHER);
//
//        //Add observers
//        devices.forEach(device -> device.addObserver(person1));
//        sensor.addObserver(blind);
//
//        house.addDevices(devices);
//
//    }
//
//    public void run(){
//        conf();
//        HouseMain.residents.PersonApi api = new HouseMain.residents.PersonApi();
//
//        EventsAndReports.HouseConfigurationReport houseConfigurationReport = new EventsAndReports.HouseConfigurationReport(house, 1);
//        EventsAndReports.ConsumptionReport consumptionReport = new EventsAndReports.ConsumptionReport(house, 1);
//        EventsAndReports.ActivityAndUsageReport activityAndUsageReport = new EventsAndReports.ActivityAndUsageReport(house,1);
//        EventsAndReports.EventReport eventReport = new EventsAndReports.EventReport(house, 1);
//
//
//        int round = 0;
//        while (round < 2){
//            devicesEvent();
//            sensorEvent();
//            addConsumption();
//            eventReport.addRound(round);
//            round++;
//        }
//        consumptionReport.generateReport();
//        houseConfigurationReport.generateReport();
//        activityAndUsageReport.generateReport();
//        eventReport.generateReport();
//    }
//
//
//    private void addConsumption() {
//        this.house.getFloors().forEach(f -> f.getRooms().forEach(room -> room.getDevices().forEach(Patterns.Device::addConsumption)));
//    }
//}
