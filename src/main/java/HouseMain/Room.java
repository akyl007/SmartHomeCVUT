package HouseMain;

import Patterns.Device;
import HouseMain.residents.Person;
import HouseMain.residents.Pet;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private final String name;

    public Floor floor;
    private List<Device> devices;
    private List<Person> persons;
    private List<Pet> pets;
    private List<Window> windows;


    public Room(String name) {
        this.name = name;
        this.windows = new ArrayList<>();
        this.devices = new ArrayList<>();
        this.persons = new ArrayList<>();
        this.pets = new ArrayList<>();
        this.windows = new ArrayList<>();
    }

    public Room(String name, Floor floor) {
        this.name = name;
        this.floor = floor;
        this.floor.addRoom(this);
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void addPerson(Person person) {
        persons.add(person);
        person.setRoom(this);
    }

    public void removePerson(Person person) {
        persons.remove(person);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setRoom(this);
    }

    public void addWindow(Window window) {
        windows.add(window);
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public String getName() {
        return name;
    }

    public Floor getFloor() {
        return floor;
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }
}
