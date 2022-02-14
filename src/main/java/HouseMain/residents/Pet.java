package HouseMain.residents;

import HouseMain.Room;

public class Pet{

    private Room room;
    private String name;


    private PetType type;


    public Pet(String name, PetType type) {
        this.name = name;
        this.type = type;
    }

    public Pet(Room room, String name) {
        this.room = room;
        this.name = name;
    }

    public PetType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void move(Room room){
        this.room.removePet(this);
        this.setRoom(room);
        this.room.addPet(this);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setName(String name) {
        this.name = name;
    }
}
