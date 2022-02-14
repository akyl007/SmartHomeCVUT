package HouseMain;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private final int level;
    private List<Room> rooms;

    public Floor(int level) {
        this.level = level;
        rooms = new ArrayList<>();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

}