package Application;

import HouseMain.Devices.*;
import HouseMain.Floor;
import HouseMain.House;
import HouseMain.Room;
import HouseMain.residents.Person;
import HouseMain.residents.Pet;
import Patterns.DeviceFactory;
import Patterns.ResidentFactory;

public class Config1 {

    public House config1(){
        House.getInstance();

        DeviceFactory deviceFactory = new DeviceFactory();

        Fridge fridge = deviceFactory.createFridge("fridge");
        Cookstove cookstove = deviceFactory.createCookstove("cook stove");
        Lamp lamp1 = deviceFactory.createLamp("lamp1");
        Lamp lamp2 = deviceFactory.createLamp("lamp2");
        Computer computer1 = deviceFactory.createComputer("computer1");
        Computer computer2 = deviceFactory.createComputer("computer2");
        CdPlayer cdPlayer = deviceFactory.createCdPlayer("cd player");
        Shower shower = deviceFactory.createShower("shower");
        WashingMachine washingMachine = deviceFactory.createWashingMachine("washing machine");
        Tv tv = deviceFactory.createTv("TV");


        Floor floor1 = new Floor(1);


        Room Kitchen = new Room("kitchen");
        Kitchen.addDevice(fridge);
        Kitchen.addDevice(cookstove);
        Kitchen.addDevice(lamp1);

        Room BedRoom1 = new Room("bedroom1");
        BedRoom1.addDevice(lamp2);
        BedRoom1.addDevice(cdPlayer);
        BedRoom1.addDevice(computer1);
        BedRoom1.addDevice(tv);

        Room BedRoom2 = new Room("bedroom2");
        BedRoom2.addDevice(lamp2);
        BedRoom2.addDevice(cdPlayer);
        BedRoom1.addDevice(computer2);
        BedRoom1.addDevice(tv);


        Room BathRoom = new Room("bathroom");
        BathRoom.addDevice(shower);
        BathRoom.addDevice(washingMachine);
        BathRoom.addDevice(lamp1);

        Room LivingRoom = new Room("livingRoom");
        LivingRoom.addDevice(tv);
        LivingRoom.addDevice(cdPlayer);
        LivingRoom.addDevice(lamp1);

        floor1.addRoom(Kitchen);
        floor1.addRoom(BedRoom1);
        floor1.addRoom(BedRoom2);
        floor1.addRoom(BathRoom);
        floor1.addRoom(LivingRoom);

        ResidentFactory rf = new ResidentFactory();
        Person father = rf.createFather();
        Person mother = rf.createMother();
        Person son = rf.createSon();
        Person daughter = rf.createDaughter();
        Person lson = rf.createLittleSon();
        Person ldaughter = rf.createLittleDaughter();
        Pet dog = rf.createDog();
        Pet cat = rf.createCat();


        Kitchen.addPerson(mother);
        BedRoom1.addPerson(son);
        BedRoom2.addPerson(daughter);
        LivingRoom.addPerson(ldaughter);
        LivingRoom.addPerson(lson);
        LivingRoom.addPet(cat);

        return House.getInstance();
    }




    public House config2(){
        House.getInstance();

        DeviceFactory deviceFactory = new DeviceFactory();

        Fridge fridge = deviceFactory.createFridge("fridge");
        Cookstove cookstove = deviceFactory.createCookstove("cook stove");
        Lamp lamp1 = deviceFactory.createLamp("lamp1");
        Lamp lamp2 = deviceFactory.createLamp("lamp2");
        Computer computer1 = deviceFactory.createComputer("computer1");
        Computer computer2 = deviceFactory.createComputer("computer2");
        CdPlayer cdPlayer = deviceFactory.createCdPlayer("cd player");
        CdPlayer specialCdPlayer = deviceFactory.createCdPlayer("special cd player");
        Shower shower = deviceFactory.createShower("shower");
        WashingMachine washingMachine = deviceFactory.createWashingMachine("washing machine");
        Tv tv = deviceFactory.createTv("TV");
        Tv bigTv = deviceFactory.createTv("TV");


        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);


        Room Kitchen = new Room("kitchen");
        Kitchen.addDevice(fridge);
        Kitchen.addDevice(cookstove);
        Kitchen.addDevice(lamp1);

        Room BedRoom1 = new Room("bedroom1");
        BedRoom1.addDevice(lamp2);
        BedRoom1.addDevice(cdPlayer);
        BedRoom1.addDevice(computer1);
        BedRoom1.addDevice(tv);

        Room BedRoom2 = new Room("bedroom2");
        BedRoom2.addDevice(lamp2);
        BedRoom2.addDevice(cdPlayer);
        BedRoom1.addDevice(computer2);
        BedRoom1.addDevice(tv);


        Room BathRoom = new Room("bathroom");
        BathRoom.addDevice(shower);
        BathRoom.addDevice(washingMachine);
        BathRoom.addDevice(lamp1);

        Room BathRoom2 = new Room("bathroom2");
        BathRoom2.addDevice(shower);
        BathRoom2.addDevice(washingMachine);
        BathRoom2.addDevice(lamp1);

        Room LivingRoom = new Room("livingRoom");
        LivingRoom.addDevice(tv);
        LivingRoom.addDevice(cdPlayer);
        LivingRoom.addDevice(lamp1);

        Room CinemaRoom = new Room("cinemaRoom");
        CinemaRoom.addDevice(bigTv);
        CinemaRoom.addDevice(specialCdPlayer);
        CinemaRoom.addDevice(lamp1);


        floor1.addRoom(Kitchen);
        floor1.addRoom(BathRoom);
        floor1.addRoom(LivingRoom);
        floor2.addRoom(BedRoom1);
        floor2.addRoom(BathRoom2);
        floor2.addRoom(BedRoom2);
        floor3.addRoom(CinemaRoom);

        ResidentFactory rf = new ResidentFactory();
        Person father = rf.createFather();
        Person mother = rf.createMother();
        Person son = rf.createSon();
        Person daughter = rf.createDaughter();
        Person lson = rf.createLittleSon();
        Person ldaughter = rf.createLittleDaughter();
        Pet dog = rf.createDog();
        Pet cat = rf.createCat();


        CinemaRoom.addPerson(mother);
        BathRoom.addPerson(father);
        BedRoom1.addPerson(son);
        BathRoom2.addPerson(daughter);
        LivingRoom.addPerson(ldaughter);
        LivingRoom.addPerson(lson);
        LivingRoom.addPet(cat);

        return House.getInstance();
    }

}
